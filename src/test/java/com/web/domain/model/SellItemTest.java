package com.web.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.web.domain.type.sellitem.ItemOrder;
import com.web.domain.type.sellitem.SaleStatus;

public class SellItemTest {

	@Test
	public void testNameValidateOk() {
		SellItem sellItem = new SellItem("jhon", "", "");
		assertTrue(sellItem.validate());
		assertEquals(null, sellItem.getContent());
	}

	@Test
	public void testNameValidateFailure() {
		SellItem sellItem = new SellItem("", "", "");
		assertFalse(sellItem.validate());
		assertEquals("Invalid name parameter. Parameter name is empty.", sellItem.getContent());
	}

	@Test
	public void testItemOrderDefault() {
		SellItem sellItem = new SellItem("jhon", "", "");
		assertEquals(ItemOrder.PRICE_ASC, sellItem.order);
	}

	@Test
	public void testItemOrderPriceDesc() {
		SellItem sellItem = new SellItem("jhon", "PRICE_DESC", "");
		assertEquals(ItemOrder.PRICE_DESC, sellItem.order);
	}

	@Test
	public void testSaleStatusDefault() {
		SellItem sellItem = new SellItem("jhon", "PRICE_ASC", "");
		assertEquals(SaleStatus.SALE, sellItem.saleStatus);
	}

	@Test
	public void testSaleStatusALL() {
		SellItem sellItem = new SellItem("jhon", "PRICE_ASC", "ALL");
		assertEquals(SaleStatus.ALL, sellItem.saleStatus);
	}

}
