package com.mk.test.designpattern.creational;

public class PrototypePattern {
    public static void main(String[] args){
        Person person = new Person("1", "Manoj Kumar");
        Person personPrototype = (Person) person.clone();
        System.out.println(person.getPersonName() + "---"+ personPrototype.getPersonName());
        System.out.println(person == personPrototype);
    }
}

class Person implements Cloneable{
    private String personId;
    private String personName;

    public Person (String personId, String personName){
        this.personId = personId;
        this.personName = personName;
    }
    public String getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    public Object clone(){
        Object clone  = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}


