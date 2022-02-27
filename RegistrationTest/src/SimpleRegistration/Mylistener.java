package SimpleRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.servlet.*;

public class Mylistener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	System.out.println("project undeployed");
    }

    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	ArrayList<User> arrlist=new ArrayList<User>();
    	try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Kailash","Oracle92kailash");
			PreparedStatement ps=con.prepareStatement("select * from RegisterUser2");
			ResultSet rs=ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					User user=new User();
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));  
					user.setPassword(rs.getString(3));
					user.setEmail(rs.getString(4));
					user.setCountry(rs.getString(5));
					user.setNum(rs.getLong(6));
					arrlist.add(user);
				}
			}
			else{
				System.out.println("Unsuccessfully Register!!!!Please check and try again");
			}
		}
		catch(Exception e){
			System.out.println("Exception**"+e);
		}
		finally{
			ServletContext context=arg0.getServletContext();
			context.setAttribute("tables",arrlist);
			System.out.println("Inside the finally block");
		}
    }
	
}
