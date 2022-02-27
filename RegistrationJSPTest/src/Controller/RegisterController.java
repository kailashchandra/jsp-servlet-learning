package Controller;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import Service.LoginService;
import Service.RegisterService;
import bean.*;
public class RegisterController extends HttpServlet {

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		String status=(String)req.getSession().getAttribute("Type");
		if(status==null || status.equalsIgnoreCase("false")){
			res.sendRedirect("Login.jsp?msg=plz login before moving forward.....");		
		}else{
			
		
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String name=req.getParameter("name");
		String password=req.getParameter("pass");
		String email=req.getParameter("email");
		String Country=req.getParameter("country");
		long num=Long.parseLong(req.getParameter("contact"));
		
		Login loginbean=new Login();
		loginbean.setName(name);
		loginbean.setPassword(password);
		loginbean.setEmail(email);
		loginbean.setCountry(Country);
		loginbean.setNum(num);
		
		RegisterService registerService=new RegisterService();
		int register=registerService.register(loginbean);
		
		if(register>0){
			out.println("Successfully Registered");
			req.getRequestDispatcher("Register.jsp").include(req, res);
			}
		else{
			out.println("Please provide information again.....didn't register!!");
			req.getRequestDispatcher("Register.jsp").include(req, res);
		}
		}

	}
}
