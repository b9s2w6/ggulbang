package com.ssafy.house.house.repository;

import java.util.List;

import lombok.Data;


@Data
public class HouseList {
	private List<House> houses;
	private int currentPage;
	private int totalPageCount;

}
