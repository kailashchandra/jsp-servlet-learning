package beans;

public class User {
	private String usrid,usrname,usrpwd,email,country;
	private long contact;
	public String getUsrid() {
		return usrid;
	}
	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getUsrpwd() {
		return usrpwd;
	}
	public void setUsrpwd(String usrpwd) {
		this.usrpwd = usrpwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public User(String usrid, String usrname, String usrpwd, String email,
			String country, long contact) {
		super();
		this.usrid = usrid;
		this.usrname = usrname;
		this.usrpwd = usrpwd;
		this.email = email;
		this.country = country;
		this.contact = contact;
	}
	public User(){}
}
