package com.ssafy.house.basket.repository;


import lombok.Data;

@Data
public class Basket {
	private int basketNo;
	private String userId;
	private long aptCode;
	private long price;
	private String sidoName;
	private String gugunName;
	private String dongName;
	private String roadName;
	private String apartmentName;
}
