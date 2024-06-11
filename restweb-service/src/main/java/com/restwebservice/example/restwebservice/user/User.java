package com.restwebservice.example.restwebservice.user;

import java.time.LocalDate;

public class User {
	private String name;
	private Integer Id;
	private LocalDate birthDate;
	
	public User(String name, Integer id, LocalDate birthDate) {
		super();
		this.name = name;
		Id = id;
		this.birthDate = birthDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", Id=" + Id + ", birthDate=" + birthDate + "]";
	}
	
	
}
