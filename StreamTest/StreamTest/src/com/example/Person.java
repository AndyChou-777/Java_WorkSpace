package com.example;

import java.util.*;

public class Person implements Comparable<Person>{
    private String name;
    private City city;
    private int age;
    private Gender gender;
    private String email;
    private String phone;    

    public Person(String name, City city, int age,
                 Gender gender, String email, String phone) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }
    
    public Gender getGender() {
        return gender;
    }

    public int getAge(){
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }  

    @Override
    public String toString(){
        return String.format("%s(%d)%s", name, age, city);
    }
    
    @Override
	public int compareTo(Person p) {
		return p.getName().compareTo(name);
	}
    
    public int compareAgeTo(Person p) {
		return this.name.compareTo(p.getName());
	}
    
    public int compareCityTo(Person p) {
		return p.getCity().compareTo(city);
	}

	public static List<Person> createList() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Sean", City.Taipei, 43, Gender.MALE, "sean@gmail.com", "02-2876-5432"));
        people.add(new Person("Bob", City.Kaohsiung, 21, Gender.MALE, "bob@gmail.com", "07-6655-4433"));
        people.add(new Person("Jane", City.Tainan, 35, Gender.FEMALE, "jane@gmail.com", "06-654-321"));
        people.add(new Person("John", City.Taipei, 27, Gender.MALE, "john@gmail.com", "02-2345-6789"));
        people.add(new Person("James", City.Tainan, 45, Gender.MALE, "james@gmail.com", "06-275-7575"));
        people.add(new Person("Betty", City.Kaohsiung, 33, Gender.FEMALE, "betty@gmail.com", "07-9876-8787"));
        people.add(new Person("Ivy", City.Taipei, 23, Gender.FEMALE, "ivy@gmail.com", "02-2777-1234"));
        people.add(new Person("Nicole", City.Tainan, 42, Gender.FEMALE, "nicole@gmail.com", "06-666-4545"));
        return people;
    }

}
