package com.n8ify.prise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n8ify.prise.entity.Guest;
import com.n8ify.prise.entity.form.GuestForm;
import com.n8ify.prise.repository.GuestRepository;

@Service
public class GuestService {
	
	@Autowired
	private GuestRepository guestRepository;
	
	public List<Guest> findByEventId(int eventId){
		return guestRepository.findByEventId(eventId);
	}
	
	public void saveGuest(GuestForm guestForm){
		Guest guest = new Guest();
		guest.setName(guestForm.getName());
		guest.setPosition(guestForm.getPosition());
		guest.setCorp(guestForm.getCorp());
		guest.setPortraitPath(guestForm.getPortraitPath());
		guest.setAwardNo(guestForm.getAwardNo());
		guest.setAward(guestForm.getAward());
		guest.setSeatNo(guestForm.getSeatNo());
		guest.setSeatRow(guestForm.getSeatRow());
		guest.setStatus(guestForm.getStatus());
		guest.setEventId(guestForm.getEventId());
		guestRepository.save(guest);
	}
}
