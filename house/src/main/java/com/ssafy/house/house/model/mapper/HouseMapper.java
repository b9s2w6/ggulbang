package com.ssafy.house.house.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.house.repository.House;

@Mapper
public interface HouseMapper {
	List<House> selectHouseAll();
	House selectHouseDetail(long aptNo);
	int registHouse(House House);
	int updateHouse(House House);
	int deleteHouse(long aptNo);
}
