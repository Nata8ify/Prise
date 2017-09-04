package com.n8ify.prise.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	
	@Id
	private int id;
	
	private String name;
	private String email;
	private String tel;
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "user", cascade =CascadeType.ALL)
	private List<Event> events;
}
