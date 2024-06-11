package com.restwebservice.example.restwebservice;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Rest API
@RestController
public class HelloWorldController {

	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	// /hello-world
	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloworld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/helloWorld-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path = "/helloWorld-bean/path/{name}")
	public HelloWorldBean helloWorldPathVar(@PathVariable String name) {
		return new HelloWorldBean("Hello World" + name);
	}
	
	@GetMapping(path = "/helloWorld-greeting")
	public String HelloWorldGreet () {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default", locale);
	}
}
