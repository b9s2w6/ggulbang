package com.ssafy.house.webSocket.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.ssafy.house.webSocket.repository.Chat;

@Controller
public class SocketController {

    // /receive를 메시지를 받을 endpoint로 설정합니다.
    @MessageMapping("/receive")

    // /send로 메시지를 반환합니다.
    @SendTo("/send")

    // SocketHandler는 1) /receive에서 메시지를 받고, /send로 메시지를 보내줍니다.
    // 정의한 SocketVO를 1) 인자값, 2) 반환값으로 사용합니다.
    public Chat SocketHandler(Chat chat) {
        String userName = chat.getUserName();
        String content = chat.getContent();

        System.out.println(userName + ", " + content);
        
        Chat result = new Chat(userName, content);
        
        return result;
    }
}
