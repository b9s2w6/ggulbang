package com.ssafy.house.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.member.repository.Member;

@Mapper
public interface MemberMapper {
	public Member login(Member member);
	public void registMember(Member member);
	public int checkUser(Member member);
	public int resetPassword(Member member);
}
