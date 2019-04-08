package com.web.usecase;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.web.domain.model.SellItem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchSellItemTest {
	@Autowired
	InputBoudary inputBoudary;
	@Autowired
	ISellerItemRepository repository;

	@Test
	public void list() {
		SellerItemRequest req = new SellerItemRequest("Nintendo Switch", "", "");
		assertNotNull(inputBoudary);
		assertNotNull(repository);
		SellerItemResponse resp = inputBoudary.run(repository, req);
		SellItem sellItem = resp.sellItems.list().stream().filter(si -> si.productName.equals("Nintendo Switch"))
				.findFirst().get();
		assertNotNull(sellItem);
	}

}
