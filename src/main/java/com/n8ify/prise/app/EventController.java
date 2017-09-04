package com.n8ify.prise.app;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.n8ify.prise.entity.User;
import com.n8ify.prise.entity.form.EventForm;
import com.n8ify.prise.service.EventService;

@Controller
@RequestMapping(value = "/event")
public class EventController {
	
	Logger logger = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(HttpServletRequest request, Model model){
		model.addAttribute("events", eventService.findByUserId(((User)request.getSession(false).getAttribute("user")).getId()));
		return "event/event";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute EventForm eventForm){
		logger.info(eventForm.toString());
		eventService.saveEvent(eventForm);
		return "redirect:/event/";
	}
}
