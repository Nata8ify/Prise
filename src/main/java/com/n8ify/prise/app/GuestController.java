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

import com.n8ify.prise.entity.form.GuestForm;
import com.n8ify.prise.service.EventService;
import com.n8ify.prise.service.GuestService;

@Controller
@RequestMapping(value = "/guest")
public class GuestController {

	Logger logger = LoggerFactory.getLogger(GuestController.class);
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String manage(HttpServletRequest request, Model model, GuestForm guestForm){
		logger.info(guestForm.toString());
		guestService.saveGuest(guestForm);
		return "redirect:/view/"+(guestForm.getEventId());
	}
	
	
}
