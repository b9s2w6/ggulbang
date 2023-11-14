package com.ssafy.house.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Encryption {
	private static String salt = "ssafy";

	static public String hashPW(String pwd) {
		// 암호화 한 후에
		return BCrypt.hashpw(pwd, BCrypt.gensalt());
	}
	
	static public boolean checkPW(String inputRawPassword,String hashedDbPassword) {
		// 암호화 한 후에
		return BCrypt.checkpw(inputRawPassword, hashedDbPassword);
	}
}
