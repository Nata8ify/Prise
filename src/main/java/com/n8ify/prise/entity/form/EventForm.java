package com.n8ify.prise.entity.form;

import lombok.Data;

@Data
public class EventForm {
	private int id;
	private String name;
	private String description;
	private int userId;
}
