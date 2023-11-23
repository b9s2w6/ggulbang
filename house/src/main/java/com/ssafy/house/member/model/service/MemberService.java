package com.ssafy.house.member.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.house.member.repository.Member;
import com.ssafy.house.member.repository.RechargeInfo;

public interface MemberService {
	Map<String, String> login(Member member);
	void registMember(Member member);
	int checkUser(Member member);
	int resetPassword(Member member);
	void registRecharge(Map<String, Object> map);
	List<RechargeInfo> getRechargeList();
	void acceptRecharge(List<Map<String, Object>> rechargeList);
}
