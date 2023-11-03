package com.ssafy.house.basket.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.house.basket.repository.Basket;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {@Override
	public List<Basket> selectBasketAll() {
		return null;
	}

	@Override
	public Basket selectBasketDetail(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registBasket(Basket basket) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBasket(Basket basket) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBasket(String userId, long aptNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
