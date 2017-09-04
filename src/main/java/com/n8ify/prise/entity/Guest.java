package com.n8ify.prise.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "event_guest")
public class Guest {
	@Id
	private int guestId;
	
	private String name;
	private String corp;
	private String position;
	private String portraitPath;
	private int awardNo;
	private String award;
	private int seatNo;
	private String seatRow;
	private int status;
	private int eventId;
}
