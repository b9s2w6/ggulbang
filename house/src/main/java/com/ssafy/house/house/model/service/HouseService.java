package com.ssafy.house.house.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ssafy.house.house.repository.House;
import com.ssafy.house.house.repository.HouseList;


public interface HouseService {
	HouseList selectHouseAll(Map<String, String> map);
	List<House> selectMyHouseAll(String userId);
	House selectHouseDetail(long aptCode);
	int registHouse(Map<String, Object> map);
	int updateHouse(Map<String, Object> params);
	int deleteHouse(long aptCode);
	List<String> getSidoList();
	List<String> getGugunList(String sidoName);
	List<String> getDongList(Map<String, String> map);
}
