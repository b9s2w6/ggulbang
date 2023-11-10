package com.ssafy.house.house.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.house.house.repository.House;


public interface HouseService {
	List<House> selectHouseAll();
	House selectHouseDetail(long aptCode);
	int registHouse(House House);
	int updateHouse(House House);
	int deleteHouse(long aptCode);
}
