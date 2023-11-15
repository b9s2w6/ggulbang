<template>
  <div id="app">
    <h1>채팅 방입니다</h1>
    <button v-if="!connected" @click="connectWs">채팅 시작하기</button>
    <button v-if="!connected" @click="connect">채팅 시작하기</button>
    <input v-model="message" @keyup.enter="send" placeholder="메시지 입력" />
    <button @click="send">보내기</button>
    <div>
      <p v-for="(msg, index) in messages" :key="index">{{ msg }}</p>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const ws = ref(null);
const connected = ref(false);
const message = ref("");
const messages = ref([]);

var socket = null;

const connect = () => {
  console.log("하는중인데...");
  var ws = new WebSocket("ws://localhost/api");
  socket = ws;
  console.log(socket);
  ws.onopen = function () {
    console.log("Info : connection Opened.");
  };
  ws.onmessage = function (event) {
    console.log(event.data + "\n");
  };
  ws.onclose = function (event) {
    console.log("Info : connection closed.");
    //setTimeout(function(){ connect(); },1000); //retry connection
  };
  ws.onerror = function (event) {
    console.log("Error : " + error);
  };
};

const connectWs = () => {
  console.log("소켓 연결 시도!");

  ws.value = new WebSocket("ws://localhost/api");

  console.log(ws.value);

  ws.value.onopen = () => {
    console.log("소켓 연결 성공!");
    connected.value = true;
  };
  ws.value.onmessage = (event) => {
    console.log("Received:", event.data);
    messages.unshift(event.data);
  };

  ws.value.onclose = () => {
    console.log("소켓이 닫혔습니다.");
    connected.value = false;
  };

  ws.value.onerror = (error) => {
    console.error("소켓 연결 에러:", error);
    connected.value = false;
  };
};

const send = () => {
  console.log("클릭!!");
  if (connected.value && message.value.trim() !== "") {
    console.log("보내려는 메세지요? : ", message.value);
    ws.value.send(message.value);
    message.value = "";
  }
};

const beforeUnmount = () => {
  if (ws.value) {
    ws.value.close();
  }
};
</script>

<style>
/* 필요한 스타일을 추가할 수 있습니다 */
</style>
