package com.hexaware.RetailShopping.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Date;
import java.util.List;

import com.hexaware.RetailShopping.model.Orders;
/**
 * class for OrdersDAO.
 */
public interface OrdersDAO {
  /**
   * query to get all the orders.
   * @return a list of orders
   */
  @SqlQuery("SELECT * FROM ORDERS")
  @Mapper(OrdersMapper.class)
  List<Orders> listAllOrders();

  /**
   * query to retrieve a single order's details.
   * @param orderId for orderId
   * @return order details
   */
  @SqlQuery("SELECT * FROM ORDERS WHERE ORDERID = :orderId")
  @Mapper(OrdersMapper.class)
  Orders showOrderDetails(@Bind("ORDERID") final int orderId);

  /**
   * query to retrieve order history of a particular buyer.
   * @param buyerId for buyerID
   * @return a list of orders
   */
  @SqlQuery("SELECT * FROM ORDERS WHERE BUYERID = :buyerId")
  @Mapper(OrdersMapper.class)
  List<Orders> showAllBuyerOrders(@Bind("BUYERID") final int buyerId);

  /**
   * query to insert a new order.
   * @param orderId for orderid
   * @param orderDate for orderDate
   * @param buyerId for buyerid
   * @param supplierId for supplierid
   * @param itemId for itemid
   * @param itemQty for quantity
   * @param orderStatus for status
   * @return int
   */
  @SqlUpdate("INSERT INTO ORDERS VALUES (:orderId, :orderDate, :buyerId, :supplierId, :itemId, :itemQty, :orderStatus)")
  int newOrder(@Bind("orderId") final int orderId, @Bind("orderDate") final Date orderDate,
      @Bind("buyerId") final int buyerId, @Bind("supplierId") final int supplierId, @Bind("itemId") final int itemId,
      @Bind("itemQty") final int itemQty, @Bind("orderStatus") final String orderStatus);

  /**
   * query to update orderAmount.
   * @param orderId for order id
   * @param orderAmt for orderamount
   * @return int
   */
  @SqlUpdate("UPDATE ORDERS SET ORDERAMOUNT = :orderAmt WHERE ORDERID = :orderId")
  int updateOrder(@Bind("orderAmt") final double orderAmt, @Bind("orderId") final int orderId);

  /**
   * query to get the pending orders.
   * @param supplierId for supplier id
   * @return list of orders
   */
  @SqlQuery("SELECT * FROM ORDERS WHERE SUPPLIERID = :supplierId AND ORDERSTATUS = 'PENDING'")
  @Mapper(OrdersMapper.class)
  List<Orders> showAllPendingOrders(@Bind("supplierId") final int supplierId);

  /**
   * query to update order status.
   * @param status for order status
   * @param orderId for order id
   * @return int
   */
  @SqlUpdate("UPDATE ORDERS SET ORDERSTATUS = :status WHERE ORDERID = :orderId")
  int updateStatus(@Bind("status") final String status, @Bind("orderId") final int orderId);

  /**
   * query to get all the orders for a particular supplier.
   * @param supplier for supplier
   * @return list of orders
   */
  @SqlQuery("SELECT * FROM ORDERS WHERE SUPPLIERID = :supplier")
  @Mapper(OrdersMapper.class)
  List<Orders> listAllSupplierOrders(@Bind("supplier") final int supplier);
}
