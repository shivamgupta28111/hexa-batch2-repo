/**
 * constructor -> a special method with constructs an object for a class
 * 1. constructor should be public
 * 2. constructors are not inherited
 * 3. constructors have the name of the class
 * 4. constructors DO NOT have a return type
 * 5. constructors can be overloaded
 *
 * Types:
 * 1. default constructor
 * 2. parameterized constructor
 */
package com.hexaware.RetailShopping.model;

import java.util.Objects;

import com.hexaware.RetailShopping.factory.ItemsFactory;

/**
 * Items class.
 */
public class Items {
  /**
   * itemId for item id.
   */
  private int itemId;

  /**
   * itemName for item name.
   */
  private String itemName;

  /**
   * price for unit price.
   */
  private double price;

  /**
   * supplierId for supplier Id.
   */
  private int supplierId;

  /**
   * itemCategory for type of item.
   */
  private String itemCategory;

  // /**
  //  * an array of items - temporary.
  //  */
  // private Items[] itemsList = new Items[5];

  // /**
  //  * list of items - temporary.
  //  */
  // private List<Items> items = new ArrayList<Items>();

  /**
   *
   * @return itemId.
   */
  public final int getItemId() {
    return this.itemId;
  }

  /**
   *
   * @param argItemId for itemId.
   */
  public final void setItemId(final int argItemId) {
    this.itemId = argItemId;
  }

  /**
   *
   * @return itemName.
   */
  public final String getItemName() {
    return this.itemName;
  }

  /**
   *
   * @param argItemName for itemName.
   */
  public final void setItemName(final String argItemName) {
    this.itemName = argItemName;
  }

  /**
   *
   * @return price.
   */
  public final double getPrice() {
    return this.price;
  }

  /**
   *
   * @param argPrice for price.
   */
  public final void setPrice(final double argPrice) {
    this.price = argPrice;
  }

  /**
   *
   * @return supplierId.
   */
  public final int getSupplierId() {
    return this.supplierId;
  }

  /**
   *
   * @param argSupplierId for supplierId.
   */
  public final void setSupplierId(final int argSupplierId) {
    this.supplierId = argSupplierId;
  }

  /**
   *
   * @return itemCategory.
   */
  public final String getItemCategory() {
    return this.itemCategory;
  }

  /**
   *
   * @param argItemCat for itemCategory.
   */
  public final void setItemCategory(final String argItemCat) {
    this.itemCategory = argItemCat;
  }

  /**
   * default constructor.
   */
  public Items() {

  }

  /**
   * parameterized constructor for Items.
   * @param argItemId for itemId
   * @param argItemName for itemName
   * @param argPrice for price
   * @param argSupplierId for supplierId
   * @param argItemCat for itemCategory
   */
  public Items(final int argItemId, final String argItemName, final double argPrice,
      final int argSupplierId, final String argItemCat) {
    this.itemId = argItemId;
    this.itemName = argItemName;
    this.price = argPrice;
    this.supplierId = argSupplierId;
    this.itemCategory = argItemCat;
  }

  /**
   * equals method.
   * @param obj Object
   * @return true or false
   */
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Items item = (Items) obj; //type casting
    if (Objects.equals(itemId, item.itemId)
        && Objects.equals(itemName, item.itemName)
        && Objects.equals(price, item.price)
        && Objects.equals(supplierId, item.supplierId)
        && Objects.equals(itemCategory, item.itemCategory)) {
      return true;
    }
    return false;
  }

  /**
   * hashcode method.
   * @return hash code
   */
  @Override
  public final int hashCode() {
    return Objects.hash(itemId, itemName, price, supplierId,
        itemCategory);
  }

  /**
   * toString method.
   * @return string
   */
  @Override
  public final String toString() {
    return "Items: [Item Id: " + this.itemId + " Item Name: " + this.itemName
        + " UnitPrice: " + this.price + " Supplier Id: " + this.supplierId
        + " Item Category: " + this.itemCategory
        + " ]";
  }

  /**
   * to add a new item.
   * @param argSupplierId for supplierId
   * @param argPrice for price
   * @param argItemName for itemName
   * @param argCat for itemCategory
   * @return String
   */
  public final String addNewItem(final int argSupplierId, final double argPrice, final String argItemName,
      final String argCat) {
    Items item = ItemsFactory.findLastRow();
    String msg = "Unable to add new item";
    int id = 4001;

    if (item != null) {
      id = item.getItemId() + 1;
    }

    int res = ItemsFactory.uploadItem(id, argItemName, argPrice, argCat, argSupplierId);
    if (res > 0) {
      msg = "New Item Uploaded Successfully";
    }
    return msg;
  }
}
