package com.hexaware.RetailShopping.factory;

import java.util.Date;
import java.util.List;

import com.hexaware.RetailShopping.model.Orders;
import com.hexaware.RetailShopping.persistence.DbConnection;
import com.hexaware.RetailShopping.persistence.OrdersDAO;

/**
 * factory class for Orders.
 */
public class OrdersFactory {
  /**
   * protected constructor.
   */
  protected OrdersFactory() {

  }

  /**
   * dao method for working with OrdersDAO.
   * @return OrdersDAO object
   */
  private static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }

  /**
   * show all orders.
   * @return orders array
   */
  public static Orders[] showAllOrders() {
    List<Orders> orders = dao().listAllOrders();
    return orders.toArray(new Orders[orders.size()]);
  }

  /**
   * return all pending orders.
   * @param argSupplierId for supplier id
   * @return pending orders array
   */
  public static Orders[] listPendingOrders(final int argSupplierId) {
    List<Orders> pendingList = dao().showAllPendingOrders(argSupplierId);
    return pendingList.toArray(new Orders[pendingList.size()]);
  }

  /**
   * to update order amount for new order.
   * @param argOrderId for orderid
   * @param argOrderAmt for orderamt
   * @return string
   */
  public static String updateOrderAmount(final int argOrderId, final double argOrderAmt) {
    String msg = "Update unsuccessful";
    int res = dao().updateOrder(argOrderAmt, argOrderId);

    if (res > 0) {
      msg = "Amount updated successfully";
    }

    return msg;
  }

  /**
   * to add new order.
   * @param argOrderId for orderid
   * @param argOrderDate for order date
   * @param argBuyerId for buyer id
   * @param argSupplierId for supplier id
   * @param argItemId for item id
   * @param argItemQty for item quantity
   * @param status for order status
   * @return string
   */
  public static String uploadNewOrder(final int argOrderId, final Date argOrderDate, final int argBuyerId,
      final int argSupplierId, final int argItemId, final int argItemQty, final String status) {
    String msg = "New Order Upload Unsuccessful";

    int res = dao().newOrder(argOrderId, argOrderDate, argBuyerId, argSupplierId, argItemId, argItemQty, status);

    if (res > 0) {
      msg = "New Order Uploaded Successfully";
    }
    return msg;
  }

  /**
   * method to update status.
   * @param status for status
   * @param argOrderId for orderid
   * @return string
   */
  public static String updateOrderStatus(final String status, final int argOrderId) {
    String msg = "Status Update Unsuccessful";

    int res = dao().updateStatus(status, argOrderId);

    if (res > 0) {
      msg = "Status updated successfully";
    }

    return msg;
  }

  /**
   * method to list supplier history.
   * @param argSupplier for supplier id
   * @return orders array
   */
  public static Orders[] listAllSupplierOrders(final int argSupplier) {
    List<Orders> orderList = dao().listAllSupplierOrders(argSupplier);
    return orderList.toArray(new Orders[orderList.size()]);
  }
}
