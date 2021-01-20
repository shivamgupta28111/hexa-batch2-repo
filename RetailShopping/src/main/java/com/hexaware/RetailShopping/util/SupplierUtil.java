package com.hexaware.RetailShopping.util;

import java.util.Scanner;

import com.hexaware.RetailShopping.model.Supplier;
import com.hexaware.RetailShopping.model.UserType;
import com.hexaware.RetailShopping.factory.ItemsFactory;
import com.hexaware.RetailShopping.factory.LoginFactory;
import com.hexaware.RetailShopping.factory.OrdersFactory;
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

    System.out.print("Username: ");
    String username = option.next();

    System.out.print("Password: ");
    String pass = option.next();

    Login l = LoginFactory.getLoginDetails(username);
    if (l == null) {
      String ut = UserType.SUPPLIER.toString();

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
    } else {
      System.out.println("Username already exists. Please try again");
      registerSupplier();
    }
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
            System.out.println("4. My Orders");
            System.out.println("5. Sign Out");
            System.out.println("What would you like to do?");
            ch = option.nextInt();

            switch (ch) {
              case 1: //System.out.println("Under construction");
                listSupplierDetails(supId);
                break;
              case 2:
                addItem(supId);
                break;
              case 3:
                updateItemDetails(supId);
                break;
              case 4:
                checkOrders(supId);
                break;
              case 5: Runtime.getRuntime().halt(0);
              default: System.out.println("Please choose from the menu options");
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
    System.out.println("1. Display Details");
    System.out.println("2. Update Details");
    System.out.println("Your option?");
    int ch = option.nextInt();

    switch (ch) {
      case 1:
        Supplier s = SupplierFactory.findDetails(supId);
        if (s != null) {
          System.out.println("ID: " + s.getSupplierId() + " | Name: "
              + s.getSupplierName() + " | Phone: " + s.getPhoneNumber()
              + " | Address: " + s.getAddress() + " | Email: " + s.getEmail());
          System.out.println("====================================================================================");
        } else {
          System.out.println("Unable to retrieve details. Please check Id and try again");
        }
        break;
      case 2:
        System.out.println("1. Update Password");
        System.out.println("2. Update Personal Details");
        System.out.println("Enter your option: ");
        int op = option.nextInt();

        switch (op) {
          case 1:
            System.out.println("Enter New Password: ");
            String newPass = option.next();
            System.out.println("Confirm New Password: ");
            String confirmPass = option.next();

            if (newPass.equals(confirmPass)) {
              String msg = LoginFactory.updatePassword(supId, newPass);
              System.out.println(msg);
            } else {
              System.out.println("Passwords don't match. Please try again!");
              //listSupplierDetails(supId);
            }
            break;
          case 2:
            updatePersonalDetails(supId);
            System.out.println("Do you want to see or update any other details? Y or N");
            char c = option.next().charAt(0);
            if (c == 'Y' || c == 'y') {
              updatePersonalDetails(supId);
            }
            break;
          default:
            break;
        }
      default:
        //System.out.println("Please choose again");
        //listSupplierDetails(supId);
        break;
    }
  }

  private void updatePersonalDetails(final int supId) {
    System.out.println("1. Update Address");
    System.out.println("2. Update Phone");
    System.out.println("3. Update Email");
    int op = option.nextInt();
    int res = 0;
    String msg = null;
    switch (op) {
      case 1:
        System.out.println("Enter new address: ");
        System.out.print("City: ");
        String city = option.next();
        System.out.print("State: ");
        String state = option.next();
        System.out.print("Country: ");
        String country = option.next();
        String supAddress = city + ", " + state + ", " + country;

        res = SupplierFactory.updateAddress(supId, supAddress);

        msg = "Address Update Unsuccessful";
        if (res > 0) {
          msg = "Address Updated Successfully";
        }
        System.out.println(msg);
        break;
      case 2:
        System.out.print("Enter New Phone Number: ");
        String phone = option.next();

        res = SupplierFactory.updatePhone(supId, phone);
        msg = "Phone Update Unsuccessful";
        if (res > 0) {
          msg = "Phone Updated Successfully";
        }
        System.out.println(msg);
        break;
      case 3:
        System.out.print("Email: ");
        String emailAdd = option.next();
        res = SupplierFactory.updateEmail(supId, emailAdd);
        msg = "Email Update Unsuccessful";
        if (res > 0) {
          msg = "Email Updated Successfully";
        }
        System.out.println(msg);
        break;
      default:
        listSupplierDetails(supId);
        break;
    }
  }

  private void addItem(final int supId) {
    System.out.println("Please enter the item details: ");
    System.out.println("Item Name: ");
    String name = option.next();
    System.out.println("Price Per Unit: ");
    double price = option.nextDouble();
    System.out.println("Category: ");
    String cat = option.next();

    Items item = new Items();

    String msg = item.addNewItem(supId, price, name, cat);
    System.out.println(msg);
  }

  private void checkOrders(final int supId) {
    System.out.println("1. List All My Orders.");
    System.out.println("2. List My Pending Orders");
    System.out.println("3. Display Order Details");
    System.out.println("Your Choice? ");
    int ch = option.nextInt();

    Supplier s = new Supplier();

    switch (ch) {
      case 1:
        listMyOrders(supId);
        break;
      case 2:
        Orders[] pending = s.pendingOrders(supId);
        if (pending.length > 0) {
          for (Orders o: pending) {
            System.out.println(o.toString());
            System.out.println("Press 1 to Accept Order. Press 2 to Deny Order:");
            int ch1 = option.nextInt();

            String stat = null;

            switch (ch1) {
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
        break;
      case 3:
        System.out.println("Enter the Order Id for complete details:");
        int ordId = option.nextInt();
        Orders o = OrdersFactory.showOrderDetails(ordId);
        if (o != null) {
          System.out.println(o.toString());
        } else {
          System.out.println("Wrong Id. Please try again");
        }
        break;
      default:
        System.out.println("Choose from the given options");
        break;
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

  private void updateItemDetails(final int argSupplier) {
    Items[] list = ItemsFactory.retrieveItemsList(argSupplier);

    if (list.length > 0) {
      for (Items i: list) {
        System.out.println(i.toString());
      }

      System.out.println("Enter the ItemId to update: ");
      int id = option.nextInt();

      Items item = ItemsFactory.listItemDetails(id);

      if (item != null) {
        System.out.println("Enter the new price: ");
        double price = option.nextDouble();

        String msg = ItemsFactory.updatePrice(price, id);
        System.out.println(msg);
      } else {
        System.out.println("Wrong Item Id. Please enter the id again");
        updateItemDetails(argSupplier);
      }
    }
  }
}
