package ServletAnnotationTest;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/simple")
public class AnnotationTest extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("Hello Annotation Test                 !!!!!!!!!!!!!!!!!");
	}
}
