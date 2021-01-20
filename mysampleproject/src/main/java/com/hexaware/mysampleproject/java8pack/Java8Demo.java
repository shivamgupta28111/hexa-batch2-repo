/**
 * Java 8 Features
 * 1. Lambda Expressions
 *  (arg_body) -> {body}
 * 2. functional interfaces -> interface with exactly 1 abstract method.
 *      -> can have any number default and static method
 *      -> @FunctionalInterface annotation
 * 3. forEach() -> iterable interface
 *      -> used to iterate through a collection
 * 4. Method Referencing -> used to refer a method in a functional interface.
 *      -> more compact than Lambda expressions
 *   a. Static method referencing
 *   b. Instance method referencing
 *   c. Constructor referencing
 * 5. Date & Time API -> java.time package
 *      LocalDate
 *      LocalTime
 *      LocalDateTime
 *      ZoneId
 *      Clock
 *      Period
 *      Instant
 *      Year
 *      YearMonth
 *      ZoneDateTime
 *      DayOfWeek
 * 
 * Classic Date and Time API classes
 *  java.util.Date
 *  java.sql.Date
 *  java.util.Calendar
 *  java.util.Timezone
 *  java.sql.Time
 * 
 *  java.text.SimpleDateFormat -> format dates and return a string
 *          -> take a string and return 
 */

package com.hexaware.mysampleproject.java8pack;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// public class Java8Demo implements TestInterface {
//     public void greet() {
//         System.out.println("Hello");
//     }
// }

public class Java8Demo {
    // public void myMethod1() {
    //     TestInterface t = (msg) -> { 
    //         return "Hello " + msg; 
    //     };
    //     System.out.println(t.greet(" and Welcome"));
    // }

    // public static int multiply(int a, int b) {
    //     return a * b;
    // }

    public void forEachExample() {
        List<String> games = new ArrayList<String>();
        games.add("Chess");
        games.add("Ludo");
        games.add("Carrom");
        games.add("Snakes and Ladders");
        games.add("Monopoly");
        games.add("Zenga");
        games.add("Cards");
        games.add("Othello");
        games.add("Scrabble");
        games.add("Tambola");

        //method1
        for(String g: games) {
            System.out.println(g);
        }

        //method2
        for(int i = 0; i < games.size(); i++) {
            System.out.println(games.get(i));
        }

        //method3
        Iterator itr = games.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        //method4
        games.forEach((game) -> { System.out.println(game);});
    }
    
    public void dateApiExample() {
        LocalDate local = LocalDate.now();
        System.out.println(local);
        LocalDate yesterday = local.minusDays(1);
        System.out.println("Yesterday: " + yesterday);
        int year = local.getYear();
        System.out.println("Year: " + year);
        System.out.println("Leap Year? (" + local + ")? " + local.isLeapYear());
    }

    public void timeApiExample() {
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalTime myTime = LocalTime.of(11, 15, 12);
        System.out.println(myTime);
    }
}
