package HttpSessionTest;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class sample  extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("Welcome for sample****");
		out.close();

	}
}