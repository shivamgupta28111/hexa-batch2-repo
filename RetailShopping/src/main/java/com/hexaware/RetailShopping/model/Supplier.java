package com.hexaware.RetailShopping.model;

import java.util.Objects;

import com.hexaware.RetailShopping.factory.LoginFactory;
import com.hexaware.RetailShopping.factory.OrdersFactory;
//import com.hexaware.RetailShopping.factory.SupplierFactory;
import com.hexaware.RetailShopping.factory.SupplierFactory;

/**
 * Supplier class.
 */
public class Supplier {
  /**
   * supplierId for supplier id.
   */
  private int supplierId;

  /**
   * supplierName for supplier Name.
   */
  private String supplierName;

  /**
   * address for supplier address.
   */
  private String address;

  /**
   * phoneNumber for supplier contact no.
   */
  private String phoneNumber;

  /**
   * email for supplier email.
   */
  private String email;

  /**
   *
   * @param argSupplierId for Supplier Id.
   */
  public final void setSupplierId(final int argSupplierId) {
    this.supplierId = argSupplierId;
  }

  /**
   *
   * @return supplierId.
   */
  public final int getSupplierId() {
    return this.supplierId;
  }

  /**
   *
   * @param argSupplierName for supplier name.
   */
  public final void setSupplierName(final String argSupplierName) {
    this.supplierName = argSupplierName;
  }

  /**
   *
   * @return supplierName.
   */
  public final String getSupplierName() {
    return this.supplierName;
  }

  /**
   *
   * @return address.
   */
  public final String getAddress() {
    return this.address;
  }

  /**
   *
   * @param argAddress for address.
   */
  public final void setAddress(final String argAddress) {
    this.address = argAddress;
  }

  /**
   *
   * @return email.
   */
  public final String getEmail() {
    return this.email;
  }

  /**
   *
   * @param argEmail for email.
   */
  public final void setEmail(final String argEmail) {
    this.email = argEmail;
  }

  /**
   *
   * @return phoneNumber.
   */
  public final String getPhoneNumber() {
    return this.phoneNumber;
  }

  /**
   *
   * @param argPhone for phoneNumber.
   */
  public final void setPhoneNumber(final String argPhone) {
    this.phoneNumber = argPhone;
  }

  /**
   * default constructor.
   */
  public Supplier() {

  }

  /**
   * parameterized constructor.
   * @param argSupplierId for supplier id
   * @param argSupplierName for supplier name
   * @param argAddr for supplier address
   * @param argPhone for phone number
   * @param argEmail for email address
   */
  public Supplier(final int argSupplierId, final String argSupplierName, final String argAddr,
      final String argPhone, final String argEmail) {
    this.supplierId = argSupplierId;
    this.supplierName = argSupplierName;
    this.address = argAddr;
    this.phoneNumber = argPhone;
    this.email = argEmail;
  }

  /**
   * equals method.
   * @param obj Object
   * @return boolean
   */
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Supplier supplier = (Supplier) obj;
    if (Objects.equals(supplierId, supplier.supplierId)
        && Objects.equals(supplierName, supplier.supplierName)
        && Objects.equals(address, supplier.address)
        && Objects.equals(phoneNumber, supplier.phoneNumber)
        && Objects.equals(email, supplier.email)) {
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
    return Objects.hash(supplierId, supplierName, address, phoneNumber,
        email);
  }

  /**
   * toString method.
   * @return string
   */
  @Override
  public final String toString() {
    return "Supplier: [Supplier Id: " + this.supplierId
        + " Supplier Name: " + this.supplierName
        + " Address: " + this.address
        + " Phone Number: " + this.phoneNumber
        + " Email: " + this.email
        + " ]";
  }

  /**
   * to get all the orders for a particular supplier.
   * @param argSupplierId for supplier id
   * @return orders list
   */
  public final Orders[] supplierOrderHistory(final int argSupplierId) {
    Orders[] myList = OrdersFactory.listAllSupplierOrders(argSupplierId);
    return myList;
  }

  /**
   * to register a new supplier.
   * @param argSupplierName for supplier name
   * @param argAddress for address
   * @param argPhone for phone
   * @param argEmail for email
   * @param user for username
   * @param pass for password
   * @param ut for usertype
   * @return string
   */
  public final String registerSupplier(final String argSupplierName, final String argAddress,
      final String argPhone, final String argEmail, final String user,
      final String pass, final String ut) {
    Supplier s = SupplierFactory.findLastRow();
    int argSupplierId = 2001;

    if (s != null) {
      argSupplierId = s.getSupplierId() + 1;
    }

    String msg = "Registration Unsuccessful. Please try again";
    int res = SupplierFactory.registerSupplier(argSupplierId, argSupplierName, argAddress, argPhone, argEmail);
    if (res > 0) {
      res = LoginFactory.registerLogin(argSupplierId, user, pass, ut);
      if (res > 0) {
        msg = "Registration Successful. Please login to continue";
      }
    }
    return msg;
  }

  /**
   * method to accept or deny order.
   * @param argOrderId for order id
   * @param stat for status
   * @return string
   */
  public final String acceptDenyOrder(final int argOrderId, final String stat) {
    String msg = OrdersFactory.updateOrderStatus(stat, argOrderId);
    return msg;
  }

  /**
   * method to list pending orders.
   * @param argSupplier for supplier id
   * @return orders array
   */
  public final Orders[] pendingOrders(final int argSupplier) {
    Orders[] pendingList = OrdersFactory.listPendingOrders(argSupplier);
    return pendingList;
  }
}
