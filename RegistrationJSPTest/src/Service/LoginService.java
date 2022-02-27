package Service;
import bean.*;

import java.util.*;

import Dao.*;
public class LoginService {
	Dao dao =new Dao();
	public boolean isLoginService(Login loginBean ){
		
		//Dao loginDao=new Dao();
		Boolean flag=dao.isLoginDao(loginBean);
		return flag;
	}
	
	public ArrayList<Login> view(){
		//Dao dao=new Dao();
		ArrayList <Login> login= dao.view();
		return login;
	}
	
	public boolean delete(int id){
		//Dao doa=new Dao();
		boolean flag=dao.delete(id);
		return flag;
	}

	public Login update(int id) {
		// TODO Auto-generated method stub
		//Dao doa=new Dao();
		Login flag=dao.update(id);
		return flag;
	}

	public int update(Login bean) {
		// TODO Auto-generated method stub
		int flag=dao.update(bean);
		return flag;
	}
}
