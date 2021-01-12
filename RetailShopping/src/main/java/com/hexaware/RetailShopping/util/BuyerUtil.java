package com.hexaware.RetailShopping.util;

import com.hexaware.RetailShopping.model.Buyer;

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
    System.out.println("3. Back to Main Menu");
    int ch = opt.nextInt();

    switch (ch) {
      case 1: registerBuyer();
        break;
      case 2: buyerSignIn();
        break;
      case 3: CliMain cm = new CliMain();
        cm.mainMenu();
        break;
      default:
        System.out.println("Please choose either 1, 2 or 3");
        buyerMenu();
    }
  }

  /**
   * method to register a buyer.
   */
  private void registerBuyer() {
    System.out.println("To be completed");
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
    int thisBuyer = 0;

    int ch = 0;
    if (user.equals("2001") && pass.equals("2001")) {
      do {
        System.out.println("1. Personal Details");
        System.out.println("2. Items Menu");
        System.out.println("3. Order History");
        System.out.println("4. Wallet Details");
        System.out.println("5. Sign Out");
        ch =  opt.nextInt();

        switch (ch) {
          case 1: showBuyerDetails(thisBuyer);
            break;
          case 2: itemsMenu();
            break;
          case 3: orderHistory(thisBuyer);
            break;
          case 4: checkBalance(thisBuyer);
            break;
          case 5: Runtime.getRuntime().halt(0);
          default: System.out.println("Choose from 1, 2 ,3 and 4 only");
            break;
        }
      } while (ch < 4);
    }
  }

  private void itemsMenu() {

  }

  private void orderHistory(final int argBuyer) {

  }

  private void showBuyerDetails(final int argBuyer) {
    System.out.println("1. Display Details");
    System.out.println("2. Update Details");
    System.out.println("Your option?");
    int ch = opt.nextInt();

    switch (ch) {
      case 1: System.out.println("Fetching details soon");
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
          case 'n': System.out.println("Thank you! Taking you back to the menu now!");
            break;
          default: System.out.println("Sorry! Wrong choice!");
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

  }
}
