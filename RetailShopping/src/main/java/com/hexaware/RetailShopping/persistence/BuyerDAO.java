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
   * @param buyerId for buyerId
   * @return Buyer object
   */
  @SqlQuery("SELECT * FROM BUYER WHERE BUYERID = :buyerId")
  @Mapper(BuyerMapper.class)
  Buyer listBuyerById(@Bind("buyerId") int buyerId);

  /**
   * to register a new buyer.
   * @param buyerId for buyerId
   * @param buyerName for buyer name
   * @param address for address
   * @param phone for phone
   * @param email for email
   * @param wallet for wallet balance
   * @return int
   */
  @SqlUpdate("INSERT INTO BUYER VALUES (:buyerId, :buyerName, :address, :phone, :email, :wallet)")
  int registerBuyer(@Bind("buyerId") int buyerId, @Bind("buyerName") String buyerName,
      @Bind("address") String address, @Bind("phone") String phone,
      @Bind("email") String email, @Bind("wallet") double wallet);

    /**
     * method to decrement the wallet balance.
     * @param currentBalance for current wallet amount
     * @param orderAmount for the order amount
     * @param buyerId for buyerId
     */
  @SqlUpdate("UPDATE BUYER SET WALLETBALANCE = :currentBalance - :orderAmount WHERE BUYERID = :buyerId")
  void decrementBalance(@Bind("currentBalance") double currentBalance,
      @Bind("orderAmount") double orderAmount, @Bind("buyerId") int buyerId);

  /**
   * to increment balance.
   * @param currentBalance for current balance
   * @param orderAmount for order amount
   * @param buyerId for buyerId
   */
  @SqlUpdate("UPDATE BUYER SET WALLETBALANCE = :currentBalance + :orderAmount WHERE BUYERID = :buyerId")
  void incrementBalance(@Bind("currentBalance") double currentBalance,
      @Bind("orderAmount") double orderAmount, @Bind("buyerId") int buyerId);

  /**
   * to find the last supplier id.
   * @return supplier object
   */
  @SqlQuery("SELECT * FROM BUYER WHERE BUYERID = (SELECT MAX(BUYERID) FROM BUYER)")
  @Mapper(BuyerMapper.class)
  Buyer findLastRow();
}
