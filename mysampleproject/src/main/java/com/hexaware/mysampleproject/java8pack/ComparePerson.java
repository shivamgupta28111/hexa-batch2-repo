package com.hexaware.mysampleproject.java8pack;

public class ComparePerson {
    public static int compareByName(Person p1, Person p2) {
        return p1.getPersonName().compareTo(p2.getPersonName());
    }

    public int compareByAge(Person p1, Person p2) {
        return p1.getPersonAge().compareTo(p2.getPersonAge());
    }
}
