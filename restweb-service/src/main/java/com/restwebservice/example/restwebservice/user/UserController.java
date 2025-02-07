package com.restwebservice.example.restwebservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

@RestController
public class UserController {
	
	private UsrDaoService service;
	
	public UserController(UsrDaoService service) {
		this.service = service;
	}
	
	@GetMapping(path = "/Users")
	public List<User> retrieveUsers(){
		return service.findAll();
	}

	@GetMapping(path = "/Users/{id}")
	public User retrieveUsers(@PathVariable Integer id ){
		User user = service.findUser(id);
		
		if (user==null)
			throw new UserNotFoundException("id:"+id);
		return user;
	}

	@PostMapping(path = "/Users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/Users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		service.deleteUser(id);
		//return service.findAll();
	}
	
}