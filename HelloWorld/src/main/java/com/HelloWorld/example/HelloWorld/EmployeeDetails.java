package com.HelloWorld.example.HelloWorld;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeDetails {
	
	
	@RequestMapping("/employees")
	public List<Employee> retrievEmployee(){
		return Arrays.asList(
				new Employee(1, "Teja"),
				new Employee(2, "Test")
				);
		
	}

}
