<script setup>
import { ref } from "vue";

import Stomp from "webstomp-client";
import SockJS from "sockjs-client";

const userName = ref("");
const message = ref("");
const recvList = ref([]);

const connect = () => {
  const serverURL = "http://localhost/api";
  let socket = new SockJS(serverURL);
  console.log(socket);
  stompClient = Stomp.over(socket);
  console.log("드릅게 안되네" + stompClient);
  console.log(`소켓 연결을 시도합니다. 서버 주소: ${serverURL}`);

  stompClient.connect(
    {},
    (frame) => {
      // 소켓 연결 성공
      connected = true;
      console.log("소켓 연결 성공", frame);
      // 서버의 메시지 전송 endpoint를 구독합니다.
      // 이런형태를 pub sub 구조라고 합니다.
      stompClient.subscribe("/send", (res) => {
        console.log("구독으로 받은 메시지 입니다.", res.body);

        // 받은 데이터를 json으로 파싱하고 리스트에 넣어줍니다.
        recvList.push(JSON.parse(res.body));
      });
    },
    (error) => {
      // 소켓 연결 실패
      console.log("소켓 연결 실패", error);
      connected = false;
    }
  );
};

connect();

const sendMessage = (event) => {
  if (event.keyCode === 13 && userName.value !== "" && message.value !== "") {
    send();
    message.value = "";
  }
};

const send = () => {
  console.log("Send message:" + message.value);
  if (stompClient && stompClient.connected) {
    const msg = {
      userName: userName.value,
      content: message.value,
    };
    stompClient.send("/receive", JSON.stringify(msg), {});
  }
};
</script>

<template>
  <div id="app">
    유저이름:
    <input v-model="userName" type="text" />
    내용: <input v-model="message" type="text" @keyup="sendMessage" />
    <div v-for="(item, idx) in recvList" :key="idx">
      <div>[{{ item.userName }}] : {{ item.content }}</div>
    </div>
  </div>
</template>

<style scoped></style>
