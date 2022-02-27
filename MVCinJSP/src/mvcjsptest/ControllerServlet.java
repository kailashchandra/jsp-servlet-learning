package mvcjsptest;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ControllerServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String name=req.getParameter("name");
		String pass=req.getParameter("password");
		
		MVCBean test=new MVCBean();
		req.setAttribute("obj",test);
		test.setName(name);
		test.setPass(pass);
		
		if(test.validate()){
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}
		else{
			RequestDispatcher rd=req.getRequestDispatcher("error.jsp");
			rd.forward(req, res);
		}
	}

}
