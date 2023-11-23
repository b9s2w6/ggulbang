package com.ssafy.house.member.model.service;

import java.util.Map;

import com.ssafy.house.member.repository.Member;

public interface MemberService {
	Map<String, String> login(Member member);
	void registMember(Member member);
	int checkUser(Member member);
	int resetPassword(Member member);
}
