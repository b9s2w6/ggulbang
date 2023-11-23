package com.ssafy.house.member.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.member.repository.Member;
import com.ssafy.house.member.repository.RechargeInfo;

@Mapper
public interface MemberMapper {
	public Member login(Member member);
	public void registMember(Member member);
	public void registRecharge(Map<String, Object> map);
	public List<RechargeInfo> getRechargeList();
	public void updateMemberAmount();
	public void updateMemberAmount(Map<String, Object> recharge);
	public void updateRechargeInfo(Map<String, Object> recharge);
	public int checkUser(Member member);
	public int resetPassword(Member member);
	public int updatePassword(Member member);
}
