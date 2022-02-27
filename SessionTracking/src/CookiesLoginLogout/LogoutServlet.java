package CookiesLoginLogout; 
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		req.getRequestDispatcher("link.html").include(req, res);
		Cookie cookie=new Cookie("name","");
		cookie.setMaxAge(0);
		res.addCookie(cookie);
		out.println("You are successfully logedout!!!");
		req.getRequestDispatcher("Index.html").include(req,res);
		
	}
}
