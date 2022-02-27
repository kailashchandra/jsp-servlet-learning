package Util;
import java.sql.*;
import static Util.Provider.*;
public class ConnectionProvider {
	private static Connection con=null;
	//private ConnectionProvider(){}
	static{
		try{
				Class.forName(DRIVER); /* If you get error null pointer exception or class not found exception here
				then you neeed to add jar file 1. build path of project 2.in run configuration of project
				 such as bootstrep 3. in deployment assembely in */
				con=DriverManager.getConnection(CONNECTION_URL,USER,PASSWORD);		
			}catch(SQLException e){System.out.println(e);}
			catch(ClassNotFoundException e1){e1.printStackTrace();System.out.println(e1);}
			catch(Exception e2){System.out.println(e2);}
	}  
	  	  
	public static Connection getCon(){ 
		return con;  
	}
}
