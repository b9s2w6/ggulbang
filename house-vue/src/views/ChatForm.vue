<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useAuthStore } from "@/stores/auth";

const authStore = useAuthStore();
const router = useRouter();
const ws = ref(null);
const chatMessage = ref("");
const chatHistory = ref([]);

const connectWs = () => {
  ws.value = new WebSocket("ws://" + location.host);

  ws.value.onmessage = (event) => {
    const message = event.data;
    chatHistory.value.unshift(message);
  };

  // $("#startBtn").hide();
};

const send = () => {
  ws.value.send(chatMessage.value);
  chatMessage.value = "";
};
</script>

<template>
  <div>
    <h1>채팅 방 입니다</h1>
    <button @click="connectWs()" id="startBtn">채팅 시작하기</button>
    <input v-model="chatMessage" />
    <button @click="send">보내기</button>
    <p v-for="message in chatHistory" :key="message">{{ message }}</p>
  </div>
</template>

<style scoped></style>
