package com.n8ify.prise.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/events/guest")
public class GuestController {
	
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manage(){
		return "event/guestmng";
	}
}
