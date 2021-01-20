package com.hexaware.RetailShopping.factory;

import com.hexaware.RetailShopping.model.Supplier;
import com.hexaware.RetailShopping.persistence.DbConnection;
import com.hexaware.RetailShopping.persistence.SupplierDAO;

/**
 * factory class for Supplier.
 */
public class SupplierFactory {
  /**
   * protected constructor.
   */
  protected SupplierFactory() {

  }

  /**
   * dao method for working with BuyerDAO.
   * @return BuyerDAO object
   */
  private static SupplierDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(SupplierDAO.class);
  }

  /**
   * method to get the supplier details.
   * @param argSupplierId for supplier id
   * @return supplier object
   */
  public static Supplier findDetails(final int argSupplierId) {
    Supplier s = dao().showById(argSupplierId);
    return s;
  }

  /**
   * to register a new supplier.
   * @param argSupplierId for supplier id
   * @param argSupplierName for name
   * @param argAddress for address
   * @param argPhone for phone
   * @param argEmail for email
   * @return int
   */
  public static int registerSupplier(final int argSupplierId, final String argSupplierName,
      final String argAddress, final String argPhone, final String argEmail) {
    int res = dao().registerSupplier(argSupplierId, argSupplierName, argAddress, argPhone, argEmail);
    return res;
  }

  /**
   * to get the last supplier id entered.
   * @return Supplier object
   */
  public static Supplier findLastRow() {
    Supplier s = dao().findLastRow();
    return s;
  }

  /**
   * update address.
   * @param argSupplier for supplier id
   * @param addr for address
   * @return int
   */
  public static int updateAddress(final int argSupplier, final String addr) {
    int res = dao().updateAddress(addr, argSupplier);
    return res;
  }

   /**
   * update phone.
   * @param argSupplier for supplier id
   * @param phone for phone
   * @return int
   */
  public static int updatePhone(final int argSupplier, final String phone) {
    int res = dao().updatePhone(phone, argSupplier);
    return res;
  }

   /**
   * update email.
   * @param argSupplier for supplier id
   * @param email for email
   * @return int
   */
  public static int updateEmail(final int argSupplier, final String email) {
    int res = dao().updateEmail(email, argSupplier);
    return res;
  }
}
