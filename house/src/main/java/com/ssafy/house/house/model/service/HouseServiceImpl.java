package com.ssafy.house.house.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.house.house.model.mapper.HouseMapper;
import com.ssafy.house.house.repository.House;
import com.ssafy.house.house.repository.HouseList;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {	
	final HouseMapper houseMapper;
	
	@Override
	public House selectHouseDetail(long aptCode) {
		return houseMapper.selectHouseDetail(aptCode);
	}

	@Override
	public int registHouse(House House) {
		return houseMapper.registHouse(House);
	}

	@Override
	public int updateHouse(Map<String, Object> params) {
		return houseMapper.updateHouse(params);
	}

	@Override
	public int deleteHouse(long aptCode) {
		return houseMapper.deleteHouse(aptCode);
	}

	@Override
	public HouseList selectHouseAll(Map<String, String> map) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int sizePerPage = Integer.parseInt(map.get("spp") == null ? "20" : map.get("spp"));
		int start = currentPage * sizePerPage - sizePerPage;
		param.put("start", start);
		param.put("listsize", sizePerPage);

		String key = map.get("key");
		param.put("key", key == null ? "" : key);
		if ("user_id".equals(key))
			param.put("key", key == null ? "" : "b.user_id");
		List<House> list = houseMapper.selectHouseAll(param);

		if ("user_id".equals(key))
			param.put("key", key == null ? "" : "user_id");
		int totalArticleCount = houseMapper.getTotalHouseCount(param);
		int totalPageCount = (totalArticleCount - 1) / sizePerPage + 1;

		HouseList houseList = new HouseList();
		houseList.setHouses(list);
		houseList.setCurrentPage(currentPage);
		houseList.setTotalPageCount(totalPageCount);

		return houseList;
	}

	@Override
	public List<House> selectMyHouseAll(String userId) {
		return houseMapper.selectMyHouseAll(userId);
	}

}
