/**
 * Rules of overriding
 * 1. both the superclass and the subclass should have the same method name, the same return type
 *    and the same parameter list
 * 2. methods which are marked final and/or static cannot be overridden
 * 3. abstract methods should mandatorily be overridden
 */
package com.hexaware.mysampleproject.demopack;

public class Dog extends Animal{
    private String dogName;
    final int testVar;// = 0;
    // {
    //     testVar = 10;
    // }

    public Dog() {
        testVar = 10;
    }

    public String getDogName() {
        return this.dogName;
    }

    public void setDogName(String argName) {
        this.dogName = argName;
    }

    @Override
    public void speak() {
        System.out.println(dogName + " barks");
    }

    @Override
    public void eat() {
        System.out.println(dogName + " eats biscuits");
    }
}
