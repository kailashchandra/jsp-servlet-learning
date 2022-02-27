package dao;
/*Upgradation for Hibernate Template... to JDBC Template....*/
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OraclePreparedStatement;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.orm.hibernate3.HibernateTemplate;
import beans.User;

public class RegistrationDao {

	//private JdbcTemplate Template;
	
	private HibernateTemplate Template;

	//public void setTemplate(JdbcTemplate template) {
	
	public void setTemplate(HibernateTemplate template) {
		this.Template = template;
	} 
	
	public boolean validate(final User user){
		boolean flag2=false;
		//flag2=Template.execute("select * from registeruser2 where usrName=? and usrpwd = ?", new PreparedStatementCallback<Boolean>() {
		
		flag2=Template.execute("select * from registeruser2 where usrName=? and usrpwd = ?", new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				boolean flag=false;
				// TODO Auto-generated method stub
				ps.setString(1, user.getUsrname());
				ps.setString(2, user.getUsrpwd());
				ResultSet rs= ps.executeQuery();
				flag=rs.next();
				return flag;
			}
		});
		return flag2;
	}
	
	public int insert(User user){
		return Template.update("insert into registeruser2(usrId,usrName,usrpwd,email,country,contact) values(ID_SEQ.NEXTVAL,'"+user.getUsrname()+"','"+user.getUsrpwd()+"','"+user.getEmail()+"','"+user.getCountry()+"',"+user.getContact()+")");
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers(){
		return (List<User>) Template.query("select * from registeruser2", new ResultSetExtractor<List<User>>(){

			@Override
			public List<User> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				List<User> users=new ArrayList<User>();
				while(rs.next()){
					User user=new User();
					user.setUsrid(rs.getString(1));
					user.setUsrname(rs.getString(2));
					user.setUsrpwd(rs.getString(3));
					user.setEmail(rs.getString(4));
					user.setCountry(rs.getString(5));
					user.setContact(rs.getLong(6));
					users.add(user);
				}
				return users;
			}
			
		});
		
	}
	
	public User getUser(int usrid){
		return Template.queryForObject("select * from registeruser2 where usrid=?", new Object[]{usrid}, new BeanPropertyRowMapper<User> (User.class));
	}
	
	public int updateUser(User user){
		return Template.update("update registeruser2 set usrName='"+user.getUsrname()+"', usrpwd='"+user.getUsrpwd()+"', email='"+user.getEmail()+"', contact='"+user.getContact()+"', country='"+user.getCountry()+"' where usrid="+user.getUsrid());
	}
	
	public int deleteUser(int usrid){
		return Template.update("delete from registeruser2 where usrid='"+usrid+"'");
	}
}
