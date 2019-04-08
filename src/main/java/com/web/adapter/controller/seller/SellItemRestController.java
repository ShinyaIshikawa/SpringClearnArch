package com.web.adapter.controller.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.usecase.ISellerItemRepository;
import com.web.usecase.InputBoudary;
import com.web.usecase.SellerItemRequest;
import com.web.usecase.SellerItemResponse;

@RestController
@RequestMapping("api/v1/sellerItem")
public class SellItemRestController {
	@Autowired
	InputBoudary inputBoudary;
	@Autowired
	ISellerItemRepository repository;

	@GetMapping
	SellerItemResponse getSellerItem(@RequestParam("name") String name,
			@RequestParam(name = "order", required = false) String order,
			@RequestParam(name = "status", required = false) String status) {
		SellerItemRequest req = new SellerItemRequest(name, order, status);
		return inputBoudary.run(repository, req);
	}

}
