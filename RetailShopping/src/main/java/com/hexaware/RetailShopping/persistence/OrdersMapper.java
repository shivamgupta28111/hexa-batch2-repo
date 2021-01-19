package com.hexaware.RetailShopping.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.RetailShopping.model.Orders;
import com.hexaware.RetailShopping.model.OrderStatus;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

/**
 * OrdersMapper class.
 */
public class OrdersMapper implements ResultSetMapper<Orders> {

  /**
   * map method.
   * @param idx for index
   * @param rs for resultset
   * @param ctx for context
   * @return orders object
   * @throws SQLException for SQL exception
   */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    OrderStatus stat = OrderStatus.valueOf(rs.getString("ORDERSTATUS"));
    return new Orders(rs.getInt("ORDERID"), rs.getDate("ORDERDATE"), rs.getInt("BUYERID"),
        rs.getInt("SUPPLIERID"), rs.getInt("ITEMID"), rs.getInt("ITEMQUANTITY"), stat);
  }
}
