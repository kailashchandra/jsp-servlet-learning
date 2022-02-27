package Controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Service.*;
import bean.*;
public class UpdateController extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException{
		res.setContentType("text/html");
				
		int id=Integer.parseInt(req.getParameter("msg"));
		
		LoginService loginService=new LoginService();
		Login login=loginService.update(id);
		req.setAttribute("login", login);
		req.getRequestDispatcher("Update.jsp").include(req, res);
	}

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		Login bean=new Login();
		
		String id=req.getParameter("id");
		bean.setId(id);
		String name=req.getParameter("name");
		bean.setName(name);
		String password=req.getParameter("pass");
		bean.setPassword(password);
		String email=req.getParameter("email");
		bean.setEmail(email);
		String country=req.getParameter("country");
		bean.setCountry(country);
		long num=Long.parseLong(req.getParameter("contact"));
		bean.setNum(num);
		
		LoginService loginService=new LoginService();
		int flag=loginService.update(bean);
		
		if(flag>0){
			out.print("Successully updated***");
			req.getRequestDispatcher("/ViewController").include(req, res);
		}
		else{
			out.println("Not updated.....");
			req.getRequestDispatcher("/ViewController").include(req, res);
		}
			
	}
}

