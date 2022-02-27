package CookiesLoginLogout; 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ProfileServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		//req.getRequestDispatcher("link.html").include(req, res);
		String name=req.getParameter("name");
		Cookie cookies[]=req.getCookies();
		if(cookies!=null ? (cookies[0].getValue().equals("kailash")) : false ){
			out.print("Successfully loged into profile!!! "+name);
			out.print("<a href="+"Logout"+">logout</a>");
		}
		else{
			out.println("Please enter correct password to login");
			req.getRequestDispatcher("Index.html").include(req, res);
		}
	}

}
