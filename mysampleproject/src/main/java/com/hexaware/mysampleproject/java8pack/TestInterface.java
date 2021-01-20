package com.hexaware.mysampleproject.java8pack;

@FunctionalInterface
public interface TestInterface {
    //String greet(String msg); //abstract method

    Person addPerson(String name, int age);
    
    // default void myMethod() {
    //     System.out.println("Inside the interface");
    // }

    // static void staticMethod() {
    //     System.out.println("static methods");
    // }
}