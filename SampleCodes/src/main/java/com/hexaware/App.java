/**
 * Java is a programming language and a platform.
 * James Gosling -> father of Java
 * 
 * Features of Java
 * 1. simple
 * 2. portable
 * 3. platform - independent
 * 4. object oriented
 * 5. robust
 * 6. multithreaded
 * 7. secure
 * 
 * JVM -> Java Virtual Machine
 * 
 * Java is both compiled and interpreted
 * 
 * Realtime entities are objects
 * 
 * Objects -> properties/ attributes
 *         -> actions/ functionality
 * Class -> blueprint/template of an object
 * 
 * Instantiation -> process of creating an object from a class
 * 
 * 4 pillars of OOP
 * 1. Encapsulation -> attributes + related actions in a single location Ex: Class
 * 2. Abstraction -> hiding irrelevant data
 *      private
 *      protected
 *      public
 *      default
 * 3. Inheritance -> sharing of info between classes
 *     single -> 1 parent/base/super < 1 Child/derived/sub  
 *     multilevel -> 1 parent < 1 child < 1 grandchild
 *     hierarchical -> family tree
 * 4. polymorphism -> many forms
 *      compile - time / static
 *      run - time / dynamic
 * 
 * JDK -> Java Development Kit 
 * JRE -> Java Runtime Environment -> Spin up the JVM for java program execution
 * 
 * Jobs of JVM
 * 1. Manage memory
 * 2. garbage collection
 * 3. compiles source code -> bytecode (intermediate language)
 * 4. Interpretes the bytecode into binary
 * 
 * Keywords:
 * abstract, class, interface, enum, public, private, protected, static, new, void, int, char, 
 * case, switch, for, while, do, float, double, default, continue, final, extends, implements,
 * break, try, catch, goto, finally, if, else, long, short, synchronized, return, super, this,
 * throw, throws, import, package, null
 */

package com.hexaware;

import com.hexaware.samplecodes.inheritancepack.Man;
import com.hexaware.samplecodes.inheritancepack.Person;

//import java.util.Scanner;

// import com.hexaware.samplecodes.demopack.Manager;
// import com.hexaware.samplecodes.demopack.Employee;
//import com.hexaware.samplecodes.demopack.JobTitles;

//import com.hexaware.samplecodes.demopack.StringsDemo;

//import com.hexaware.samplecodes.demopack.Tutorial080121;
//import com.hexaware.samplecodes.demopack.Tutorial110121;

//import com.hexaware.samplecodes.demopack.DemoClass;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) //main method
    {

        Person person = new Person();
        person.sleep();
        person.eat();

        Man man = new Man();
        man.eat();
        int res = man.add(12, 24);
        System.out.println(res);

        int res1 = man.add(1, 2, 3);
        System.out.println(res1);


        //==================================================================
        // Scanner sc = new Scanner(System.in);

        // int id;
        // String name;
        // double salary;

        // Employee emp = new Employee(); //using default constructor

        // emp.setEmpId(102);
        
        // System.out.println("Enter Id: ");
        // id = sc.nextInt();

        // System.out.println("Name please: ");
        // name = sc.next();

        // System.out.println("Enter Salary: ");
        // salary = sc.nextDouble();

        // Manager manager = new Manager();
        // manager.setEmpId(1001);
        // manager.setEmpName("empName");
        // manager.setSal(45677);

        

        // emp.setEmpId(id);
        // emp.setEmpName(name);
        // emp.setSal(salary);
        // System.out.println("Id: " + manager.getEmpId());
        // System.out.println("Name: " + manager.getEmpName());
        // System.out.println("Salary: " + manager.getSal());



        // emp.setEmpId(1001);
        // System.out.println("Employee 1: " + emp.getEmpId());
        // emp.setEmpName("Alex");
        // System.out.println("Name: " + emp.getEmpName());
        // emp.setSal(23450.00);
        // System.out.println("Salary: " + emp.getSal());

        // Employee emp2 = new Employee(id, name, salary);//, JobTitles.MANAGER);
        // System.out.println("Employee 2: " + emp2.getEmpId());
        // System.out.println("Emp Name: " + emp2.getEmpName());
        // System.out.println("Salary: " + emp2.getSal());



        //======================================================================


        // StringsDemo sd = new StringsDemo();
        // sd.forStrings();
        // Tutorial110121 tt = new Tutorial110121();
        // tt.array2D();

        // Tutorial080121 tt = new Tutorial080121();

        // int result = tt.addNumbers(12, 23);
        // System.out.println(result);
        //tt.arrayDemo();
        //tt.controlStatementsDemo();
        //tt.fibonacciExample();

        // DemoClass dc = new DemoClass();
        // dc.demoId = 1;
        // dc.setDemoName("Java Training");

        // System.out.println(dc.demoId + " " + dc.getDemoName());

        // System.out.println( "Hello World!" );
    }
}
