package com.ssafy.house.house.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.house.repository.House;

@Mapper
public interface HouseMapper {
	List<House> selectHouseAll(Map<String, Object> param);
	House selectHouseDetail(long aptCode);
	int registHouse(House House);
	int updateHouse(Map<String, Object> params);
	int deleteHouse(long aptCode);
	int getTotalHouseCount(Map<String, Object> param);
}
