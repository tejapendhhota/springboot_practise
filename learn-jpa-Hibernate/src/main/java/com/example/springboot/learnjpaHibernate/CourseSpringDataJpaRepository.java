package com.example.springboot.learnjpaHibernate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.learnjpaHibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long>{

}
