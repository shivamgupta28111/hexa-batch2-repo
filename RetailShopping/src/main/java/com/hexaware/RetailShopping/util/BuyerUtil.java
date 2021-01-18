package com.hexaware.RetailShopping.util;

import com.hexaware.RetailShopping.model.Buyer;
import com.hexaware.RetailShopping.model.Items;

import java.util.Scanner;

/**
 * Buyer Utility class.
 */
public class BuyerUtil {

  private static Scanner opt = new Scanner(System.in, "UTF-8");

  /**
   * buyer menu method.
   */
  final void buyerMenu() {
    System.out.println("=================Welcome===============");
    System.out.println("----------------Buyer Menu----------");
    System.out.println("1. Register");
    System.out.println("2. SignIn");
    System.out.println("3. Exit");
    int ch = opt.nextInt();

    switch (ch) {
      case 1: registerBuyer();
        break;
      case 2: buyerSignIn();
        break;
      case 3:
        System.out.println("Thank You For Shopping With Us. See You Again Soon!");
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Please choose either 1, 2 or 3");
        buyerMenu();
    }
  }

  /**
   * method to register a buyer.
   */
  private void registerBuyer() {
    System.out.println("Please Enter Your Details");
    System.out.println("==========================");
    System.out.println();

    System.out.println("Please enter First Name: ");
    String fName = opt.next();
    System.out.println("Please enter Last Name: ");
    String lName = opt.next();
    String buyerName = fName + " " + lName;

    System.out.println("City:");
    String city = opt.next();
    System.out.println("State: ");
    String state = opt.next();
    System.out.println("Country:");
    String country = opt.next();
    String address =  city + ", " + state + ", " + country;

    System.out.println("Contact Number: ");
    String phone = opt.next();
    System.out.println("Email: ");
    String email = opt.next();

    System.out.println("======================================================");
    System.out.println("Please Confirm: ");
    System.out.println("Name: " + buyerName);
    System.out.println("Address: " + address);
    System.out.println("Phone: " + phone);
    System.out.println("Email " + email);

    System.out.println("Is the information correct? Y or N");
    char ch = opt.next().charAt(0);

    if (ch == 'Y' || ch == 'y') {
      Buyer b = new Buyer();
      String msg = b.registerNewBuyer(buyerName, address, phone, email);
      System.out.println(msg);
    } else {
      System.out.println("Unable to register. Please try again.");
    }
    buyerMenu();
  }

  /**
   * method for buyer login.
   */
  private void buyerSignIn() {
    System.out.println("==========SignIn=========");
    System.out.println("Username: ");
    String user = opt.next();
    System.out.println("Password: ");
    String pass = opt.next();

    //store the buyerId here and pass it on to the next method calls
    int currentBuyer = 102;

    int ch = 0;
    if (user.equals("test") && pass.equals("test123")) {
      do {
        System.out.println("1. Personal Details");
        System.out.println("2. Items Menu");
        System.out.println("3. Order History");
        System.out.println("4. Wallet Details");
        System.out.println("5. Sign Out");
        ch =  opt.nextInt();

        switch (ch) {
          case 1: showBuyerDetails(currentBuyer);
            break;
          case 2: itemsMenu();
            break;
          case 3: //orderHistory(currentBuyer);
            break;
          case 4: checkBalance(currentBuyer);
            break;
          case 5: Runtime.getRuntime().halt(0);
          default: System.out.println("Choose from 1, 2 ,3 and 4 only");
            break;
        }
      } while (ch > 0 && ch < 5);
    }
  }

  private void itemsMenu() {
    Items item = new Items();
    Items[] items = item.listAllItems();

    for (Items i : items) {
      //if (i != null) {
      try {
        System.out.println(i.toString());
      } catch (NullPointerException e) {
        System.out.println("Empty Object");
      }

    //  }
    }

    System.out.println("Select item you want to purchase: ITEM ID Please:");
    int id = opt.nextInt();

    item = item.listItemDetails(id);
    if (item == null) {
      System.out.println("Wrong id. Please try again!");
    } else {
      System.out.println(item.toString());
    }
  }

  // private void orderHistory(final int argBuyer) {

  // }

  private void showBuyerDetails(final int argBuyer) {
    System.out.println("1. Display Details");
    System.out.println("2. Update Details");
    System.out.println("Your option?");
    int ch = opt.nextInt();

    switch (ch) {
      case 1: //System.out.println("Fetching details soon");
        Buyer b = new Buyer();
        b = b.listBuyerDetails(argBuyer);
        System.out.println(b.toString());
        break;
      case 2:
        System.out.println("Would you like to update your password?");
        System.out.println("Select Y or N");
        char op = opt.next().charAt(0);
        switch (op) {
          case 'Y':
          case 'y':
            System.out.println("Enter New Password: ");
            String newPass = opt.next();
            System.out.println("Confirm New Password: ");
            String confirmPass = opt.next();

            if (newPass.equals(confirmPass)) {
              //call the method to update password
              Buyer buyer = new Buyer();
              buyer.updatePassword(argBuyer, newPass);
            } else {
              System.out.println("Passwords don't match. Please try again!");
              showBuyerDetails(argBuyer);
            }
            break;
          case 'N':
          case 'n':
            System.out.println("Thank you! Taking you back to the menu now!");
            break;
          default:
            System.out.println("Sorry! Wrong choice!");
            break;
        }
        break;
      default:
        System.out.println("Please choose again");
        showBuyerDetails(argBuyer);
        break;
    }
  }

  private void checkBalance(final int argBuyer) {
    Buyer b = new Buyer();
    b = b.listBuyerDetails(argBuyer);
    System.out.println("Current Balance: " + b.getWalletBalance());
  }
}
