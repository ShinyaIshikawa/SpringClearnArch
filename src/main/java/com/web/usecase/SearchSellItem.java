package com.web.usecase;

import org.springframework.stereotype.Service;

import com.web.domain.model.SellItem;
import com.web.domain.model.SellItems;

@Service
public class SearchSellItem implements InputBoudary {
	@Override
	public SellerItemResponse run(ISellerItemRepository repository, SellerItemRequest request) {
		SellItem sellItem = new SellItem(request.name, request.order, request.status);
		if (!sellItem.validate()) {
			// エラーの場合は、エラーコードとエラーコンテンツをレスポンス
			return new SellerItemResponse(sellItem.getContent(), null);
		}
		// 商品一覧検索
		SellItems sellItems = repository.findByName(sellItem.productName, sellItem.order, sellItem.saleStatus);
		sellItem.setStatus(sellItems);
		// 商品一覧の検索結果をレスポンス
		return new SellerItemResponse(sellItem.getContent(), sellItems);
	}
}
