package com.ssafy.house.member.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.member.model.service.MemberService;
import com.ssafy.house.member.repository.Member;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class memberController {

	final MemberService memberService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Member member){
		System.out.println(member);
		//		Member memberInfo = d
		Map<String, String> loginInfo= memberService.login(member);

		if(loginInfo==null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 

		return ResponseEntity.ok(loginInfo);
	}

	@PostMapping("/regist")
	public void regist(@RequestBody Member member){
		System.out.println("회원가입" + member);
		//		Member memberInfo = 
		memberService.registMember(member);
	}
}
