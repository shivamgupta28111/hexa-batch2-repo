// /**
//  * Object -> properties + actions
//  * 
//  * phone -> ram, rom, price, brand, color, screen-size, camera, OS, battery backup etc.
//  *      -> call, text, app installing, recording, playing music, etc.
//  * 
//  * class -> blueprint of an object. 
//  *      -> location where properties and related actions are stored.
//  * 
//  * Abstraction 
//  * Encapsulation 
//  * Inheritance
//  *  1. Single
//  *  2. multiple 
//  *  3. multilevel
//  *  4. hybrid
//  *  5. hierarchical
//  * Polymorphism
//  *  1. Overriding
//  *  2. Overloading
//  * 
//  * JAVA -> Language and a platform
//  * JDK -> Java development kit
//  * JRE -> Java Runtime Environment - JVM (Java Virtual Machine)
//  * 
//  * JVM 
//  * 1. Compile code -> Bytecode
//  * 2. Interprets Bytecode 
//  * 3. Garbage collectors
//  * 4. Memory manager
//  * 
//  * Variables -> named locations in memory
//  * Datatype
//  *  1. primitive datatypes: int, short, long, float, double, char, boolean, byte
//  *  2. non - primitive datatypes: class, interface, enum, arrays, String
//  * 
//  * Keywords:
//  *  class, interface, enum, int, float, short, long, double, char, boolean,
//  *  public, private, protected, void, abstract, break, continue, if, else,
//  *  switch, case, while, do, catch, try, final, implements, extends, finally,
//  *  static, new, byte, for, instanceOf, synchronized, package, return, this,
//  *  throw, throws, super, default
//  * 
//  * Access specifiers: public, private, protected and default
//  * 
//  * Operators:
//  * 1. Based on the number of operands
//  *    a. unary operators ->  ++  -- (Ex: a++ or ++a) 
//  *    b. binary operators -> +, -, *, /, %, >, <, ==, = etc.
//  *    c. ternary operators -> ?: [(condition)? true: false]
//  * 2. based on the operations
//  *    a. Arithmetic: + - * / % ++ --
//  *    b. relational: > < >= <= == != 
//  *    c. logical: && || !
//  *    d. bitwise: & | ^
//  *    e. assignment: =
//  * 
//  * Control Flow Statements
//  * 1. Conditional Statement - if else
//  * 2. Branching statement - switch case
//  * 3. Iterative statements - for, while, do while, extended for
//  * 
//  * 
//  * Constructors.
//  *  -> a special method to create objects
//  *  -> should be public
//  *  -> has no return type (not even void)
//  *  -> should have the name of the class
//  *  -> can be overloaded
//  *  -> is not inherited
//  * 1. default constructor
//  * 2. parameterized constructor
//  */

package com.hexaware.mysampleproject.util;

import com.hexaware.mysampleproject.collectionspack.CollectionsDemo;

//import java.util.InputMismatchException;
// import java.util.Scanner;

// import com.hexaware.mysampleproject.exceptionspack.ExceptionDemo;

public class CliMain {
  public static void main(String[] args) {
    CollectionsDemo cd = new CollectionsDemo();
    cd.listDemo();
    
    
    // char ch = 'a';

    // //autoboxing
    // Character charObj = ch;

    // //unboxing
    // System.out.println(charObj.charValue());

    // int i = 10;
    // Integer intObj = new Integer(i);
    // System.out.println(intObj);


    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter 2 numbers: ");
    // int num1 = sc.nextInt();
    // int num2 = sc.nextInt();
    // int res = 0;

    // //String s = null; 
    // try{
    //   res = ExceptionDemo.divide(num1, num2);
    //   //System.out.println("String length: " + s.length());
    // } catch (ArithmeticException e) {
    //   System.out.println(e.getMessage());
    // }

    // System.out.println(res);
    // try {
    //   int num1 = sc.nextInt();
    //   int num2 = sc.nextInt();
    //   res = ExceptionDemo.divide(num1, num2);
    // } catch (ArithmeticException e) {
    //   System.out.println("Division by Zero is not allowed");
    // } catch (InputMismatchException e) {
    //   // e.printStackTrace();
    //   System.out.println(e.getMessage());
    // } catch (Exception e) {
    //   System.out.println(e.getMessage());
    // } finally {
    //   System.out.println("In finally");
    //   //sc.close();
    // }
    
   // System.out.println(res);
  }
}



// import com.hexaware.mysampleproject.staticspack.Outer;
// import com.hexaware.mysampleproject.staticspack.StringTester;

// //import com.hexaware.mysampleproject.staticspack.Counter;

// //import com.hexaware.mysampleproject.demopack.Calculator;

// //import java.util.Scanner;

// //import com.hexaware.mysampleproject.demopack.Student;
// //import com.hexaware.mysampleproject.demopack.Animal;
// //import com.hexaware.mysampleproject.demopack.Dog;
// //import com.hexaware.mysampleproject.staticspack.Employee;

// public class CliMain {

//   private void statementsDemo(){
//     // String personName = "Mayank";
//     // char loc = 'c';
//     // int age = 25;

//     // if(loc == 'C' || loc == 'c') {
//     //   if (age > 20) {
//     //     System.out.println(personName + " is eligible for insurance");
//     //   } else {
//     //     System.out.println("Wromg age");
//     //   }
//     // } else {
//     //   System.out.println("Wrong location");
//     // }

