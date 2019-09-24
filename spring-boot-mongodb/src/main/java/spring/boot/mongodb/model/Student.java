package spring.boot.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student_details")
public class Student {
     @Id
     public String id;
     public String firstName;
     public String lastName;

     public Student() {
     }
     public Student(String firstName, String lastName) {
           this.firstName = firstName;
           this.lastName = lastName;
     }
     public String toString() {
           return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
     }
}