/**
 * primitive datatype: int, byte, char, short, double, float, boolean, long
 * 
 * Wrapper class -> a class wrapped around a primitive datatype
 * int -> Integer
 * double -> Double
 * char -> Character
 * float -> Float
 * byte -> Byte
 * boolean -> Boolean
 * short -> Short
 * long -> Long
 * 
 * Integer in = new Integer();
 * 
 * Autoboxing -> wrapping a primitive datatype inside a object
 * Unboxing -> process of converting wrapper class object into primitive datatype 
 * 
 * Collections -> a framework used to work with objects i.e. to store and manipulate objects
 *      -> are dynamic in nature.
 *      -> size can expand or contract based on the number of items
 * 2 parts:
 * 1. Interfaces and the classes that implement them
 * 2. Algorithms
 * 
 * Collections belong to java.util;
 * 
 * Base Interface -> Iterable <- Collections <- List, Set, Map, Queue
 * Classes that implement:
 * 1. List -> ArrayList, Vector, LinkedList, Stack
 * 2. Queue -> Queue, PriorityQ
 * 3. Set -> HashSet, TreeSet
 * 4. Map -> HashMap, TreeMap
 * 
 * Iterator -> collections traversal
 * 
 * All collections start with index zero
 * 
 * LIST:
 *  -> is an interface.
 *  -> use the classes that implement it (CollectionClass)
 * List<String> listname = new CollectionClass<String>();
 * 
 * Methods:
 * 1. add()
 * 2. addAll()
 * 3. remove()
 * 4. removeAll()
 * 5. get()
 * 6. iterator()
 * 7. clear()
 * 8. size()
 * 9. toArray()
 * 10. contains()
 *
 * 1. ArrayList
 */



package com.hexaware.mysampleproject.collectionspack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionsDemo {
  public void listDemo() {

    List<Employee> employees = new ArrayList<Employee>();

    employees.add(new Employee(1, "Komal"));
    employees.add(new Employee(2, "Anuj"));
    employees.add(new Employee(3, "Bhavani"));

    System.out.println("List Size: " + employees.size());

    // Employee e = employees.get(1);
    // System.out.println(e.getEmpId() + " " + e.getEmpName());

    System.out.println("Original List");
    System.out.println("-------------------");
    for(Employee e: employees) {
      System.out.println(e.getEmpId() + " " + e.getEmpName());
    }

    employees.set(0, new Employee(4, "Kate"));

    employees.add(2, new Employee(5, "David"));

    System.out.println("-------------------");
    System.out.println("After Change");
    System.out.println("-------------------");
    // for(Employee e: employees) {
    //   System.out.println(e.getEmpId() + " " + e.getEmpName());
    // }

    Iterator itr = employees.iterator();

    while (itr.hasNext()){
      Employee e = (Employee) itr.next();
      System.out.println(e.getEmpId() + " " + e.getEmpName());
    }
    
    // List<Integer> numberList = new ArrayList<Integer>();

    // //adding elements to the list
    // numberList.add(12);
    // numberList.add(23);
    // numberList.add(34);
    // numberList.add(45);
    // numberList.add(56);

    // //to print the list
    // System.out.println("List: " + numberList);
  }
}
