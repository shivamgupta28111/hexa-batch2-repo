package com.hexaware.RetailShopping.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.RetailShopping.model.Items;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * mapper class for items.
 */
public class ItemsMapper implements ResultSetMapper<Items> {

  /**
   * map method.
   * @param index for index
   * @param rs for ResultSet
   * @param ctx for StatementContext
   * @return Items object
   * @throws SQLException for sql exception
   */
  @Override
  public final Items map(final int index, final ResultSet rs, final StatementContext ctx) throws SQLException {
    return new Items(rs.getInt("ITEMID"), rs.getString("ITEMNAME"), rs.getDouble("UNITPRICE"),
        rs.getInt("SUPPLIERID"), rs.getString("ITEMCATEGORY"));
  }
}
