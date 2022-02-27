package SimpleRegistration;
import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
public class ViewServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		req.getRequestDispatcher("link.html").include(req, res);
		
		try{
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Kailash","Oracle92kailash");
			PreparedStatement ps=con.prepareStatement("select * from RegisterUser");
			ResultSet rs=ps.executeQuery();*/
			
			ServletContext context=getServletContext();
			List list=(List)context.getAttribute("tables");
			
			if(list!=null){
				Iterator itr=list.iterator();
			while(itr.hasNext()){
				User user=(User)itr.next();
				out.println("<br>"+user.getId()+" "+user.getName()+" "+user.getPassword()+" "+user.getEmail()+" "+user.getCountry()+" "+user.getNum());  
			}
			/*if(rs!=null){
				while(rs.next()){
					out.println("Record :"+rs.getString(1)+"   "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
				}*/
			}
			else{
				out.println("Unsuccessfully View!!!!Please check and try again");
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
