package com.ssafy.house.basket.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.house.basket.model.mapper.BasketMapper;
import com.ssafy.house.basket.repository.Basket;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
	final BasketMapper basketMapper;
	
	@Override
	public List<Basket> selectBasketAll(String userId) {
		return basketMapper.selectBasketAll(userId);
	}

	@Override
	public Basket selectBasketDetail(String userId, long aptCode) {
		return basketMapper.selectBasketDetail(userId, aptCode);
	}

	@Override
	public int registBasket(Basket basket) {
		return basketMapper.registBasket(basket);
	}

	@Override
	public int deleteBasket(String userId, long aptNo) {
		return basketMapper.deleteBasket(userId, aptNo);
	}

}
