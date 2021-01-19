package com.hexaware.RetailShopping.persistence;

import java.util.List;

import com.hexaware.RetailShopping.model.Items;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * dao class for items.
 */
public interface ItemsDAO {
  /**
   * list of all items.
   * @return list of items
   */
  @SqlQuery("SELECT * FROM ITEMS")
  @Mapper(ItemsMapper.class)
  List<Items> listAllItems();

  /**
   * for a particular item.
   * @param itemId for item id
   * @return item
   */
  @SqlQuery("SELECT * FROM ITEMS WHERE ITEMID = :itemId")
  @Mapper(ItemsMapper.class)
  Items listItemDetails(@Bind("itemId") final int itemId);

  /**
   * to add a new item.
   * @param itemId for item id
   * @param itemName for itemname
   * @param unitPrice for price
   * @param itemCategory for category
   * @param supplierId for supplierid
   * @return int
   */
  @SqlUpdate("INSERT INTO ITEMS VALUES (:itemId, :itemName, :unitPrice, :itemCategory, :supplierId)")
  int uploadNewItem(@Bind("itemId") final int itemId, @Bind("itemName") final String itemName,
      @Bind("unitPrice") final double unitPrice, @Bind("itemCategory") final String itemCategory,
      @Bind("supplierId") final int supplierId);

  /**
   * to update price.
   * @param price for new price
   * @param itemId for item id
   * @return int
   */
  @SqlUpdate("UPDATE ITEMS SET UNITPRICE = :price WHERE ITEMID = :itemId")
  int updateItemPrice(@Bind("price") final double price, @Bind("itemId") final int itemId);

  /**
   * to find the last item id.
   * @return items object
   */
  @SqlQuery("SELECT * FROM ITEMS WHERE ITEMID = (SELECT MAX(ITEMID) FROM ITEMS)")
  @Mapper(ItemsMapper.class)
  Items findLastRow();
}
