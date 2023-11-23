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
import com.ssafy.house.util.Encryption;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class memberController {

	final MemberService memberService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Member member){
		System.out.println("[memberController][login] " + member);
		//		Member memberInfo = d
		Map<String, String> loginInfo= memberService.login(member);
		
		if(loginInfo==null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
		System.out.println(loginInfo);
		return ResponseEntity.ok(loginInfo);
	}

	@PostMapping("/regist")
	public void regist(@RequestBody Member member){
		System.out.println("회원가입" + member);
		//		Member memberInfo = 
		memberService.registMember(member);
	}
	
	@PostMapping("/resetPassword")
	public int resetPassword(@RequestBody Member member) {
		System.out.println("[memberController][resetPassword] : " + member);
		
		int isExist = memberService.checkUser(member);
		
		// 유저 정보 확인했는데 아니면 -1 리턴
		if (isExist!= 1) {
			System.out.println("문제 생겼심다 : " + isExist);
			return -1; 
		}
		
		// 맞으면 초기화 후 비번 리셋 진행
		member.setUserPass(Encryption.hashPW(member.getUserId() + "2023!"));
		int result = memberService.resetPassword(member);
		System.out.println("비밀번호 리셋 완료) id + " + member.getUserId() + ", " + result);
		
		return result;
	}
}
