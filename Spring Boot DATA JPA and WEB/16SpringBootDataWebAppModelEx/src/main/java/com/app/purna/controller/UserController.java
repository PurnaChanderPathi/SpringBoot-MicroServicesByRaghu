package com.app.purna.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.purna.bean.User;



@Controller
public class UserController {
	// Path /info , Method: Get
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	//@GetMapping("/info")
	public String showUserPage(
			//Model model this is standard
			//ModelMap model
			Map<String, Object> model
			)
	{
		System.out.println(model.getClass().getName());
		
//		model.addAttribute("uname", "AJAY RAJ"); //for Model and ModelMap
//		model.addAttribute("cname", "SBMS");
		
		model.put("uname", "PATHI"); // for Map
		model.put("cname", "MICRO SERVICES");
		return "UserHome";
	}
	
	//Sending one user object
	@RequestMapping(value = "obj",method = RequestMethod.GET)
	public String showUserOb(Model model)
	{
		User user = new User(10,"AJAY RAJ!","TAG-SY");
		model.addAttribute("obj", user);
		
		List<User> list = Arrays.asList(
				new User(10, "AA", "XYZ"),
				new User(11, "AB", "XYZ"),
				new User(12, "AC", "MNO"),
				new User(13, "AD", "MNO")
				);
		model.addAttribute("listobj", list);
		return "UserData";
	}

}
