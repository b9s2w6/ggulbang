package com.ssafy.house.member.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.house.house.model.mapper.HouseMapper;
import com.ssafy.house.member.model.mapper.MemberMapper;
import com.ssafy.house.member.repository.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	final MemberMapper memberMapper;
	
	@Override
	public Member login(Member member) {
		return memberMapper.login(member);
	}
	
}
