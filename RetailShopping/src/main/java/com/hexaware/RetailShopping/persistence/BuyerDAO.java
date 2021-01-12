package com.hexaware.RetailShopping.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

import com.hexaware.RetailShopping.model.Buyer;

/**
 * Class used to fetch data from th Buyer Table.
 */
public interface BuyerDAO {
  /**
   * to retrieve all buyers.
   * @return a list of buyers
   */
  @SqlQuery("SELECT * FROM BUYER")
  @Mapper(BuyerMapper.class)
  List<Buyer> listAllBuyers();

  /**
   * to get the details of a particular buyer.
   * @return Buyer object
   */
  @SqlQuery("SELECT * FROM BUYER WHERE BUYERID = :buyerId")
  @Mapper(BuyerMapper.class)
  Buyer listBuyerDetails(@Bind("buyerId") int buyerId);


}