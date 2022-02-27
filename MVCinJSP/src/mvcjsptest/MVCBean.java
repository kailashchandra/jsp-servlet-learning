package mvcjsptest;
public class MVCBean {
	String name;
	String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public boolean validate(){
		if(name.equals("admin")){
			return true;
		}
		else{
			return false;
		}
	}
}
