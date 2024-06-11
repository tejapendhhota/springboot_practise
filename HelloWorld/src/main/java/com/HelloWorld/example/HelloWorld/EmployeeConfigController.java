package com.HelloWorld.example.HelloWorld;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeConfigController {
	
	@Autowired
	private EmployeeConfiguration configuration;
	
	@RequestMapping("/employeesERVICE")
	public EmployeeConfiguration retrievEmployee(){
		return configuration;
		
	}
}
