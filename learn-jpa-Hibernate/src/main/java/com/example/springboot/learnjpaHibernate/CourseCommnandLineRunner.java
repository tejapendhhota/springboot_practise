package com.example.springboot.learnjpaHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springboot.learnjpaHibernate.course.Course;

@Component
public class CourseCommnandLineRunner implements CommandLineRunner {
	
	//@Autowired
	//private CourseJdbcRepo repo;
	
	//@Autowired
	//private CourseJpaRepo repo;
	
	@Autowired
	private CourseSpringDataJpaRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Course(1,"Test","test"));
		repo.save(new Course(2,"Test","test"));
		repo.deleteById(1l);
	}
	
	

}
