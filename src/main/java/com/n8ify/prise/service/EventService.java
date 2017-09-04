package com.n8ify.prise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n8ify.prise.entity.Event;
import com.n8ify.prise.entity.form.EventForm;
import com.n8ify.prise.repository.EventRepository;
import com.n8ify.prise.repository.UserRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	
	public void saveEvent(EventForm eventForm){
		Event event = new Event();
		event.setName(eventForm.getName());
		event.setDescription(eventForm.getDescription());
		event.setUser(userRepository.findOne(eventForm.getUserId()));
		eventRepository.save(event);
	}
	
	public List<Event> findAll(){
		return eventRepository.findAll();
	}

	public List<Event> findByUserId(int userId){
		return eventRepository.findByUserId(userId);
	}
}
