package com.hexaware.RetailShopping.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.RetailShopping.model.Buyer;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;


/**
 * BuyerMapper class.
 */
public class BuyerMapper implements ResultSetMapper<Buyer> {

  /**
   * map method.
   * @param idx for index
   * @param rs for resultset
   * @param ctx for context
   * @return Buyer object
   * @throws SQLException for SQL exception
   */
  public final Buyer map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    return new Buyer(rs.getInt("BUYERID"), rs.getString("BUYERNAME"),
        rs.getString("ADDRESS"), rs.getString("PHONE"), rs.getString("EMAILADDRESS"),
        rs.getDouble("WALLETBALANCE"));
  }
}
