package com.ssafy.house.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.member.model.service.MemberService;
import com.ssafy.house.member.repository.Member;
import com.ssafy.house.member.repository.RechargeInfo;
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
		System.out.println("로그인 정보요 : " + loginInfo);
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
		int result = memberService.updatePassword(member);
		System.out.println("비밀번호 리셋 완료) id + " + member.getUserId() + ", " + result);
		
		return result;
	}
	
	@PostMapping("/recharge")
	private void recharge(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		memberService.registRecharge(map);
	}
	
	@GetMapping("/getRechargeList")
	private List<RechargeInfo> getRechargeList(){
		return memberService.getRechargeList();
	}
	
	@PostMapping("/updatePassword")
	public int updatePassword(@RequestBody Member member) {
		System.out.println("[memberController][resetPassword] : " + member);
		
		// 로그인이 되는 정보가 아니면 업데이트 취소
		Map<String, String> loginInfo = memberService.login(member);
		if(loginInfo == null) return - 1; 
		
		member.setUserPass(Encryption.hashPW(member.getUserNewPass()));
		int result = memberService.updatePassword(member);
		
		return result;
	}
	
	@PostMapping("/acceptRecharge")
	private void acceptRecharge(@RequestBody List<Map<String, Object>> rechargeList) {
		System.out.println("충전 수량 접근");
		System.out.println(rechargeList);
		memberService.acceptRecharge(rechargeList);
	}
	
	
	@GetMapping("/refresh")
	private Member refresh(@RequestParam String userId) {
		System.out.println("새로고침"+userId);
		return memberService.refresh(userId);
	}

	@GetMapping("/getUserInfo")
	public Member getUserInfo(@RequestBody Member member){
		System.out.println("[memberController][getUserInfo] " + member);
		
		Member userInfo = memberService.getUserInfo(member);
		System.out.println("새로 가져온 유저 정보 : " + userInfo);
		return userInfo;
	}
}
