package com.hexaware.RetailShopping.model;

import java.util.Objects;

import com.hexaware.RetailShopping.factory.BuyerFactory;
import com.hexaware.RetailShopping.factory.LoginFactory;

/**
 * Buyer class.
 */
public class Buyer {
  /**
   * buyerId to store buyer Id.
   */
  private int buyerId;

  /**
   * buyerName to store buyer name.
   */
  private String buyerName;

  /**
   * addr to store buyer address.
   */
  private String addr;

  /**
   * contact to store buyer Contact #.
   */
  private String contact;

  /**
   * emailAddr to store the email address.
   */
  private String emailAddr;

  /**
   * walletBalance for wallet balance.
   */
  private double walletBalance;

  /**
   *
   * @return buyerId.
   */
  public final int getBuyerId() {
    return this.buyerId;
  }

  /**
   *
   * @param argCustId for buyerId.
   */
  public final void setBuyerId(final int argCustId) {
    this.buyerId = argCustId;
  }

  /**
   *
   * @return buyerName.
   */
  public final String getBuyerName() {
    return this.buyerName;
  }

  /**
   *
   * @param argCustName for buyerName.
   */
  public final void setBuyerName(final String argCustName) {
    this.buyerName = argCustName;
  }

  /**
   *
   * @return addr.
   */
  public final String getAddr() {
    return this.addr;
  }

  /**
   *
   * @param argAddr for addr.
   */
  public final void setAddr(final String argAddr) {
    this.addr = argAddr;
  }

  /**
   *
   * @return contact.
   */
  public final String getContact() {
    return this.contact;
  }

  /**
   *
   * @param argContact for contact.
   */
  public final void setContact(final String argContact) {
    this.contact = argContact;
  }

  /**
   *
   * @return emailAddr.
   */
  public final String getEmailAddr() {
    return this.emailAddr;
  }

  /**
   *
   * @param argEmail for emailAddr.
   */
  public final void setEmailAddr(final String argEmail) {
    this.emailAddr = argEmail;
  }

  /**
   *
   * @return walletBalance.
   */
  public final double getWalletBalance() {
    return this.walletBalance;
  }

  /**
   *
   * @param argBal for walletBalance.
   */
  public final void setWalletBalance(final double argBal) {
    this.walletBalance = argBal;
  }

  /**
   * default constructor.
   */
  public Buyer() {

  }

  /**
   * parameterized constructor.
   * @param argBuyerId for buyer Id
   * @param argBuyerName for buyer name
   * @param argAddr for address
   * @param argEmailAddr for email address
   * @param argContact for contact
   * @param argBal for wallet balance
   */
  public Buyer(final int argBuyerId, final String argBuyerName, final String argAddr,
      final String argContact, final String argEmailAddr, final double argBal) {
    this.buyerId = argBuyerId;
    this.buyerName = argBuyerName;
    this.addr = argAddr;
    this.contact = argContact;
    this.emailAddr = argEmailAddr;
    this.walletBalance = argBal;
  }

  /**
   * equals method.
   * @param obj Object
   * @return boolean value
   */
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Buyer buyer = (Buyer) obj;
    if (Objects.equals(buyerId, buyer.buyerId)
        && Objects.equals(buyerName, buyer.buyerName)
        && Objects.equals(addr, buyer.addr)
        && Objects.equals(contact, buyer.contact)
        && Objects.equals(emailAddr, buyer.emailAddr)
        && Objects.equals(walletBalance, buyer.walletBalance)) {
      return true;
    }
    return false;
  }

  /**
   * hashcode method.
   * @return hash code
   */
  @Override
  public final int hashCode() {
    return Objects.hash(buyerId, buyerName, addr, emailAddr, contact, walletBalance);
  }

  /**
   * toString method.
   * @return string
   */
  @Override
  public final String toString() {
    return "Buyer: [Buyer Id: " + this.buyerId
        + " Buyer Name: " + this.buyerName
        + " Address: " + this.addr
        + " Email Id: " + this.emailAddr
        + " Contact #: " + this.contact
        + " Wallet Balance: " + this.walletBalance
        + " ]";
  }

  // private Buyer[] createBuyerList() {
  //   Buyer[] buyers = new Buyer[5];

  //   buyers[0] = new Buyer(101, "Alex Jones", "Jaipur, Rajasthan, India", "alex.jones@abc.com",
  //       "923842221", 4500.00);
  //   buyers[1] = new Buyer(102, "Kavitha K", "Mumbai, Maharashtra, India", "kk@xyz.com",
  //       "983773722", 4500.00);
  //   buyers[2] = new Buyer(103, "Ravi L", "Guntur, AP, India", "ravi_l@xyz.com",
  //       "999001002", 4500.00);
  //   buyers[3] = new Buyer(104, "James W", "Delhi, Delhi, India", "jw123@xyz.com",
  //       "7292929222", 4500.00);
  //   buyers[4] = new Buyer(105, "Lavanya M", "Bangalore, Karnataka, India", "lav_m@abc.com",
  //       "7288920021", 4500.00);

  //   return buyers;
  // }

  /**
   * method to list a single buyer's details.
   * @param argBuyerId for buyerId
   * @return buyer object
   */
  public final Buyer listBuyerDetails(final int argBuyerId) {
    Buyer b = BuyerFactory.findBuyer(argBuyerId);
    return b;
  }

  /**
   * to register a new buyer.
   * @param argBuyerName for buyer name
   * @param argAddr for address
   * @param argPhone for phone
   * @param argEmail for email
   * @param user for username
   * @param pass for password
   * @param ut for usertype
   * @return string
   */
  public final String registerNewBuyer(final String argBuyerName, final String argAddr,
      final String argPhone, final String argEmail, final String user,
      final String pass, final String ut) {
    double wallet = 450000.00;
    String msg = "Registration Unsuccessful";
    Buyer b = BuyerFactory.findLastRow();

    int id = 1001;
    if (b != null) {
      id = b.getBuyerId() + 1;
    }
    int res = BuyerFactory.registerBuyer(id, argBuyerName, argAddr, argPhone, argEmail, wallet);
    if (res > 0) {
      res = LoginFactory.registerLogin(id, user, pass, ut);
      if (res > 0) {
        msg = "Registration successful. Please Login to continue";
      }
    }
    return msg;
  }
}
