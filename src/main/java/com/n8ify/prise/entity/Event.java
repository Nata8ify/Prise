package com.n8ify.prise.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "event")
public class Event {
	
	@Id
	private int id;
	
	private String name;
	private String description;
	//private int userId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
