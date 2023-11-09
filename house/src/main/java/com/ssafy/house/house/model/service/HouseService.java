package com.ssafy.house.house.model.service;

import java.util.List;

import com.ssafy.house.house.repository.House;

public interface HouseService {
	List<House> selectHouseAll();
	House selectHouseDetail(long aptNo);
	int registHouse(House House);
	int updateHouse(House House);
	int deleteHouse(long aptNo);
}
