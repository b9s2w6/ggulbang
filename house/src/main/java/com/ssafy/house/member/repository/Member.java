package com.ssafy.house.member.repository;

import lombok.Data;

@Data
public class Member {
	String userId;
	String userName;
	String userPass;
	String joinDate;
	String address;
	String tel;
	String role;
	long balance;
	long rechargeAmount;
	long totalAssetPrice;
}
