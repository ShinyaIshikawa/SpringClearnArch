package com.web.usecase;

import com.web.domain.model.SellItems;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SellerItemResponse {
	// メッセージ
	public String message;
	// 商品レコード
	public SellItems sellItems;
}
