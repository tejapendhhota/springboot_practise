package com.example.springboot.learnjpaHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.springboot.learnjpaHibernate.course.Course;

@Repository
public class CourseJdbcRepo {
	
	@Autowired
	private JdbcTemplate springjdbcTemplate;
	
	private static String INSERT_QUERY = 
			
			"""
			   insert into course values (?,?, ?);
			
			""";
	private static String DELETE_QUERY = 
			
			"""
			   delete from course where id=?;
			
			""";
	
	public void insert(Course course) {
		springjdbcTemplate.update(INSERT_QUERY, course.getId(),course.getName(),course.getAuthor());
		
	}
	
	public void delete(Course course) {
		springjdbcTemplate.update(DELETE_QUERY, course.getId());
		
	}
}
