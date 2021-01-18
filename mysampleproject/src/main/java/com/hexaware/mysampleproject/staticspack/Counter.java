package com.hexaware.mysampleproject.staticspack;

/**
 * count the number of objects created using static variable
 */
public class Counter {
  static int count;

  public Counter() {
    count++;
    System.out.println("In constructor");
    System.out.println("No of Objects: " + count);
  }

  public static void display() {
    count++;
    System.out.println("In static method: " + count);
  }
}
