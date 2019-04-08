package com.web.adapter.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.domain.model.SellItem;
import com.web.domain.model.SellItems;
import com.web.domain.type.sellitem.ItemOrder;
import com.web.domain.type.sellitem.SaleStatus;
import com.web.usecase.ISellerItemRepository;

@Repository
@Transactional
public class SellItemRepository implements ISellerItemRepository {
	SellItemMapper mapper;

	@Override
	public SellItems findByName(String productName, ItemOrder order, SaleStatus status) {
		List<SellItem> sellItems = mapper.selectByName(productName, getOrderStatement(order), getAddCond(status));
		System.out.println(sellItems);
		return new SellItems(sellItems);
	}

	SellItemRepository(SellItemMapper mapper) {
		this.mapper = mapper;
	}

	private String getAddCond(SaleStatus status) {
		switch (status) {
		case SALE:
			return "sale_status = 0";
		case SOLD_OUT:
			return "sale_status = 1";
		default:
			return "1 = 1";
		}
	}

	private String getOrderStatement(ItemOrder order) {
		switch (order) {
		case PRICE_ASC:
			return "sale_price";
		case PRICE_DESC:
			return "sale_price desc";
		case SELL_DATE_ASC:
			return "sale_date";
		case SELL_DATE_DESC:
			return "sale_date desc";
		default:
			return "sale_price";
		}
	}
}
