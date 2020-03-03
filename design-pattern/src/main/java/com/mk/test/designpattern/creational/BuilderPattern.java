package com.mk.test.designpattern.creational;

public class BuilderPattern {
    public static void main(String[] args) {
        Student student = new Student.Builder().buildId("123").buildName("Manoj", "Kumar").build();
        System.out.println(student.getFirstName());
    }

}

class Student{
    private String stdId;
    private String firstName;
    private String lastName;

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static class Builder {
        private String stdId;
        private String firstName;
        private String lastName;
        public Builder buildId(String stdId){
            this.stdId = stdId;
            return this;
        }
        public Builder buildName(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
            return this;
        }
        public Student build(){
            Student student = new Student();
            student.stdId = this.stdId;
            student.firstName = this.firstName;
            student.lastName = this.lastName;
            return student;
        }
    }
}
