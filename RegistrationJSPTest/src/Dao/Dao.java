package Dao;
import bean.*;

import java.util.*;
import java.sql.*;

import Util.*;
public class Dao {
	Connection con=ConnectionProvider.getCon();
	public boolean isLoginDao(Login loginBean){
		boolean flag=false;
		String username=loginBean.getName();
		String password=loginBean.getPassword();
		System.out.println(username+"************&&&&&&***********"+password);
		
		try{
			//Connection con=ConnectionProvider.getCon();
			System.out.println(con.toString()+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			PreparedStatement ps=con.prepareStatement("select * from registeruser2 where usrName=? and usrpwd = ?");
			ps.setString(1, username);
			ps.setString(2, password);
		
			ResultSet rs=ps.executeQuery();
			flag=rs.next();
			//System.out.println(flag);
			//con.close();
			}catch(SQLException e){
			//System.out.println("In doa"+e);
			}
			System.out.println(flag);
			return flag;
	}
	
	public int register(Login loginBean){
		
		int register=-1;
		
		String name=loginBean.getName();
		String password=loginBean.getPassword();
		String email=loginBean.getEmail();
		String country=loginBean.getCountry();
		long num=loginBean.getNum();
		System.out.println("***************8"+loginBean.toString());
		
		try{
			//Connection con=ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("insert into registeruser2 (usrId,usrName,usrpwd,email,country,contact) values (ID_SEQ.NEXTVAL,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, country);
			ps.setLong(5, num);
			
			register=ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return register;
	}
	
	public ArrayList<Login> view(){
		ArrayList<Login> login=new ArrayList<Login>();
		
		try{
			PreparedStatement ps=con.prepareStatement("Select * from registeruser2");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Login loginBean=new Login();
				loginBean.setId(rs.getString(1));
				loginBean.setName(rs.getString(2));
				loginBean.setPassword(rs.getString(3));
				loginBean.setEmail(rs.getString(4));
				loginBean.setNum(rs.getLong(6));
				loginBean.setCountry(rs.getString(5));
				
				login.add(loginBean);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return login;
	}
	
	public boolean delete(int id){
		boolean flag=false;
		try{
			PreparedStatement ps=con.prepareStatement("delete from registeruser2 where usrId =?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			flag=rs.next();
		}catch(SQLException e1){
			e1.printStackTrace();}
		catch(Exception e2){
			e2.printStackTrace();}
		return flag;
	}

	public Login update(int id) {
		// TODO Auto-generated method stub
		Login bean=new Login();
		try{
			PreparedStatement ps=con.prepareStatement("select * from registeruser2 where usrId= ? ");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				bean.setId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setCountry(rs.getString(5));
				bean.setNum(rs.getLong(6));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return bean;
	}

	public int update(Login bean) {
		// TODO Auto-generated method stub
		int flag=-1;
		int id=Integer.parseInt(bean.getId());
		String name=bean.getName();
		String password=bean.getPassword();
		String email=bean.getEmail();
		String country=bean.getCountry();
		long num=bean.getNum();
		try{
			//Connection con=ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("update registeruser2 set usrName=?,usrpwd=?,email=?,country=?,contact=? where usrId=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, country);
			ps.setLong(5, num);
			ps.setInt(6, id);
			
			flag=ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return flag;
	}
}