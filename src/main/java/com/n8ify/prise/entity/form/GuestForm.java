package com.n8ify.prise.entity.form;

import lombok.Data;

@Data
public class GuestForm {
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
