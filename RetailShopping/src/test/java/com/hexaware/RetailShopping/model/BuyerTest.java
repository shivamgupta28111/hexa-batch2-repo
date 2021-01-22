package com.hexaware.RetailShopping.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.hexaware.RetailShopping.persistence.BuyerDAO;
import com.hexaware.RetailShopping.factory.BuyerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.Mocked;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Buyer.
 */
@RunWith(JMockit.class)
public class BuyerTest {
  /**
   * test the default constructor
   */
  @Test
  public final void testBuyer() {
    Buyer b = new Buyer();
    b.setBuyerId(1001);
    b.setBuyerName("Akhil");
    b.setAddr("Pathankot, Punjab, India");
    b.setContact("435839932");
    b.setEmailAddr("akhil@abc.c");
    b.setWalletBalance(450000);

    assertEquals(1001, b.getBuyerId());
    assertEquals("Akhil", b.getBuyerName());
    assertEquals("Pathankot, Punjab, India", b.getAddr());
    assertEquals("435839932", b.getContact());
    assertEquals("akhil@abc.c", b.getEmailAddr());
    assertEquals(450000, b.getWalletBalance(),2);
  }

  /**
   * test for setBuyerId method.
   */
  @Test
  public final void testSetBuyerId() {
    Buyer b = new Buyer(1234, "Akanksha Sinha", "Mangalore, Karnakata, India", "83495735", "wi@we.c", 45230);
    b.setBuyerId(1245);
    assertEquals(1245, b.getBuyerId());
  }

  /**
   * test for setBuyerName method.
   */
  @Test
  public final void testSetBuyerName() {
    Buyer b = new Buyer(1234, "Akanksha Sinha", "Mangalore, Karnakata, India", "83495735", "wi@we.c", 45230);
    b.setBuyerName("Aravinda Raghav");
    assertEquals("Aravinda Raghav", b.getBuyerName());
  }

  /**
   * test for setAddr method.
   */
  @Test
  public final void testSetAddress() {
    Buyer b = new Buyer(1234, "Akanksha Sinha", "Mangalore, Karnakata, India", "83495735", "wi@we.c", 45230);
    b.setAddr("Patna, Bihar, India");
    assertEquals("Patna, Bihar, India", b.getAddr());
  }

  /**
   * test for setContact method.
   */
  @Test
  public final void testSetContact() {
    Buyer b = new Buyer(1234, "Akanksha Sinha", "Mangalore, Karnakata, India", "83495735", "wi@we.c", 45230);
    b.setContact("3482882011");
    assertEquals("3482882011", b.getContact());
  }

  /**
   * test for setEmailAddr method.
   */
  @Test
  public final void testSetEmailAddress() {
    Buyer b = new Buyer(1234, "Akanksha Sinha", "Mangalore, Karnakata, India", "83495735", "wi@we.c", 45230);
    b.setEmailAddr("ie@ei.c");
    assertEquals("ie@ei.c", b.getEmailAddr());
  }

  /**
   * test for setWalletBalance method.
   */
  @Test
  public final void testSetWalletBalance() {
    Buyer b = new Buyer(1234, "Akanksha Sinha", "Mangalore, Karnakata, India", "83495735", "wi@we.c", 45230);
    b.setWalletBalance(23456);
    assertEquals(23456, b.getWalletBalance(), 2);
  }

  /**
   * testing a parameterized constructor.
   */
  @Test
  public final void testBuyers() {
    Buyer b = new Buyer(1234, "Akanksha Sinha", "Mangalore, Karnakata, India", "83495735", "wi@we.c", 45230);
    assertEquals(1234, b.getBuyerId());
    assertEquals("Akanksha Sinha", b.getBuyerName());
    assertEquals("Mangalore, Karnakata, India", b.getAddr());
    assertEquals("83495735", b.getContact());
    assertEquals("wi@we.c", b.getEmailAddr());
    assertEquals(45230, b.getWalletBalance(), 1);
  }

  /**
   * test for listBuyerDetails method.
   * @param dao for BuyerDao
   */
  @Test
  public final void testListBuyerDetails(@Mocked final BuyerDAO dao) {
    final Buyer b1 = new Buyer(1234, "Akanksha Sinha", "Mangalore, Karnakata, India", "83495735", "wi@we.c", 45230);
    final Buyer b2 = new Buyer(1345, "Anirudh", "Chennai, Tamil Nadu, India", "89345543", "yt@sf.c", 87382);
    final Buyer b3 = new Buyer(1451, "Bhavana Bhat", "Mangalore, Karnakata, India", "82772111", "yr@ss.o", 92811);

    new Expectations(){
      {
        dao.listBuyerById(1234); result = b1;
        dao.listBuyerById(1345); result = b2;
        dao.listBuyerById(1451); result = b3;

        dao.listBuyerById(100); result = null;
      }
    };

    new MockUp<BuyerFactory>() {
      @Mock
      BuyerDAO dao() {
        return dao;
      }
    };

    Buyer buyer1 = BuyerFactory.findBuyer(1234);
    assertEquals(b1, buyer1);

    Buyer buyer2 = BuyerFactory.findBuyer(1345);
    assertEquals(b2, buyer2);

    Buyer buyer3 = BuyerFactory.findBuyer(1451);
    assertEquals(b3, buyer3);

    Buyer buyer4 = BuyerFactory.findBuyer(100);
    assertNull(buyer4);
  }
}
