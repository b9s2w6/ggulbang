package com.ssafy.house.util;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ssafy.house.member.repository.Member;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

	private static final String SECRET_KEY = "ssafy"; // 시크릿 키, 토큰 생성과 검증 시 필요

	// JWT 토큰 생성 메소드
	public static String generateToken(Member member) {
		long now = System.currentTimeMillis();
		long expirationSecond = 60*60*2;	//2시간
		
		Map<String, Object> header = new HashMap<>();
		header.put("alg", "HS256");
		header.put("typ", "JWT");
		
		Claims claims = Jwts.claims();
		claims.put("userId", member.getUserId());
		claims.put("userName", member.getUserName());

		return Jwts.builder()
				.setHeader(header)
				.setClaims(claims)	//정보 담기
				.setExpiration(new Date(now + 1000*expirationSecond)) // 토큰 만료 시간
//				.setExpiration(new Date(1699591090))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)		  // encoding 방식
				.compact();	//토큰 생성
	}

	// JWT 토큰 유효성 검증 메소드(SecretKey 필요)
	public static Jws<Claims> validateToken(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token);
	}

	// JWT 토큰 decode(SecretKey 필요X)
	public static String decodeToken(String token) {
		String[] splitToken = token.split("\\.");
		String body = splitToken[1];
		
		//디코딩
		Base64.Decoder decoder = Base64.getDecoder();
		String decodedBody = new String(decoder.decode(body));
		
		return decodedBody;
	}

}
