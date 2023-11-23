package com.ssafy.house.house.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.house.repository.House;

@Mapper
public interface HouseMapper {
	List<House> selectHouseAdmin(Map<String, Object> param);
	List<House> selectHouseUser(Map<String, Object> param);
	List<House> selectMyHouseAll(String userId);
	House selectHouseDetail(long aptCode);
	long registHouse(House House);
	int updateHouse(Map<String, Object> params);
	int deleteHouse(long aptCode);
	int getTotalHouseCount(Map<String, Object> param);
	int getUserHouseCount(Map<String, Object> param);
	List<String> getSidoList();
	List<String> getGugunList(String sidoName);
	List<String> getDongList(Map<String, String> map);
	String getDongCode(Map<String, Object> map);
	int registProduct(Map<String, Object> map);
	void calcMoney(Map<String, Object> params);
}
