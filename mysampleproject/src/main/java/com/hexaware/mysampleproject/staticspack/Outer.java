/**
 * a class inside another class -> nested class
 * the inner class can access all the data of the outer class
 * makes code more readable
 * code optimization -> lesser code
 * 
 * 1. Member Inner Class
 * 2. Anonymous inner class
 * 3. static nested classes -> it cannot access non - static data
 * 4. nested interface
 */

package com.hexaware.mysampleproject.staticspack;

public class Outer {
  private static int data = 20;

  public void showData() {
    System.out.println("In Outer: data: " + data);
  }

  public static class Inner {
    private int data1 = 10;
    public void display() {
      System.out.println("In Inner: data: " + (data * data1));
    }
  }
}
