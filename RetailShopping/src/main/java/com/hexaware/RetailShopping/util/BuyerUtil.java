package com.hexaware.RetailShopping.util;

import com.hexaware.RetailShopping.factory.BuyerFactory;
//import com.hexaware.RetailShopping.factory.BuyerFactory;
import com.hexaware.RetailShopping.factory.ItemsFactory;
import com.hexaware.RetailShopping.factory.LoginFactory;
import com.hexaware.RetailShopping.factory.OrdersFactory;
import com.hexaware.RetailShopping.model.Buyer;
import com.hexaware.RetailShopping.model.Items;
import com.hexaware.RetailShopping.model.Orders;
import com.hexaware.RetailShopping.model.UserType;
import com.hexaware.RetailShopping.model.Login;
import com.hexaware.RetailShopping.model.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
      case 1:
        registerBuyer();
        break;
      case 2:
        buyerSignIn();
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

    System.out.print("Please enter First Name: ");
    String fName = opt.next();
    System.out.print("Please enter Last Name: ");
    String lName = opt.next();
    String buyerName = fName + " " + lName;

    System.out.print("City:");
    String city = opt.next();
    System.out.print("State: ");
    String state = opt.next();
    System.out.print("Country:");
    String country = opt.next();
    String address = city + ", " + state + ", " + country;

    System.out.print("Contact Number: ");
    String phone = opt.next();
    System.out.print("Email: ");
    String email = opt.next();

    System.out.print("Username: ");
    String user = opt.next();
    System.out.print("Password: ");
    String pass = opt.next();
    Login l = LoginFactory.getLoginDetails(user);

    if (l == null) {
      System.out.println("======================================================");
      System.out.println("Please Confirm: ");
      System.out.println("Name: " + buyerName);
      System.out.println("Address: " + address);
      System.out.println("Phone: " + phone);
      System.out.println("Email: " + email);

      System.out.println("Is the information correct? Y or N");
      char ch = opt.next().charAt(0);

      if (ch == 'Y' || ch == 'y') {
        Buyer b = new Buyer();
        String ut = UserType.BUYER.toString();
        String msg = b.registerNewBuyer(buyerName, address, phone, email, user, pass, ut);
        System.out.println(msg);
      } else {
        System.out.println("Unable to register. Please try again.");
      }
      buyerMenu();
    } else {
      System.out.println("Username already exists. Please Enter your details again.");
      registerBuyer();
    }
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

    Login login = LoginFactory.getLoginDetails(user);

    if (login != null) {
      int ch = 0;
      UserType ut = login.getUserType();
      if (ut.equals(UserType.BUYER)) {
        if (user.equals(login.getUserName()) && pass.equals(login.getPassword())) {
          do {
            System.out.println("=======WELCOME========");
            System.out.println("1. Personal Details");
            System.out.println("2. Items Menu");
            System.out.println("3. Order History");
            System.out.println("4. Wallet Details");
            System.out.println("5. Sign Out");
            ch = opt.nextInt();

            int currentBuyer = login.getUserId();
            switch (ch) {
              case 1:
                showBuyerDetails(currentBuyer);
                break;
              case 2:
                itemsMenu(currentBuyer);
                break;
              case 3:
                orderHistory(currentBuyer);
                break;
              case 4:
                checkBalance(currentBuyer);
                break;
              case 5:
                Runtime.getRuntime().halt(0);
              default:
                System.out.println("Choose from 1, 2 ,3 and 4 only");
                break;
            }
          } while (ch > 0 && ch < 5);
        } else {
          System.out.println("Wrong credentials");
        }
      } else {
        System.out.println("Please register as Buyer or Login as Supplier");
      }
    } else {
      System.out.println("Please Register or Login with Correct Credentials");
    }
  }

  private void itemsMenu(final int currentBuyer) {
    Items[] items = ItemsFactory.listAllItems();

    if (items.length > 0) {
      for (Items i : items) {
        System.out.println(i.toString());
      }
    }

    System.out.println("Would you like to place an order? Y or N");
    char ch = opt.next().charAt(0);

    if (ch == 'Y' || ch == 'y') {
      System.out.print("Enter the Item Id: ");
      int id = opt.nextInt();
      System.out.print("Enter Quantity (minimum 1): ");
      int qty = opt.nextInt();

      Items item = ItemsFactory.listItemDetails(id);

      if (item != null) {
        System.out.println("Item Details: ");
        System.out.println("--------------------");
        System.out.println(item.toString());
        System.out.println("==================================================================================");
        System.out.println();
        Orders o = OrdersFactory.findLastRow();
        int oId = 3001;
        if (o != null) {
          oId = o.getOrderId() + 1;
        }

        Date curDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String date = sdf.format(curDate);
        try {
          curDate = sdf.parse(date);
        } catch (ParseException e) {
          e.printStackTrace();
        }

        double ordAmt = item.getPrice() * qty;
        String status = OrderStatus.PENDING.toString();

        Buyer b = BuyerFactory.findBuyer(currentBuyer);
        double balance = b.getWalletBalance();
        if (balance > ordAmt) {
          String msg = OrdersFactory.uploadNewOrder(oId, curDate, currentBuyer, item.getSupplierId(),
              item.getItemId(), qty, status);
          OrdersFactory.updateOrderAmount(oId, ordAmt);
          System.out.println(msg);
          msg = BuyerFactory.updateWalletBalance(currentBuyer, balance, ordAmt);
          System.out.println(msg);
        } else {
          System.out.println("Insufficient Balance. Please Add Balance to Your Wallet.");
        }
      } else {
        System.out.println("This Item is unavailable. Please choose a different Item");
      }
    }
  }

  private void orderHistory(final int argBuyer) {
    Orders[] history = OrdersFactory.listAllBuyeOrders(argBuyer);

    if (history.length > 0) {
      for (Orders o: history) {
        double amt = OrdersFactory.retrieveOrderAmount(o.getOrderId());
        System.out.println("Order Id: " + o.getOrderId() + " | Order Date: "
            + o.getOrderDate() + " | Order Amount: " + amt + " | Status: "
            + o.getOrderStatus() + " | Supplier Id: " + o.getSupplierId()
            + " | Item Id: " + o.getItemId() + " | Quantity: " + o.getItemQuantity());
      }
    } else {
      System.out.println("Looks like you are new. Happy Shopping");
    }
  }

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

    if (b != null) {
      System.out.println("Current Balance: " + b.getWalletBalance());
    } else {
      System.out.println("Sorry! Unable to process your request");
    }
  }
}
