package HiddenForm;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("name");
		String pass=req.getParameter("password");
		if((name!=null&&pass!=null)?(name.equals("kailash")&& pass.equals("a")): false){
			out.println("Welcome "+name);
			out.println("<a href='secondservlet?u="+name+"'>GoToNext</a>");
		//out.print("<form action='secondservlet' method='post'>");
		//out.print("<input type='hidden' name='n' value='"+name+"'/>");
		//out.print("<input type='hidden' name='p' value='"+pass+"'/>");
		//out.print("<input type='submit' name='GoToNext'>");
		//out.print("</form>");
			}
		else{
			out.println("Please enter correct Passowrd!!!!!!!!!");
			req.getRequestDispatcher("Index2.html").include(req,res);
		}
		out.close();
		
		
	}
}
