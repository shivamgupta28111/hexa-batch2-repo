package com.hexaware.RetailShopping.factory;

import java.util.List;

import com.hexaware.RetailShopping.model.Items;
import com.hexaware.RetailShopping.persistence.DbConnection;
import com.hexaware.RetailShopping.persistence.ItemsDAO;

/**
 * factory class for items.
 */
public class ItemsFactory {
  /**
   * protected constructor.
   */
  protected ItemsFactory() {

  }

  /**
   * dao method.
   * @return ItemsDAO
   */
  private static ItemsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(ItemsDAO.class);
  }

  /**
   * a list of all items.
   * @return list of items
   */
  public static Items[] listAllItems() {
    List<Items> items = dao().listAllItems();
    return items.toArray(new Items[items.size()]);
  }

  /**
   * details of a particular item.
   * @param argItemId for item id
   * @return Items object
   */
  public static Items listItemDetails(final int argItemId) {
    Items item = dao().listItemDetails(argItemId);
    return item;
  }

  /**
   * to update the price.
   * @param price for new price
   * @param argItemId for item id
   * @return String
   */
  public static String updatePrice(final double price, final int argItemId) {
    String msg = "Update Unsuccessful";

    int res = dao().updateItemPrice(price, argItemId);
    if (res > 0) {
      msg = "Price updated successfully";
    }
    return msg;
  }

  /**
   * to add a new item.
   * @param argItemId for itemid
   * @param argItemName for itemname
   * @param argPrice for item price
   * @param argItemCat for category
   * @param argSupplierId for supplierid
   * @return int
   */
  public static int uploadItem(final int argItemId, final String argItemName, final double argPrice,
      final String argItemCat, final int argSupplierId) {
    int res = dao().uploadNewItem(argItemId, argItemName, argPrice, argItemCat, argSupplierId);
    return res;
  }

  /**
   * to get the last row.
   * @return items object
   */
  public static Items findLastRow() {
    Items item = dao().findLastRow();
    return item;
  }

  /**
   * to get the list of items for a particular supplier.
   * @param argSupplier for supplier id
   * @return items array
   */
  public static Items[] retrieveItemsList(final int argSupplier) {
    List<Items> items = dao().listSupplierItems(argSupplier);
    return items.toArray(new Items[items.size()]);
  }
}
