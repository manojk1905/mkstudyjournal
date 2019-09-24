package spring.boot.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.boot.mongodb.dao.StudentRepository;
import spring.boot.mongodb.model.Student;

@Component
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getStudent(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

}
