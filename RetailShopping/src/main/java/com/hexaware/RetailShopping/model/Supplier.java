package com.hexaware.RetailShopping.model;

import java.util.Objects;

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

  // public void retrievePendingOrders(final int argSupplierId) {
  //   //get list of pending orders for supplier
  // }

  // public void acceptDenyOrder(final int argOrderId, final String argOrderStat) {
  //   //change status of order based on orderid
  // }

  // public void supplierOrderHistory(final int argSupplierId) {
  //   //get list of all orders for a particular supplier
  // }
}
