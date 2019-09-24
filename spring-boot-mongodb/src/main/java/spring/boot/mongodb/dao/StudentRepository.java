package spring.boot.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.boot.mongodb.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
	 
     public List<Student> findByFirstName(String firstName);
     public List<Student> findByLastName(String lastName);
}