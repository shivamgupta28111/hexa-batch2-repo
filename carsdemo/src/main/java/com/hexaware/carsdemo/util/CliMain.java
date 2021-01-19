package com.hexaware.carsdemo.util;

import java.util.Scanner;

import com.hexaware.carsdemo.factory.CarsFactory;
import com.hexaware.carsdemo.model.Cars;

public class CliMain {
    Scanner sc = new Scanner(System.in);
    private void mainMenu() {
        System.out.println("1. Show All Cars");
        System.out.println("2. Display Car Details");
        System.out.println("3. Add a new Car");
        System.out.println("4. Exit");

        System.out.println("Choose your option:");
        int ch = sc.nextInt();

        switch(ch) {
            case 1: Cars[] cars = CarsFactory.showCars();
                if (cars.length > 0){
                    for(Cars c: cars){
                        System.out.println(c.getCarId() + " " + c.getCarName() + " " + c.getPrice());
                    }
                } else {
                    System.out.println("Sorry! No cars available");
                }
                break;
            case 2: displayDetails();
                break;
            case 3: addACar();
                break;
            case 4: Runtime.getRuntime().halt(0);
            default: System.out.println("Wrong choice");
                break;
        }
    }

    private void displayDetails() {
        System.out.println("Enter car Id: ");
        int id = sc.nextInt();

        Cars car = CarsFactory.retrieveCarDetails(id);
        if(car != null) {
            System.out.println(car.getCarId() + " " + car.getCarName() + " " + car.getPrice());
        } else {
            System.out.println("Car does not exist");
        }
    }
    private void addACar() {
        System.out.println("Car Id:");
        int id = sc.nextInt();

        System.out.println("Car Name:");
        String name = sc.next();

        System.out.println("Price: ");
        double price = sc.nextDouble();

        Cars car = new Cars();
        String res = car.addCar(id, name, price);
        System.out.println(res);
    }

    public static void main(String[] args) {
        CliMain obj = new CliMain();
        obj.mainMenu();
    }
}
