package com.web.usecase;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SellerItemRequest {
	// 検索対象の商品名
	public String name;
	// 表示順序
	public String order;
	// 検索対象の商品ステータス
	public String status;
}
