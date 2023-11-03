package com.ssafy.house.basket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.basket.repository.Basket;

import lombok.RequiredArgsConstructor;

// 231101 | 성욱 | basic -> basicName 으로 변경 

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {
	@GetMapping
	public List<Basket> selectBasketAll() {
		System.out.println("selectBasketAll");
		return null;
	}

	@GetMapping("{/userId}")
	public Basket selectBasketDetail(@PathVariable("userId") String userId) {
		System.out.println("selectBasketDetail");
		return null;
	}

	@PostMapping
	public int registBasket(Basket basket) {
		System.out.println("registBasket");
		return 0;
	}

	@PutMapping
	public int updateBasket(Basket basket) {
		System.out.println("updateBasket");
		return 0;
	}

	@DeleteMapping
	public int deleteBasket(String userId, long aptNo) {
		System.out.println(userId + ", " + aptNo);
		return 0;
	}
	 
}
