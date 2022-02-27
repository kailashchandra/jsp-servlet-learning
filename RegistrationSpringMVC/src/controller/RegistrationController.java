package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.RegistrationDao;
import beans.User;

@Controller
public class RegistrationController {

	@Autowired
	RegistrationDao registrationDao;
		
	@RequestMapping("/")
	public ModelAndView loginForm(){
		return new ModelAndView("Login","command", new User());
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute User user){
		ModelAndView model=new ModelAndView();
		boolean flag=false;
		if(!(user.getUsrname().isEmpty()) && !(user.getUsrpwd().isEmpty())){
			flag=registrationDao.validate(user);
			if(flag){
				//session.setAttribute("userName", user.getUsrname());
				model.setViewName("forward:/Registration");
				
			}			
			else{
				model.addObject("command", new User());
				model.addObject("msg", "Invalide user name and password");
				model.setViewName("Login");
				
			}
		}
		else{
			model.addObject("command", new User());
			model.addObject("msg","Pleaes provide credential");
			model.setViewName("Login");
			
		}
		return model;
	}
	
	@RequestMapping("/Registration")
	public ModelAndView registrationForm(){
		return new ModelAndView("RegistrationForm", "command", new User());
	}
	
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute User user){
		ModelAndView model=new ModelAndView();
		int flag=0;
		if((user.getContact()!=0) && !(user.getUsrname().isEmpty()) && !(user.getUsrpwd().isEmpty()) && !(user.getEmail().isEmpty()) && !(user.getCountry().isEmpty())){
			flag=registrationDao.insert(user);
			if(flag>0){
				model.addObject("command", new User());
				model.addObject("msg", "successfully register!!!");
				model.setViewName("forward:/ViewUser");
			}
			else{
				model.addObject("command", new User());
				model.addObject("msg", "Not registered!!");
				model.setViewName("forward:/Registration");
			}
		}
		else{
			model.addObject("command", new User());
			model.addObject("msg", "Please provide details to register!!");
			model.setViewName("forward:/Registration");
		}
		return model;
	}
	
	@RequestMapping("/ViewUser")
	public ModelAndView ViewUser(){
		ModelAndView model=new ModelAndView();
		List<User> users=registrationDao.getUsers();
		model.addObject("users", users);
		model.setViewName("ViewUser");
		return model;
	}
	
	@RequestMapping("/editUser/{usrid}")
	public ModelAndView editform(@PathVariable int usrid){
		User user=registrationDao.getUser(usrid);
		return new ModelAndView("EditUser", "command", user);
	}
	
	@RequestMapping(value= "/edit",method=RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute User user){
		ModelAndView model=new ModelAndView();
		int flag=0;
		if((user.getContact()!=0) && !(user.getUsrname().isEmpty()) && !(user.getUsrpwd().isEmpty()) && !(user.getEmail().isEmpty()) && !(user.getCountry().isEmpty())){
			flag=registrationDao.updateUser(user);
			if(flag>0){
				model.addObject("command", new User());
				model.addObject("msg", "successfully Updated!!!");
				model.setViewName("forward:/ViewUser");
			}
			else{
				model.addObject("command", new User());
				model.addObject("msg", "Not Updated!!");
				model.setViewName("forward:/Registration");
			}
		}
		else{
			model.addObject("command", new User());
			model.addObject("msg", "Please provide details to register!!");
			model.setViewName("forward:/Registration");
		}
		return model;
	}
	
	@RequestMapping("/deleteUser/{usrid}")
	public ModelAndView deleteForm(@PathVariable int usrid){
		
		int flag=registrationDao.deleteUser(usrid);
		System.out.println(flag);
		ModelAndView model=new ModelAndView();
		if(flag>0){
			System.out.println("Test");
			model.addObject("msg", "Successfully deleted");
			model.setViewName("redirect:/ViewUser");
			return model;
		}
		else{
			model.addObject("msg", "Not deleted");
			model.setViewName("redirect:/ViewUser");
			return model;
		}
	}
}
