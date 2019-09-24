package spring.boot.mongodb.interaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.mongodb.model.Student;
import spring.boot.mongodb.service.StudentService;

@RestController
public class StudentDataEndpoint {

	@Autowired
	private StudentService studentService;
	
    @GetMapping("/getStudentData")
    public List<Student> getStudentData(@RequestParam String firstName) {
    	return studentService.getStudent(firstName);
    }
    
    @PostMapping("/saveStudentData")
    public Student gsaveStudentData(@RequestBody Student student) {
    	return studentService.saveStudent(student);
    }
}

