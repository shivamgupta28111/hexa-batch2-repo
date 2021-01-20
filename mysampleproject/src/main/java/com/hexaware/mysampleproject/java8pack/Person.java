package com.hexaware.mysampleproject.java8pack;

public class Person {
    private String personName;
    private Integer personAge;

    public String getPersonName() {
        return personName;
    }

    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Person() {

    }

    public Person(String name, int age) {
        this.personName = name;
        this.personAge = age;
    }
}