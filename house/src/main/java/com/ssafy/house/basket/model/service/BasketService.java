package com.ssafy.house.basket.model.service;

import java.util.List;

import com.ssafy.house.basket.repository.Basket;

public interface BasketService {
	List<Basket> selectBasketAll();
	Basket selectBasketDetail(String userId);
	int registBasket(Basket basket);
	int updateBasket(Basket basket);
	int deleteBasket(String userId, long aptNo);
}
