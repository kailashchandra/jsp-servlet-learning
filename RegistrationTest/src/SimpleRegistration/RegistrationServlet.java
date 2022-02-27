package SimpleRegistration;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
public class RegistrationServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		req.getRequestDispatcher("link.html").include(req, res);
		
		String name=req.getParameter("name");
		String pass=req.getParameter("password");
		String email=req.getParameter("email");
		String country=req.getParameter("country");
		long num=Long.parseLong(req.getParameter("num"));
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Kailash","Oracle92kailash");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Kailash","admin");
			PreparedStatement ps=con.prepareStatement("insert into registeruser2 values(ID_SEQ.NEXTVAL,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,pass);
			ps.setString(3,email);
			ps.setString(4,country);
			ps.setLong(5,num);
			int i=ps.executeUpdate();
			if(i>0){
				out.println("Successfully Register");
				req.getRequestDispatcher("Registration.html").include(req, res);
			}
			else{
				out.println("Unsuccessfully Register!!!!Please check and try again");
				req.getRequestDispatcher("Registration.html").include(req, res);
			}
		}
		catch(Exception e){
			System.out.println("Exception**"+e);
		}
		finally{
			out.close();
			System.out.println("Inside the finally block");
		}
	}
}
