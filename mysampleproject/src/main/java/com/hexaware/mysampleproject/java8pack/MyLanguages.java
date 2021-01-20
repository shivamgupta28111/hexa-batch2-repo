/**
 * anonymous inner class -> an inner class without a name
 * 2 ways to create an anonymous inner class:
 * 1. abstract or a concrete class
 * 2. interface
 */

package com.hexaware.mysampleproject.java8pack;


public class MyLanguages {
  public void myMethod() {
    Language lan = new Language(){
      void speak() {
        System.out.println("Speaking my Language");
      }

      void learn() {
        System.out.println("learning");
      }
    };
    lan.speak();
    lan.learn();
  }

  public void myInterfaceMethod() {
    SecondInterface s = new SecondInterface(){
      public void first() {
        System.out.println("First Method");
      }
      public void second() {
        System.out.println("Second Method");
      }
    };
    s.first();
  }
  
}
