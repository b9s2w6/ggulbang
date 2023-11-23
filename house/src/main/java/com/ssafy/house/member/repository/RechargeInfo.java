package com.ssafy.house.member.repository;

import lombok.Data;

@Data
public class RechargeInfo {
	int rechargeId;
	String userId;
	long amount;
	String step;
}
