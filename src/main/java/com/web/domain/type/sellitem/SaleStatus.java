package com.web.domain.type.sellitem;

public enum SaleStatus {
	SALE(0), SOLD_OUT(1), ALL(2);
	private final int id;

	private SaleStatus(final int id) {
		this.id = id;
	}

	public static SaleStatus value(String status) {
		if (status == null) {
			return SALE;// デフォルト値
		}
		for (SaleStatus saleStatus : values()) {
			if (saleStatus.toString() == status.trim()) {
				return saleStatus;
			}
		}
		return SALE;// デフォルト値
	}
}
