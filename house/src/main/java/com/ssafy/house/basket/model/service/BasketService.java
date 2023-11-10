package com.ssafy.house.basket.model.service;

import java.util.List;

import com.ssafy.house.basket.repository.Basket;

public interface BasketService {
	List<Basket> selectBasketAll(String userId);
	Basket selectBasketDetail(String userId, long aptCode);
	int registBasket(Basket basket);
//	int updateBasket(Basket basket);
	int deleteBasket(String userId, long aptCode);
}
