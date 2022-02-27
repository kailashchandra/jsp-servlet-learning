package HttpSessionTest;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		req.getRequestDispatcher("linkHttp.html").include(req, res);
		HttpSession session=req.getSession();
		session.invalidate();
		req.getRequestDispatcher("Index3.html").include(req, res);
		out.close();
	}

}
