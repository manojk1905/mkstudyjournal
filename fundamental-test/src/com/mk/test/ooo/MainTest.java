package com.mk.test.ooo;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person>{
    private String id;
    private String name;
    Person(String id, String name){
        this.id = id;
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}
public class MainTest {

    public static void main(String[] args){
        Set<Person> treeSet = new TreeSet<>();
        System.out.println(treeSet.add(new Person("1", "Manoj")));
        System.out.println(treeSet.add(new Person("2", "Anuraag")));
        System.out.println(treeSet.add(new Person("3", "Manoj")));
        System.out.println(treeSet.size());
    }
}
