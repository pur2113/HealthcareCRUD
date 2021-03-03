package com.paytm.learnwebapp.controller;

import java.io.IOException; 
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.paytm.learnwebapp.model.User;
import com.paytm.learnwebapp.service.UserService;

import jdk.internal.org.jline.utils.Log;

@SuppressWarnings("unused")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value = "/")
	@ResponseBody
	public String homepage()
	{
		String s="<br><br><center><h2>Welcome Home!</h3></center><br><h4><a href=\"localhost:8082/addProfile\">Add Profile</a></h4>";
		s=s+"<h4><a href=\"localhost:8082/updateProfile\">Update Profile</a></h4>";
		s=s+"<h4><a href=\"localhost:8082/deleteProfile\">Delete Profile</a></h4>";
		s=s+"<h4><a href=\"localhost:8082/getAll\">Show all profiles</a></h4>";
		//s=s+"<h4><a href=\"localhost:8082/getById\">Search By Id</a></h4>";
		//s=s+"<h4><a href=\"localhost:8082/getByJob\">Search By Job</a></h4>";
		//s=s+"<h4><a href=\"localhost:8082/getEmail\">Get User's Email</a></h4>";
		return s;
	}
	
	@GetMapping(value = "/getAll")
	@ResponseBody
	public List<String> getAll()
	{
		logger.trace("In the getAll function");
		return userService.fetchAll();
	}
	
//	@GetMapping(value = "/getById")
//	@ResponseBody
//	public String getById()
//	{
//		logger.trace("In the getById function");
//		String s="<html><head></head><body><h3>Search User By Id</h2>"
//				+"<form action=\"findByIdNext\">"
//				+ "Id : <input id=\"id\" name=\"id\"/><br>"
//				+ "<input type=\"submit\" value=\"Search\"/>"
//				+ "</form>"
//				+ "</body></html>";
//		return s;
//	}
//	@GetMapping(value = "/findByIdNext")
//	@ResponseBody
//	public String findProfileById(int id)
//	{
//		return userService.fetchById(id);	
//	}
//	
//	@GetMapping(value = "/getByJob")
//	@ResponseBody
//	public String getByProfile()
//	{
//		logger.trace("In the getByJob function");
//		String s="<html><head></head><body><h3>Search User By Job-Role</h2>"
//				+"<form action=\"findByJobNext\">"
//				+ "Jobrole : <input id=\"jobrole\" name=\"jobrole\"/><br>"
//				+ "<input type=\"submit\" value=\"Search\"/>"
//				+ "</form>"
//				+ "</body></html>";
//		return s;
//		
//	}
//	@GetMapping(value = "/findByJobNext")
//	@ResponseBody
//	public List<String> findbyProfile(String jobrole)
//	{
//		return userService.fetchByProfile(jobrole);
//	}
	
	@GetMapping(value = "/addProfile")
	@ResponseBody
	public String add()
	{
		logger.trace("In the addProfile function");
		String s="<html><head></head><body><h3>User Registration</h2>"
				+"<form action=\"adddata\">"
				+ "Id : <input id=\"id\" name=\"id\"/><br>"
				+ "Name : <input id=\"name\" name=\"name\"/><br>"
				+ "Job Role : <input id=\"jobrole\" name=\"jobrole\"/><br>"
				+ "Email : <input id=\"email\" name=\"email\"/><br>"
				+ "Phone : <input id=\"phone\" name=\"phone\"/><br>"
				+ "<input type=\"submit\" value=\"Register\"/>"
				+ "</form>"
				+ "</body></html>";
		return s;
		
	}
	@GetMapping(value = "/adddata")
	@ResponseBody
	public String addProfileNext(User user)
	{
		return userService.addProfile(user);
	}
	
	@GetMapping(value = "/updateProfile")
	@ResponseBody
	public String update()
	{
		logger.trace("In the updateProfile function");
		String s="<html><head></head><body><h3>Update User Information</h2>"
				+"<form action=\"updatedata\">"
				+ "Id : <input id=\"id\" name=\"id\"/><br>"
				+ "Name : <input id=\"name\" name=\"name\"/><br>"
				+ "Job Role : <input id=\"jobrole\" name=\"jobrole\"/><br>"
				+ "Email : <input id=\"email\" name=\"email\"/><br>"
				+ "Phone : <input id=\"phone\" name=\"phone\"/><br>"
				+ "<input type=\"submit\" value=\"Update\"/>"
				+ "</form>"
				+ "</body></html>";
		return s;
	}
	@GetMapping(value = "/updatedata")
	@ResponseBody
	public String updateProfileNext(User user)
	{
		return userService.editProfile(user, user.getId());
	}
	
	@GetMapping(value = "/deleteProfile")
	@ResponseBody
	public String delete()
	{
		logger.trace("In the deleteProfile function");
		String s="<html><head></head><body><h3>Delete User</h2>"
				+"<form action=\"deletedata\">"
				+ "Id : <input id=\"id\" name=\"id\"/><br>"
				+ "<input type=\"submit\" value=\"Delete\"/>"
				+ "</form>"
				+ "</body></html>";
		return s;
		
	}
	@GetMapping(value = "/deletedata")
	@ResponseBody
	public String deleteProfileNext(int id)
	{
		return userService.deleteProfile(id);	
	}
	
//	@GetMapping(value = "/getEmail")
//	@ResponseBody
//	public String getEmail()
//	{
//		logger.trace("In the getEmail function");
//		String s="<html><head></head><body><h3>Search User's Email</h2>"
//				+"<form action=\"getemailbyid\">"
//				+ "Id : <input id=\"id\" name=\"id\"/><br>"
//				+ "<input type=\"submit\" value=\"Search\"/>"
//				+ "</form>"
//				+ "</body></html>";
//		return s;
//		
//	}
//	@GetMapping(value = "/getemailbyid")
//	@ResponseBody
//	public String getEmailById(int id)
//	{
//		return userService.fetchEmail(id);	
//	}
//	
}
