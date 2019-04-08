package com.web.domain.model;

import java.util.List;

/**
 * 商品一覧
 */
public class SellItems {
	public List<SellItem> list;

	public SellItems(List<SellItem> list) {
		this.list = list;
	}

	public List<SellItem> list() {
		return list;
	}
}