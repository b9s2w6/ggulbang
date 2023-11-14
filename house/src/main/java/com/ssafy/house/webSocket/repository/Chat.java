package com.ssafy.house.webSocket.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chat {
	private String userName;
	private String content;
}
