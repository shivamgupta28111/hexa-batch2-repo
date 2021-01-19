package com.hexaware.RetailShopping.model;

import java.util.Date;
import java.util.Objects;

/**
 * class for Orders.
 */
public class Orders {
  /**
   * orderId for order id.
   */
  private int orderId;
  /**
   * orderDate for order date.
   */
  private Date orderDate;
  /**
   * buyerId for buyer id.
   */
  private int buyerId;
  /**
   * supplierId for supplier id.
   */
  private int supplierId;

  /**
   * itemId to store item id.
   */
  private int itemId;

  /**
   * itemQuantity for storing item quantity.
   */
  private int itemQuantity;
  /**
   * orderAmt for order amount.
   */
  private double orderAmt;
  /**
   * orderStatus to store the order status.
   */
  private OrderStatus orderStatus;

  /**
   *
   * @return orderId.
   */
  public final int getOrderId() {
    return this.orderId;
  }

  /**
   *
   * @param argOrderId for orderId.
   */
  public final void setOrderId(final int argOrderId) {
    this.orderId = argOrderId;
  }

  /**
   *
   * @return orderDate.
   */
  public final Date getOrderDate() {
    return this.orderDate;
  }

  /**
   *
   * @param argOrderDate to set order date.
   */
  public final void setOrderDate(final Date argOrderDate) {
    this.orderDate = argOrderDate;
  }

  /**
   *
   * @return buyerId.
   */
  public final int getBuyerId() {
    return this.buyerId;
  }

  /**
   *
   * @param argBuyerId to set customerbuyer Id.
   */
  public final void setBuyerId(final int argBuyerId) {
    this.buyerId = argBuyerId;
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
   * @param argSupplierId to set supplier Id.
   */
  public final void setSupplierId(final int argSupplierId) {
    this.supplierId = argSupplierId;
  }

  /**
   *
   * @return itemId.
   */
  public final int getItemId() {
    return this.itemId;
  }

  /**
   *
   * @param argItemId for itemId.
   */
  public final void setItemId(final int argItemId) {
    this.itemId = argItemId;
  }

  /**
   *
   * @return itemQuantity.
   */
  public final int getItemQuantity() {
    return itemQuantity;
  }

  /**
   *
   * @param argItemQty for itemQuantity.
   */
  public final void setItemQuantity(final int argItemQty) {
    this.itemQuantity = argItemQty;
  }
  /**
   *
   * @return orderAmt.
   */
  public final double getOrderAmt() {
    return this.orderAmt;
  }

  /**
   *
   * @param argAmt to set the order amount.
   */
  public final void setOrderAmt(final double argAmt) {
    this.orderAmt = argAmt;
  }

  /**
   *
   * @return orderStatus.
   */
  public final OrderStatus getOrderStatus() {
    return this.orderStatus;
  }

  /**
   *
   * @param argOrderStatus to set the order status.
   */
  public final void setOrderStatus(final OrderStatus argOrderStatus) {
    this.orderStatus = argOrderStatus;
  }

  /**
   * default constructor.
   */
  public Orders() {

  }

  /**
   * parameterized constructor.
   * @param argOrderId for order id
   * @param argOrderDate for order date
   * @param argBuyerId for buyerId
   * @param argSupplierId for supplierId
   * @param argItemId for itemId
   * @param argItemQty for itemQuantity
   * @param argOrderStatus for orderStatus
   */
  public Orders(final int argOrderId, final Date argOrderDate,
      final int argBuyerId, final int argSupplierId, final int argItemId,
      final int argItemQty, final OrderStatus argOrderStatus) {
    this.orderId = argOrderId;
    this.orderDate = argOrderDate;
    this.buyerId = argBuyerId;
    this.supplierId = argSupplierId;
    this.itemId = argItemId;
    this.itemQuantity = argItemQty;
    this.orderStatus = argOrderStatus;
  }

  /**
   * equals method.
   * @param obj Object
   * @return true or false
   */
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders order = (Orders) obj;
    if (Objects.equals(orderId, order.orderId)
        && Objects.equals(orderDate, order.orderDate)
        && Objects.equals(buyerId, order.buyerId)
        && Objects.equals(supplierId, order.supplierId)
        && Objects.equals(itemId, order.itemId)
        && Objects.equals(itemQuantity, order.itemQuantity)
        && Objects.equals(orderAmt, order.orderAmt)
        && Objects.equals(orderStatus, order.orderStatus)) {
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
    return Objects.hash(orderId, orderDate, orderAmt, buyerId,
        supplierId, itemId, itemQuantity, orderStatus);
  }

  /**
   * toString method.
   * @return string
   */
  @Override
  public final String toString() {
    return "Orders: [Order Id: " + this.orderId
        + " Order Date: " + this.orderDate
        + " Order Amount: " + this.orderAmt
        + " Buyer Id: " + this.buyerId
        + " Supplier Id: " + this.supplierId
        + " Item Id: " + this.itemId
        + " Item Quantity: " + this.itemQuantity
        + " Order Status: " + this.orderStatus
        + " ]";
  }

  /**
   * method to retrieve order details for a particular order.
   * @param argOrderId for orderId.
   * @return Orders object
   */
  public final Orders retrieveOrderDetails(final int argOrderId) {
    Orders order = new Orders();
    return order;
  }
}
