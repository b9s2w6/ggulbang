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
	public List<House> selectHouseAll() {
		return houseService.selectHouseAll();
	}

	@GetMapping("/{aptCode}")
	public House selectHouseDetail(@PathVariable("aptCode") long aptCode) {
		System.out.println("전달받은 파라미터 aptCode: "+aptCode);
		return houseService.selectHouseDetail(aptCode);
	}

	@PostMapping
	public int registHouse(House house) {
		return houseService.registHouse(house);
	}

	@PutMapping
	public int updateHouse(House house) {
		System.out.println("updateHouse");
		return 0;
	}

	@DeleteMapping("/{aptCode}")
	public int deleteHouse(@PathVariable("aptCode") long aptCode) {
		return houseService.deleteHouse(aptCode);
	}
	 
}
