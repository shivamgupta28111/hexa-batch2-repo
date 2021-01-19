package com.hexaware.RetailShopping.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.RetailShopping.model.Supplier;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

/**
 * Mapper class for Supplier.
 */
public class SupplierMapper implements ResultSetMapper<Supplier> {

  /**
   * map method.
   * @param idx for index
   * @param rs for resultset
   * @param ctx for context
   * @return Supplier object
   * @throws SQLException for SQL exception
   */
  @Override
  public final Supplier map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    return new Supplier(rs.getInt("SUPPLIERID"), rs.getString("SUPPLIERNAME"),
        rs.getString("SUPPLIERADDRESS"), rs.getString("PHONENO"),
        rs.getString("EMAILADD"));
  }
}
