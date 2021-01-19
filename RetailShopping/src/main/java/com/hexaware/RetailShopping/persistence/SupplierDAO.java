package com.hexaware.RetailShopping.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

import com.hexaware.RetailShopping.model.Supplier;

/**
 * DAO class for suppliers.
 */
public interface SupplierDAO {

  /**
   * query to return the list of suppliers.
   * @return list of suppliers
   */
  @SqlQuery("SELECT * FROM SUPPLIERS")
  @Mapper(SupplierMapper.class)
  List<Supplier> showAllSuppliers();

  /**
   * query to return a particular supplier's details.
   * @param supplierId for supplierId
   * @return Supplier
   */
  @SqlQuery("SELECT * FROM SUPPLIERS WHERE SUPPLIERID = :supplierId")
  @Mapper(SupplierMapper.class)
  Supplier showById(@Bind("supplierId") final int supplierId);

  /**
   * query to insert new supplier.
   * @param supplierId for supplier id
   * @param supplierName for supplier name
   * @param address for address
   * @param phone for phone
   * @param email for email
   * @return int
   */
  @SqlUpdate("INSERT INTO SUPPLIERS VALUES(:supplierId, :supplierName, :address, :phone, :email)")
  int registerSupplier(@Bind("supplierId") final int supplierId, @Bind("supplierName") final String supplierName,
      @Bind("address") final String address, @Bind("phone") final String phone, @Bind("email") final String email);

  /**
   * to find the last supplier id.
   * @return supplier object
   */
  @SqlQuery("SELECT * FROM SUPPLIERS WHERE SUPPLIERID = (SELECT MAX(SUPPLIERID) FROM SUPPLIERS)")
  @Mapper(SupplierMapper.class)
  Supplier findLastRow();
}
