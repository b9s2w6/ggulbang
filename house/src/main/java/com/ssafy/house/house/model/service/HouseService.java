package com.ssafy.house.house.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.house.house.repository.House;
import com.ssafy.house.house.repository.HouseList;


public interface HouseService {
	HouseList selectHouseAll(Map<String, String> map);
	List<House> selectMyHouseAll(String userId);
	House selectHouseDetail(long aptCode);
	int registHouse(House House);
	int updateHouse(Map<String, Object> params);
	int deleteHouse(long aptCode);
}
