package com.web.domain.model;

import java.util.Date;

import com.web.domain.type.sellitem.ItemOrder;
import com.web.domain.type.sellitem.SaleItemCond;
import com.web.domain.type.sellitem.SaleStatus;

/**
 * 商品
 */
public class SellItem {
	public String productCode;
	public String productName;
	public Integer salePrice;
	public SaleItemCond itemCondition;
	public Date saleDate;
	public SaleStatus saleStatus;

	public String content;
	public ItemOrder order;

	public SellItem() {
	}

	public SellItem(String name, String order, String status) {
		this.productName = name;
		this.order = ItemOrder.value(order);
		this.saleStatus = SaleStatus.value(status);
	}

	public boolean validate() {
		if (productName.isEmpty()) {
			this.content = "Invalid name parameter. Parameter name is empty.";
			return false;
		}
		return true;
	}

	public void setStatus(SellItems sellItems) {
		if (sellItems.list().isEmpty()) {
			this.content = "No results.";
			return;
		}
		this.content = sellItems.list().size() + " item were found.";
	}

	public String getContent() {
		return content;
	}

}
