package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.*;

import Service.*;
import bean.*;
public class ViewController extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String status=(String)req.getSession().getAttribute("Type");
		if(status==null&& !status.equalsIgnoreCase("true")){
			res.sendRedirect("Login.jsp?msg=plz login before moving forward.....");		
		}else{
			
		res.setContentType("text/html");
				
		LoginService loginService =new LoginService();
		ArrayList<Login> login=loginService.view();
		req.setAttribute("arraylist", login);
		
		req.getRequestDispatcher("View.jsp").include(req, res);
		}
	}
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String status=(String)req.getSession().getAttribute("Type");
		if(status==null&& !status.equalsIgnoreCase("true")){
			res.sendRedirect("Login.jsp?msg=plz login before moving forward.....");		
		}else{
		res.setContentType("text/html");
				
		LoginService loginService =new LoginService();
		ArrayList<Login> login=loginService.view();
		req.setAttribute("arraylist", login);
		
		req.getRequestDispatcher("View.jsp").include(req, res);
		}
	}
}
