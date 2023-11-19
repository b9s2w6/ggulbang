package com.ssafy.house.house.contoller;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.basket.model.service.BasketService;
import com.ssafy.house.house.model.service.HouseService;
import com.ssafy.house.house.repository.House;
import com.ssafy.house.house.repository.HouseList;

import lombok.RequiredArgsConstructor;

// 231101 | 성욱 | basic -> basicName 으로 변경 

@RestController
@RequestMapping("/house")
@RequiredArgsConstructor
public class HouseController {
	
	final HouseService houseService;
	final BasketService basketService;
	
	@GetMapping
	public ResponseEntity<?> selectHouseAll(@RequestParam Map<String, String> map) {
		try {
			System.out.println("[HouseController][selectHouseAll] : " + map);
			HouseList houseList = houseService.selectHouseAll(map);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			return ResponseEntity.ok().headers(header).body(houseList);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/user/{userId}")
	public List<House> selectMyHouseAll(@PathVariable("userId") String userId) {
		System.out.println("[HouseController][selectMyHouseAll] : " + userId);
		System.out.println(houseService.selectMyHouseAll(userId));
		return houseService.selectMyHouseAll(userId);
	}
	
	@GetMapping("/detail/{aptCode}")
	public House selectHouseDetail(@PathVariable("aptCode") long aptCode) {
		System.out.println("[HouseController][selectHouseDetail] 로그");
		System.out.println("전달받은 파라미터 aptCode: "+aptCode);
		System.out.println(houseService.selectHouseDetail(aptCode));
		return houseService.selectHouseDetail(aptCode);
	}

	@PostMapping
	public int registHouse(House house) {
		return houseService.registHouse(house);
	}

	// 집 소유주 변경 (product 테이블)
	@PutMapping
	public int updateHouse(@RequestBody Map<String, Object> params) {
		System.out.println("[HouseController][updateHouse] : " + params);
		
		int result = houseService.updateHouse(params);
		
		System.out.println("[HouseController][updateHouse] 결과 : " + result);
		
		// 제대로 소유주 변경시, 장바구니에서 삭제처리
		if (result != 0) {
			String userId = (String) params.get("userId");
			long aptCode = (long) params.get("aptCode");
			
			System.out.println("소유주 변경할거니까 장바구니에서 지움! : " + userId + ", " + aptCode );
			int tempResult = basketService.deleteBasket(userId, aptCode);
			System.out.println("그 결과는요? : " + tempResult);
			
			return tempResult;
		}
		
		return result;
	}

	@DeleteMapping("/{aptCode}")
	public int deleteHouse(@PathVariable("aptCode") long aptCode) {
		return houseService.deleteHouse(aptCode);
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	 
}
