package com.web.adapter.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.domain.model.SellItem;

@Mapper
public interface SellItemMapper {
	List<SellItem> selectByName(@Param("productName") String productName, @Param("order") String order,
			@Param("status") String status);
}