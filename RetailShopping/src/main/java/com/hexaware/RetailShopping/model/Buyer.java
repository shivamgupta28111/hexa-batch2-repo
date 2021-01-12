package com.hexaware.RetailShopping.model;

import java.util.Objects;

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
      final String argEmailAddr, final String argContact, final double argBal) {
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

  public void buyerOrderHistory(final int argBuyerId) {

  }

  public void updatePassword(final int argBuyerId, final String argNewPass) {

  }
}
