package com.example;

public class ContactService {
    public void sendEmail(Person p) {
        System.out.printf("Emailing: %s(%d) at %s%n", p.getName(), p.getAge(), p.getEmail());
    }

    public void sendMessage(Person p) {
        System.out.printf("Texting: %s(%d) at %s%n", p.getName(), p.getAge(), p.getPhone());
    }
}
