package HiddenForm;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SecondServlet extends HttpServlet{
	//public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("u");
		//System.out.println("*********************"+name);
		//String pass=req.getParameter("p");
		out.print("Welcome after clicking "+name);
		out.close();
	}

}




