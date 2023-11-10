<script setup>
import { ref, computed } from "vue";
import { useRoute, useRouter, RouterLink } from "vue-router";
import axios from "axios";

// 1. store 객체 얻기
import { useBasketStore } from "../../stores/basket";
const basketStore = useBasketStore();

// 2. 반응형 데이터 처리
const basket = computed(() => basketStore.basketInfo);
const router = useRouter();
const route = useRoute();

console.log("현재 라우트 정보:", route);

// const getBasketInfo = async () => {
//   const url = `http://localhost/vue/basket/${basket.value.userId}/${basket.value.aptCode}`;
//   const response = await axios.get(url);
//   basket.value = response.data;
//   console.log("getBasketInfo : ", basket.value);
// };

// 3. 메서드 사용
basketStore.getBasketInfo(route.params.userId, route.params.aptCode);

const deleteBasket = async () => {
  if (!confirm("정말 삭제하시겠습니까?")) return;
  basketStore.deleteBasket(basket.value.userId, basket.value.aptCode);
  console.log("what!!!! : " + basket.value.userId + " " + basket.value.aptCode);
  router.push("/basket");
};
</script>

<template>
  <div>
    <h1>장바구니 상세</h1>
    <!-- 목록 화면 이동 -->
    <RouterLink to="/basket">장바구니로 돌아가기</RouterLink>
    <table>
      <tr>
        <th>temp1</th>
        <td>{{ basket.userId }}</td>
      </tr>
      <tr>
        <th>temp2</th>
        <td>{{ basket.aptCode }}</td>
      </tr>
    </table>
    <!-- 수정 화면 이동 -->
    <!-- <RouterLink :to="{ name: 'article-modify', params: {} }">수정</RouterLink> -->
    <!-- 삭제 button -->
    <button @click="deleteBasket">삭제</button>
  </div>
</template>

<style scoped></style>
