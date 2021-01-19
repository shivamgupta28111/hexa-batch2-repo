package com.hexaware.RetailShopping.util;

import java.util.Scanner;

import com.hexaware.RetailShopping.model.Supplier;
import com.hexaware.RetailShopping.model.UserType;
import com.hexaware.RetailShopping.factory.LoginFactory;
import com.hexaware.RetailShopping.factory.SupplierFactory;
import com.hexaware.RetailShopping.model.Items;
import com.hexaware.RetailShopping.model.Login;
import com.hexaware.RetailShopping.model.Orders;


/**
 * Supplier Utility class.
 */
public class SupplierUtil {

  private static Scanner option = new Scanner(System.in, "UTF-8");

  /**
   * supplierMenu method.
   */
  public final void supplierMenu() {
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

    System.out.println("Username: ");
    String username = option.next();

    System.out.println("Password: ");
    String pass = option.next();

    String ut = UserType.BUYER.toString();

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
      String msg = s.registerSupplier(supName, supAddress, phone, emailAdd, username, pass, ut);
      System.out.println(msg);
    } else {
      System.out.println("Please re - enter your information.");
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

    Login login = LoginFactory.getLoginDetails(username);

    if (login != null) {
      UserType user = login.getUserType();
      if (user.equals(UserType.SUPPLIER)) {
        if (username.equals(login.getUserName()) && password.equals(login.getPassword())) {
          int supId = login.getUserId();
          int ch = 0;

          //Supplier s = new Supplier();

          do {
            System.out.println("====Welcome====");
            System.out.println("1. Personal Details");
            System.out.println("2. Add a new Item");
            System.out.println("3. Update an Item");
            System.out.println("4. Check Orders");
            System.out.println("5. List All My Orders");
            System.out.println("6. Sign Out");
            System.out.println("What would you like to do?");
            ch = option.nextInt();

            switch (ch) {
              case 1: //System.out.println("Under construction");
                listSupplierDetails(supId);
                break;
              case 2: addItem(supId);
                break;
              case 3: System.out.println("Coming soon");
                break;
              case 4: checkOrders(supId);
                break;
              case 5: listMyOrders(supId);
                break;
              case 6: Runtime.getRuntime().halt(0);
              default: System.out.println("Please choose from 1, 2 , 3 or 4");
                break;
            }
          } while (ch > 0 && ch < 6);
        }
      } else {
        System.out.println("You are in the Wrong Location. Please Login As a Buyer.");
      }
    } else {
      System.out.println("Wrong Credentials. Please try again");
    }
  }

  private void listSupplierDetails(final int supId) {
    Supplier s = SupplierFactory.findDetails(supId);

    if (s != null) {
      System.out.println(s.toString());
    } else {
      System.out.println("Unable to retrieve details. Please check Id and try again");
    }
  }

  private void addItem(final int supId) {
    System.out.println("Please enter the item details: ");
    System.out.println("Item Id");
    int id = option.nextInt();
    String name = option.next();
    double price = option.nextDouble();
    String cat = option.next();

    Items item = new Items();

    String msg = item.addNewItem(supId, id, price, name, cat);
    System.out.println(msg);

  }

  private void checkOrders(final int supId) {
    Supplier s = new Supplier();

    Orders[] pending = s.pendingOrders(supId);

    for (Orders o: pending) {
      System.out.println(o.toString());
      System.out.println("Press 1 to Accept Order. Press 2 to Deny Order:");
      int ch = option.nextInt();

      String stat = null;

      switch (ch) {
        case 1:
          stat = "ACCEPTED";
          break;
        case 2:
          stat = "DENIED";
          break;
        default:
          stat = "PENDING";
          break;
      }
      String msg = s.acceptDenyOrder(o.getOrderId(), stat);
      System.out.println(msg);
    }
  }

  /**
   * method to list all the orders for a particular supplier.
   * @param argSupplier for supplier id
   */
  private void listMyOrders(final int argSupplier) {
    Supplier s = new Supplier();

    Orders[] myOrders = s.supplierOrderHistory(argSupplier);

    if (myOrders.length > 0) {
      for (Orders o: myOrders) {
        System.out.println(o.toString());
      }
    } else {
      System.out.println("Sorry! We are unable to complete your request. Please try later");
    }
  }
}
