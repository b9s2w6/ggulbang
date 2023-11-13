<script setup>
import { RouterView, RouterLink } from "vue-router";
</script>

<template>
  <header>
    <ul>
      <li>
        <RouterLink to="/">홈</RouterLink>
      </li>
      <li>
        <RouterLink to="/board">게시판</RouterLink>
      </li>
      <li>
        <RouterLink to="/house">매물 리스트</RouterLink>
      </li>
      <li>
        <RouterLink to="/basket">장바구니</RouterLink>
      </li>
      <li>
        <RouterLink to="/login">로그인</RouterLink>
      </li>
      <li>
        <RouterLink to="/chat">채팅</RouterLink>
      </li>
    </ul>
  </header>
  <main>
    <RouterView></RouterView>
  </main>
</template>

<style scoped></style>
