package com.restwebservice.example.restwebservice.user.Exception;

import java.time.LocalDate;

public class ErrorDetails {

	private LocalDate date;
	private String message;
	private String description;
	public ErrorDetails(LocalDate date, String message, String description) {
		super();
		this.date = date;
		this.message = message;
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	public String getDescription() {
		return description;
	}
	
	
	
	
}
