package com.hexaware.RetailShopping.persistence;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
   * @throws DateTimeParseException for parse exception
   */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException, DateTimeParseException {
    OrderStatus stat = OrderStatus.valueOf(rs.getString("ORDERSTATUS"));
    Date d = rs.getDate("ORDERDATE");
    LocalDate date = LocalDate.parse(new SimpleDateFormat("yyyy-mm-dd").format(d));
    return new Orders(rs.getInt("ORDERID"), date, rs.getInt("BUYERID"),
        rs.getInt("SUPPLIERID"), rs.getInt("ITEMID"), rs.getInt("ITEMQTY"), stat);
  }
}
