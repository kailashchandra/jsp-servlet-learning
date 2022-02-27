package Service;
import bean.*;
import Dao.*;
public class RegisterService {
	public int register(Login loginBean){
		Dao dao=new Dao();
		int flag=dao.register(loginBean);
		return flag;
	}
}
