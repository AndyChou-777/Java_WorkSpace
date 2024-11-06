package com.example;

public enum Gender { 
    MALE("先生"), FEMALE("女士");
    
    String prefix;

    private Gender(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }   
    
}
