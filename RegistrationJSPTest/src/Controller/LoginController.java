package Controller;
import java.io.*;
import bean.*;
import Service.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		PrintWriter out= res.getWriter();
		res.setContentType("text/html");//this will set the responce type otherwise we r getting source code on login which incorrect pass.
		String username=req.getParameter("name");
		String password=req.getParameter("password");
		
		Login loginBean=new Login();
		loginBean.setName(username);
		loginBean.setPassword(password);
		
		LoginService loginService=new LoginService();
		Boolean flag=loginService.isLoginService(loginBean);
		
		HttpSession session=req.getSession();
		session.setAttribute("Type", flag.toString());
		
		if(flag){
			req.getRequestDispatcher("Admin.jsp").forward(req, res);;
		}else{
			out.print("Invalid User Name and Password !<br> ");
			req.getRequestDispatcher("Login.jsp").include(req,res);
			//res.sendRedirect("Login.jsp?msg=Invalid user name and id!");
		}
		
	}
}
