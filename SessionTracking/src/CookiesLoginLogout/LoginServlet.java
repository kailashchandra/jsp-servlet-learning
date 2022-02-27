package CookiesLoginLogout;  
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		//System.out.println("Kailash test**************************");
		String name=req.getParameter("name");
		String pass=req.getParameter("password");
		req.getRequestDispatcher("link.html").include(req, res);
		if(pass.equals("aaa")&&name.equals("kailash")){
			Cookie cookie=new Cookie("name", name);
			res.addCookie(cookie);
			//System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
			out.print("Successfully logged in...");
			//System.out.println("==========================================");
			//req.getRequestDispatcher("profileservlet").forward(req, res);
		}
		else{
			out.print("Incorrect Password or Please login");
			req.getRequestDispatcher("Index.html").include(req, res);
		}
		out.close();
	}
}
