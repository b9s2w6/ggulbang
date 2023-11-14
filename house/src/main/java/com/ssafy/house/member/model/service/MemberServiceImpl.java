package com.ssafy.house.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.house.house.model.mapper.HouseMapper;
import com.ssafy.house.member.model.mapper.MemberMapper;
import com.ssafy.house.member.repository.Member;
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
	
}
