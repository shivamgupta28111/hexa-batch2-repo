package com.hexaware.RetailShopping.util;

import java.util.Scanner;

import com.hexaware.RetailShopping.model.Supplier;

/**
 * Supplier Utility class.
 */
public class SupplierUtil {

  private static Scanner option = new Scanner(System.in, "UTF-8");

  /**
   * supplierMenu method.
   */
  final void supplierMenu() {
    System.out.println("=================Welcome===============");
    System.out.println("-------------Supplier Menu-------------");
    System.out.println("1. Register");
    System.out.println("2. Login");
    System.out.println("3. Exit");
    int ch = option.nextInt();

    switch (ch) {
      case 1: registerSupplier();
        break;
      case 2: supplierLogin();
        break;
      case 3: Runtime.getRuntime().halt(0);
      default:
        System.out.println("Please choose 1, 2 or 3");
        supplierMenu();
    }
  }

  /**
   * method to register the Supplier.
   */
  private void registerSupplier() {
    System.out.println("==============Please fill all the Fields==============");
    System.out.print("Enter Last Name: ");
    String lName = option.next();
    System.out.print("Enter First Name: ");
    String fName = option.next();
    String supName = fName + " " + lName;

    System.out.print("City: ");
    String city = option.next();
    System.out.print("State: ");
    String state = option.next();
    System.out.print("Country: ");
    String country = option.next();
    String supAddress = city + ", " + state + ", " + country;

    System.out.print("Phone Number: ");
    String phone = option.next();

    System.out.print("Email: ");
    String emailAdd = option.next();

    System.out.println("======================================================");
    System.out.println("Please Confirm: ");
    System.out.println("Name: " + supName);
    System.out.println("Address: " + supAddress);
    System.out.println("Phone: " + phone);
    System.out.println("Email " + emailAdd);

    System.out.println("Is the information correct? Y or N");
    char ch = option.next().charAt(0);
    if (ch == 'Y' || ch == 'y') {
      Supplier s = new Supplier();
      String msg = s.registerSupplier(supName, supAddress, phone, emailAdd);
      System.out.println(msg); 
    } else {
      System.out.println("Sorry! Registration Failed. Please try again");
    }
    supplierMenu();
  }

  /**
   * login method for supplier.
   */
  private void supplierLogin() {
    System.out.println("==============Sign In Please==============");
    System.out.print("Username: ");
    String username = option.next();
    System.out.print("Password: ");
    String password = option.next();

    if (username.equals("test") && password.equals("test123")) {
      int supId = 0;
      int ch = 0;

      Supplier s = new Supplier();

      do {
        System.out.println("====Welcome====");
        System.out.println("1. Personal Details");
        System.out.println("2. Add a new Item");
        System.out.println("3. Update an Item");
        System.out.println("4. Check Orders");
        System.out.println("5. Sign Out");
        System.out.println("What would you like to do?");
        ch = option.nextInt();

        switch (ch) {
          case 1: //System.out.println("Under construction");
            s.listSupplierDetails(supId);
            break;
          case 2: System.out.println("available soon");
            break;
          case 3: System.out.println("Coming soon");
            break;
          case 4: checkOrders();
            break;
          case 5: Runtime.getRuntime().halt(0);
          default: System.out.println("Please choose from 1, 2 , 3 or 4");
            break;
        }
      } while (ch > 0 && ch < 6);
    }
  }

  private void checkOrders() {
    //get the supplier's id.
    //call the method to retrieve the pending orders for
    //this supplier
    //menu to list pending orders, get orderdetails of particular
    //and accept or deny orders
  }
}
