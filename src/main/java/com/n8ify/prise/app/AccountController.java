package com.n8ify.prise.app;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.n8ify.prise.entity.User;
import com.n8ify.prise.entity.form.UserForm;
import com.n8ify.prise.service.EventService;
import com.n8ify.prise.service.UserService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "signin", method = RequestMethod.POST)
	public String signin(HttpServletRequest request, @ModelAttribute UserForm userForm, Model model){
		User user = userService.getUser(userForm.getUsername(), userForm.getPassword());
		if(user != null){
			request.getSession(true).setAttribute("user", user);
			model.addAttribute("events", eventService.findAll());
			return "redirect:/events/";	
		} else {
			return "redirect:/";	
		}
		
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute UserForm userForm){
		userService.saveUser(userForm);
		return "redirect:/";
	}
	
	@RequestMapping(value = "signout", method = RequestMethod.GET)
	public String signout(HttpServletRequest request){
		request.getSession(false).invalidate();
		return "redirect:/";
	}

}
