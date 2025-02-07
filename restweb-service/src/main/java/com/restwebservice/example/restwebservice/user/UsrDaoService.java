package com.restwebservice.example.restwebservice.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UsrDaoService {
	
	//DataBase
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User("adam",1,LocalDate.now().minusYears(30)));
		users.add(new User("adam2",2,LocalDate.now().minusYears(20)));
		users.add(new User("adam3",3,LocalDate.now().minusYears(50)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		user.setId(6);
		users.add(user);
		return user;
		
	}
	
	public User findUser(int id){
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}
	
	public void deleteUser(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
		//return users.stream().filter(predicate).findFirst().;
		//users.remove(id);
		//r//eturn users;		
	}
}
