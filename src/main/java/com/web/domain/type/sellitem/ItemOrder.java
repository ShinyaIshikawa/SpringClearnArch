package com.web.domain.type.sellitem;

public enum ItemOrder {
	PRICE_ASC(0), PRICE_DESC(1), SELL_DATE_ASC(2), SELL_DATE_DESC(3);
	private final int id;

	private ItemOrder(final int id) {
		this.id = id;
	}

	public static ItemOrder value(String cond) {
		if (cond == null) {
			return PRICE_ASC;// デフォルト値
		}
		for (ItemOrder order : values()) {
			if (order.toString() == cond.trim()) {
				return order;
			}
		}
		return PRICE_ASC;// デフォルト値
	}
}
