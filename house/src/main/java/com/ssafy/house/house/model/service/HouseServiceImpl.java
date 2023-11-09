package com.ssafy.house.house.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.house.house.model.mapper.HouseMapper;
import com.ssafy.house.house.repository.House;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {	
	final HouseMapper houseMapper;

	public List<House> selectHouseAll() {
		return houseMapper.selectHouseAll();
	}

	@Override
	public House selectHouseDetail(long aptNo) {
		return null;
	}

	@Override
	public int registHouse(House House) {
		return 0;
	}

	@Override
	public int updateHouse(House House) {
		return 0;
	}

	@Override
	public int deleteHouse(long aptNo) {
		return 0;
	}

}
