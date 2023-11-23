package com.ssafy.house.member.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.house.house.model.mapper.HouseMapper;
import com.ssafy.house.member.model.mapper.MemberMapper;
import com.ssafy.house.member.repository.Member;
import com.ssafy.house.member.repository.RechargeInfo;
import com.ssafy.house.util.Encryption;
import com.ssafy.house.util.JWTUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	final MemberMapper memberMapper;
	
	@Override
	public Map<String, String> login(Member member) {
		Map<String, String> token = new HashMap<>();
		Member memberInfo = memberMapper.login(member);
		System.out.println(memberInfo);
		if(Encryption.checkPW(member.getUserPass(), memberInfo.getUserPass())){
			token.put("token", JWTUtil.generateToken(memberInfo));
			return token;
		}
		return null;
	}
	
	@Override
	public void registMember(Member member) {
		member.setUserPass(Encryption.hashPW(member.getUserPass()));
		memberMapper.registMember(member);
	}

	@Override
	public int checkUser(Member member) {
		return memberMapper.checkUser(member);
	}
	
	public int updatePassword(Member member) {
		return memberMapper.updatePassword(member);
	}

	@Override
	public void registRecharge(Map<String, Object> map) {
		memberMapper.registRecharge(map);
	}

	@Override
	public List<RechargeInfo> getRechargeList() {
		return memberMapper.getRechargeList();
	}

	@Override
	public void acceptRecharge(List<Map<String, Object>> rechargeList) {
		for(Map<String, Object> recharge: rechargeList) {
			memberMapper.updateMemberAmount(recharge);
			memberMapper.updateRechargeInfo(recharge);
		}
	}

}
