package com.hexaware.RetailShopping.util;

import java.util.Scanner;

/**
 * Main class for the project.
 */
public class CliMain {

  private static Scanner sc = new Scanner(System.in, "UTF-8");

  /**
   * main menu method.
   */
  private void mainMenu() {
    System.out.println("==============RETAIL SHOPPING SYSTEM================");
    System.out.println("____________________________________________________");

    System.out.println("1. Buyer?");
    System.out.println("2. Supplier?");
    System.out.println("3. Exit");
    System.out.println("Select your role: ");
    int role = sc.nextInt();
    subMenu(role);
  }

  private void subMenu(final int role) {
    switch (role) {
      case 1: BuyerUtil cu = new BuyerUtil();
        cu.buyerMenu();
        break;
      case 2: SupplierUtil su = new SupplierUtil();
        su.supplierMenu();
        break;
      case 3:
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Please select either 1 or 2");
        mainMenu();
    }
  }

  /**
   * main method is the entry point to the project.
   * @param args for command line args
   */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
