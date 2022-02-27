package HttpSessionTest;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		req.getRequestDispatcher("linkHttp.html").include(req, res);;
		HttpSession session=req.getSession(false);
		if(session!=null){
		String name=(String)session.getAttribute("un");
		if(name!=null){
			out.println("Welcome at Profile "+name);
		}}
		else{
			out.println("Before Going to profile Plz Login First");
			req.getRequestDispatcher("Index3.html").include(req, res);
		}
		out.close();
	}

}
