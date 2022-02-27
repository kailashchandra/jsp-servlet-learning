package HttpSessionTest;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FilterTest implements Filter{
	public FilterConfig config;
	public void init(FilterConfig config)throws ServletException{
		this.config=config;
		System.out.println("+++++++++++++++++++++++++++Init Method++++++++++++++++++++");
		
	}
	
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain filterchain)throws IOException,ServletException{
		PrintWriter out=res.getWriter();
		int count=0;
		res.setContentType("text/html");
		String name=req.getParameter("uname");
		//System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++"+name);
		String pass=req.getParameter("pass");
		String parm=config.getInitParameter("p1");
		//System.out.println("++++++++++++++++++++++++++++isempty***+++++++++++++++++++"+name.isEmpty());
		long before=System.currentTimeMillis();
		if(name!=null&&!name.isEmpty()&&parm!=null&&pass!=null&&!pass.isEmpty()){
			//System.out.println("****************************before*************************");
			filterchain.doFilter(req, res);
			//System.out.println("****************************after*************************");
			out.print("<h2> Param value is </h2>");
			long after=System.currentTimeMillis();
			out.print(" total responce time is "+(before-after));
			out.print(" No of visitor over site is ______"+(++count));//;
		}
		else{
			out.println("Please don't leave fill something inside username or password");
			out.println("Param value is "+parm);
			req.getRequestDispatcher("Index3.html").include(req, res);
		}
	}

	public void destroy() {
		System.out.println("*************************Destroy method***************************");		
	}
}
