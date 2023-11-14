package com.ssafy.house.member.controller;

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
	
	@PostMapping
	public Member login(@RequestBody Member member){
		System.out.println(member);
//		Member memberInfo = 
		return memberService.login(member);
	}
}
