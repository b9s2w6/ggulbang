package com.ssafy.house.house.model.service;

import java.util.Map;

import com.ssafy.house.house.repository.House;
import com.ssafy.house.house.repository.HouseList;


public interface HouseService {
	HouseList selectHouseAll(Map<String, String> map);
	House selectHouseDetail(long aptCode);
	int registHouse(House House);
	int updateHouse(House House);
	int deleteHouse(long aptCode);
}
