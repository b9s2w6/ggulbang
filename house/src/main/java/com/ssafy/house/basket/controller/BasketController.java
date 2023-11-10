package com.ssafy.house.basket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.basket.model.service.BasketService;
import com.ssafy.house.basket.repository.Basket;

import lombok.RequiredArgsConstructor;

// 231101 | 성욱 | basic -> basicName 으로 변경 

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {
	final BasketService basketService;
	
	@GetMapping("/{userId}")
	public List<Basket> selectBasketAll(@PathVariable("userId") String userId) {
		System.out.println("selectBasketAll");
		return basketService.selectBasketAll(userId);
	}

	@GetMapping("/{userId}/{aptCode}")
	public Basket selectBasketDetail(@PathVariable("userId") String userId, @PathVariable("aptCode") long aptCode) {
		System.out.println("selectBasketDetail" + userId + ", " + aptCode);
		return basketService.selectBasketDetail(userId, aptCode);
	}

	// Post 요청 보낼 때,  
	@PostMapping
	public int registBasket(@RequestBody Basket basket) {
		System.out.println("registBasket : " + basket);
		return basketService.registBasket(basket);
	}

//	@PutMapping
//	public int updateBasket(Basket basket) {
//		System.out.println("updateBasket");
//		return ;
//	}

	// Delete는 요청 보낼 때 body로 못 보냄 params로 보낼 것 (ex. postman) 
	@DeleteMapping("/{userId}/{aptCode}")
	public int deleteBasket(@PathVariable("userId") String userId, @PathVariable("aptCode") long aptCode) {
		System.out.println(userId + ", " + aptCode);
		return basketService.deleteBasket(userId, aptCode);
	}
	 
}
