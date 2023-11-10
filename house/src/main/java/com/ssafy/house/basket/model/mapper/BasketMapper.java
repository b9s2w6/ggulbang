package com.ssafy.house.basket.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.basket.repository.Basket;

@Mapper
public interface BasketMapper {
	List<Basket> selectBasketAll(String userId);
	Basket selectBasketDetail(String userId, long aptCode);
	int registBasket(Basket basket);
	int deleteBasket(String userId, long aptCode);
}
