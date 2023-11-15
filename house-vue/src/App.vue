<script setup>
import HeaderView from "@/components/HeaderView.vue";
</script>

<template>
  <HeaderView />
  <header>
    채팅 테스트 (소켓)
    <ul>
      <li>
        <RouterLink to="/chat">채팅</RouterLink>
      </li>
      <li>
        <RouterLink to="/chat2">채팅2</RouterLink>
      </li>
      <li>
        <RouterLink to="/chat3">채팅3</RouterLink>
      </li>
      <li>
        <RouterLink to="/chat4">채팅3</RouterLink>
      </li>
    </ul>
  </header>
  <main>
    <RouterView></RouterView>
  </main>
</template>
