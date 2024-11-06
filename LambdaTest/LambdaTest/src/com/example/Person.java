package com.example;

import java.util.*;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;

    public Person(String firstName, String lastName,
                  int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return "Name: " + firstName + " " + lastName + "\n"
             + "Age: " + age + "  Gender: " + gender + "\n";
    }

    public static List<Person> createList() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Sean", "Cheng", 43, Gender.MALE));
        people.add(new Person("Bob", "Baker", 21, Gender.MALE));
        people.add(new Person("Jane", "Doe", 35, Gender.FEMALE));
        people.add(new Person("John", "Doe", 27, Gender.MALE));
        people.add(new Person("James", "Johnson", 45, Gender.MALE));
        people.add(new Person("Betty", "Jones", 33, Gender.FEMALE));
        people.add(new Person("Ivy", "Wang", 23, Gender.FEMALE));
        people.add(new Person("Nicole", "Wei", 42, Gender.FEMALE));
        return people;
    }
  
}
