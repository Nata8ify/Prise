package com.n8ify.prise.app;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.n8ify.prise.entity.User;
import com.n8ify.prise.entity.form.EventForm;
import com.n8ify.prise.service.EventService;
import com.n8ify.prise.service.GuestService;

@Controller
@RequestMapping(value = "/events")
public class EventController {
	
	Logger logger = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(HttpServletRequest request, Model model){
		model.addAttribute("events", eventService.findByUserId(((User)request.getSession(false).getAttribute("user")).getId()));
		return "event/events";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute EventForm eventForm){
		logger.info(eventForm.toString());
		eventService.saveEvent(eventForm);
		return "redirect:/events/";
	}
	
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String view(HttpServletRequest request, Model model, @PathVariable("id") int id){
		model.addAttribute("event",eventService.findById(id));
		return "event/event";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, @PathVariable(name = "id") int id){
		eventService.deleteEvent(id);
		return "redirect:/event/";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, @PathVariable(name = "id") int id){
		eventService.deleteEvent(id);
		return "redirect:/event/";
	}
	
	@RequestMapping(value = "/manage/{id}", method = RequestMethod.GET)
	public String manage(HttpServletRequest request, Model model, @PathVariable("id") int id){
		model.addAttribute("event", eventService.findById(id));
		model.addAttribute("guests", guestService.findByEventId(id));
		return "event/eventmng";
	}
}
