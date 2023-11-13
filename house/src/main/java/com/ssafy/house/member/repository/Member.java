package com.ssafy.house.member.repository;

import lombok.Data;

@Data
public class Member {
	String userid;
	String username;
	String userpass;
	String joinDate;
	String address;
	String tel;
	long rechatgeAmout;
	
}
