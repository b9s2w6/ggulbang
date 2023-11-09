package com.ssafy.house.house.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.house.model.service.HouseService;
import com.ssafy.house.house.repository.House;

import lombok.RequiredArgsConstructor;

// 231101 | 성욱 | basic -> basicName 으로 변경 

@RestController
@RequestMapping("/house")
@RequiredArgsConstructor
public class HouseController {
	
	final HouseService houseService;
	
	@GetMapping
	@ResponseBody
	public List<House> selectHouseAll() {
		return houseService.selectHouseAll();
	}

	@GetMapping("{/userId}")
	public House selectHouseDetail(@PathVariable("userId") String userId) {
		System.out.println("selectHouseDetail");
		return null;
	}

	@PostMapping
	public int registHouse(House house) {
		System.out.println("registHouse");
		return 0;
	}

	@PutMapping
	public int updateHouse(House house) {
		System.out.println("updateHouse");
		return 0;
	}

	@DeleteMapping
	public int deleteHouse(String userId, long aptNo) {
		System.out.println(userId + ", " + aptNo);
		return 0;
	}
	 
}
