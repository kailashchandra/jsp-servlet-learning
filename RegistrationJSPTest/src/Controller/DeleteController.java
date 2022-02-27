package Controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Service.*;
public class DeleteController extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		int id=Integer.parseInt(req.getParameter("msg"));
		LoginService loginService=new LoginService();
		boolean flag=loginService.delete(id);
		if(flag){
			out.println("Successfully Deleted.....");
			req.getRequestDispatcher("/ViewController").include(req, res);
		}else{
			out.println("Haven't deleted due to some errror...");
			req.getRequestDispatcher("/ViewController").include(req, res);
		}
	}
}
