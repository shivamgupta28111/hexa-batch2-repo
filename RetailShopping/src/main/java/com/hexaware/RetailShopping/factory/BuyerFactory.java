package com.hexaware.RetailShopping.factory;

import java.util.List;

import com.hexaware.RetailShopping.model.Buyer;
import com.hexaware.RetailShopping.persistence.BuyerDAO;
import com.hexaware.RetailShopping.persistence.DbConnection;

/**
 * Factory class for Buyer.
 */
public class BuyerFactory {
  /**
   *  Protected constructor.
   */
  protected BuyerFactory() {

  }

  /**
   * dao method for working with BuyerDAO.
   * @return BuyerDAO object
   */
  private static BuyerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(BuyerDAO.class);
  }

  /**
   * to list all Buyers.
   * @return buyer array
   */
  public static Buyer[] showBuyers() {
    final List<Buyer> buyer = dao().listAllBuyers();
    return buyer.toArray(new Buyer[buyer.size()]);
  }

  /**
   * to get details of a particular buyer.
   * @param argBuyerId for buyerId
   * @return buyer
   */
  public static Buyer findBuyer(final int argBuyerId) {
    return dao().listBuyerById(argBuyerId);
  }

  /**
   * to register a new Buyer.
   * @param argBuyerId for buyerId
   * @param argBuyerName for buyer name
   * @param argAddress for address
   * @param argPhone for phone
   * @param argEmail for email
   * @param argWallet for wallet
   * @return int res
   */
  public static int registerBuyer(final int argBuyerId, final String argBuyerName, final String argAddress,
      final String argPhone, final String argEmail, final double argWallet) {
    int res = dao().registerBuyer(argBuyerId, argBuyerName, argAddress,
        argPhone, argEmail, argWallet);
    return res;
  }

  /**
   * updating the wallet balance.
   * @param argBuyerId for buyerid
   * @param currentBalance for current balance
   * @param orderAmount for orderamount
   * @return String.
   */
  public static String updateWalletBalance(final int argBuyerId, final double currentBalance, final double orderAmount) {
    dao().decrementBalance(currentBalance, orderAmount, argBuyerId);
    return "Order Placed. Wallet Updated!";
  }

  /**
   * to increment wallet balance.
   * @param argBuyerId for buyer id
   * @param currentBalance for current balance
   * @param orderAmount for order amount
   * @return string
   */
  public static String incrementOnOrderDenied(final int argBuyerId, final double currentBalance, final double orderAmount) {
    dao().incrementBalance(currentBalance, orderAmount, argBuyerId);
    return "Order Denied. Wallet Updated!";
  }
  /**
   * to get the last row.
   * @return buyer object
   */
  public static Buyer findLastRow() {
    Buyer b = dao().findLastRow();
    return b;
  }

  /**
   * update address.
   * @param buyer for buyer id
   * @param addr for address
   * @return int
   */
  public static int updateAddress(final int buyer, final String addr) {
    int res = dao().updateAddress(addr, buyer);
    return res;
  }

   /**
   * update phone.
   * @param buyer for buyer id
   * @param phone for phone
   * @return int
   */
  public static int updatePhone(final int buyer, final String phone) {
    int res = dao().updatePhone(phone, buyer);
    return res;
  }

   /**
   * update email.
   * @param buyer for buyer id
   * @param email for email
   * @return int
   */
  public static int updateEmail(final int buyer, final String email) {
    int res = dao().updateEmail(email, buyer);
    return res;
  }

  /**
   * add amount to the wallet.
   * @param buyer for buyer id
   * @param curBal for current balance
   * @param newAmt for new amount
   * @return int
   */
  public static int updateWalletAmount(final int buyer, final double curBal, final double newAmt) {
    int res = dao().updateWalletAmount(curBal, newAmt, buyer);
    return res;
  }
}
