package com.web.usecase;

import com.web.domain.model.SellItems;
import com.web.domain.type.sellitem.ItemOrder;
import com.web.domain.type.sellitem.SaleStatus;

public interface ISellerItemRepository {
	public SellItems findByName(String productName, ItemOrder order, SaleStatus status);
}