//     // char grade = 'A';
//     // if( grade == 'A') {
//     //   System.out.println("Outstanding");
//     // } else if(grade == 'B') {
//     //   System.out.println("Excellent");
//     // } else if (grade == 'C') {
//     //   System.out.println("Good");
//     // } else if (grade == 'D') {
//     //   System.out.println("Bad");
//     // } else if(grade == 'E') {
//     //   System.out.println("Horrible");
//     // } else {
//     //   System.out.println("Invalid Grade");
//     // }
//   }

//   private void branchingDemo(){
//     // char grade = 'A';

//     // switch (grade) {
//     //   case 'A': System.out.println("Outstanding");
//     //     break;
//     //   case 'B': System.out.println("Excellent");
//     //     break;
//     //   case 'C': System.out.println("Good");
//     //     break;
//     //   case 'D': System.out.println("Bad");
//     //     break;
//     //   case 'E': System.out.println("Horrible");
//     //     break;
//     //   default: System.out.println("Invalid option");
//     //     break;
//     // }
//   }

//   private void iterativeDemo() {
//     // int[] arr = new int[5];

//     // //int[] arr1 = {23, 56, 11, 89, 90};

//     // //arr[0] = 10;

//     // for(int i = 0; i < 5; i++) {
//     //   arr[i] = i + 2;
//     // }

//     // //reading the array
//     // // for(int i = 0; i < 5; i++) {
//     // //   System.out.println(arr[i]);
//     // // }
//     // for(int ele: arr) {
//     //   System.out.println(ele);
//     // }

//     // Student[] studentList = new Student[3];
//     // Scanner sc = new Scanner(System.in);
    
//     // for(int i = 0; i < 3; i++) {
//     //   System.out.println("Id: ");
//     //   int id = sc.nextInt();
//     //   System.out.println("Name: ");
//     //   String name = sc.next();
//     //   System.out.println("Age: ");
//     //   int age = sc.nextInt();
//     //   System.out.println("Course Id: ");
//     //   int cId = sc.nextInt();

//     //   System.out.println("=====================");
//     //   Student s =new Student();
//     //   s.setStudentId(id);
//     //   s.setStudentName(name);
//     //   s.setStudentAge(age);
//     //   s.setCourseId(cId);

//     //   studentList[i] = s;
//     // }

//     // System.out.println();

//     // for(Student s: studentList) {
//     //   System.out.println("Id: " + s.getStudentId());
//     //   System.out.println("Name: " + s.getStudentName());
//     //   System.out.println("Age: " + s.getStudentAge());
//     //   System.out.println("Course Id: " + s.getCourseId());
//     // }

//     // sc.close();
//   }

//   // final int finalVar;

//   // {
//   //   System.out.println("In initialization block");
//   //   finalVar = 10;
//   // }

//   // static{
//   //   System.out.println("In static block");
//   //  // Employee.organization = "Hexaware";
//   // }

//   public static void main(String[] args) {

//   StringTester st = new StringTester();

//   st.testMethod();
//     Outer outer = new Outer();
//     outer.showData();
    
//     // Outer.Inner inner = outer.new Inner();
//     // inner.display();

//     Outer.Inner inner = new Outer.Inner();
//     inner.display();

//     //System.out.println("In main method");

//     // Counter c1 = new Counter();
//     // Counter c2 = new Counter();
//     // Counter.display();


//     // Employee emp = new Employee(101, "John");
//     // Employee emp1 = new Employee(102, "Alex");

//     //Employee.changeOrg("Infosys");
//     // emp.organization = "Hexaware";
//     // emp1.organization = " SprinPeople";

//     // emp.setEmpId(1);
//     // emp.setEmpName("John");

//     // emp1.setEmpId(2);
//     // emp1.setEmpName("Alex");

//     //Employee.setOrganization("Hexaware");

//     // System.out.println("Employee1: ");
//     // //System.out.println();
//     // //emp.show();

//     // System.out.println("Employee 2: ");
//     //emp1.show();

//     //===========================================
//     CliMain obj = new CliMain();
//     obj.statementsDemo();
//     obj.branchingDemo();
//     obj.iterativeDemo();

//     // Animal animal = new Animal();
//     // animal.speak();

//     // Dog dog = new Dog();
//     // dog.setDogName("Bruno");
//     //dog.speak();

//     //Calculator calc = new Calculator();
//     // int res = calc.add(2,4,8);

//     // System.out.println(res);

//     // Student student1 = new Student();
//     // student1.setStudentId(1);
//     // student1.setStudentName("ABC");
//     // student1.setStudentAge(16);
//     // student1.setCourseId(100);

//     // Student student2 = new Student();
//     // student2.setStudentId(2);
//     // student2.setStudentName("XYZ");
//     // student2.setStudentAge(18);
//     // student2.setCourseId(102);

//     // System.out.println("Student 1: ");
//     // System.out.println("ID: " + student1.getStudentId());
//     // System.out.println("Name: " + student1.getStudentName());
//     // System.out.println("Age: " + student1.getStudentAge());

//     // System.out.println();
//     // System.out.println("Student 2: ");
//     // System.out.println("ID: " + student2.getStudentId());
//     // System.out.println("Name: " + student2.getStudentName());
//     // System.out.println("Age: " + student2.getStudentAge());


//   }
// }

