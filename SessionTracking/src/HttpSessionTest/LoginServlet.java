package HttpSessionTest;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		req.getRequestDispatcher("linkHttp.html").include(req, res);
		String name=req.getParameter("uname");
		String pass=req.getParameter("pass");
		//System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+name+"&&&&&&&&&&"+pass);
		if((name!=null&&!name.isEmpty()&&pass!=null&&!pass.isEmpty())?(name.equals("kailash")&&pass.equals("a")):false){
			out.print("Welcome*******"+name);
			HttpSession session=req.getSession();
			session.setAttribute("un", name);
		}
		else{
			out.println("Please enter Correct Password!!!!!!!!!!!!"+name+"  ****");
			req.getRequestDispatcher("Index3.html").include(req, res);
		}
		out.close();
	}
}