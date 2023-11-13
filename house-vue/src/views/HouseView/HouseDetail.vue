<script setup>
import { ref, computed } from "vue";
import { useRoute, useRouter, RouterLink } from "vue-router";
import axios from "axios";

// 1. store 객체 얻기
import { useHouseStore } from "../../stores/house";
const houseStore = useHouseStore();

// 2. 반응형 데이터 처리
const house = computed(() => houseStore.houseInfo);
const router = useRouter();
const route = useRoute();

console.log("현재 라우트 정보:", route);

// const getBasketInfo = async () => {
//   const url = `http://localhost/vue/basket/${basket.value.userId}/${basket.value.aptCode}`;
//   const response = await axios.get(url);
//   basket.value = response.data;
//   console.log("getBasketInfo : ", basket.value);
// };

houseStore.getHouseInfo(route.params.aptCode);

// 매물 정보 삭제
// const deletehouse = async () => {
//   if (!confirm("정말 삭제하시겠습니까?")) return;
//   basketStore.deleteBasket(basket.value.userId, basket.value.aptCode);
//   console.log("what!!!! : " + basket.value.userId + " " + basket.value.aptCode);
//   router.push("/basket");
// };
</script>

<template>
  <div>
    <h1>매물 상세</h1>

    <!-- <SearchBar
      @search-event="getSearchArticles"
      :options="[
        { value: 'userid', text: '작성자' },
        { value: 'article_no', text: '글번호' },
        { value: 'subject', text: '제목' },
      ]"
    ></SearchBar> -->

    <table>
      <tr>
        <th>아파트 코드</th>
        <td>{{ house.aptCode }}</td>
      </tr>
      <tr>
        <th>건축년도</th>
        <td>{{ house.buildYear }}</td>
      </tr>
      <tr>
        <th>도로명</th>
        <td>{{ house.roadName }}</td>
      </tr>
      <tr>
        <th>도로명 본번</th>
        <td>{{ house.roadNameBonbun }}</td>
      </tr>
      <tr>
        <th>도로명 부번</th>
        <td>{{ house.roadNameBubun }}</td>
      </tr>
      <tr>
        <th>도로명 일련번호</th>
        <td>{{ house.roadNameSeq }}</td>
      </tr>
      <tr>
        <th>도로명 지하 부호</th>
        <td>{{ house.roadNameBasementCode }}</td>
      </tr>
      <tr>
        <th>도로명 코드</th>
        <td>{{ house.roadNameCode }}</td>
      </tr>
      <tr>
        <th>동</th>
        <td>{{ house.dong }}</td>
      </tr>
      <tr>
        <th>본번</th>
        <td>{{ house.bonbun }}</td>
      </tr>
      <tr>
        <th>부번</th>
        <td>{{ house.bubun }}</td>
      </tr>
      <tr>
        <th>시군구 코드</th>
        <td>{{ house.sigunguCode }}</td>
      </tr>
      <tr>
        <th>읍면동 코드</th>
        <td>{{ house.eubmyundongCode }}</td>
      </tr>
      <tr>
        <th>동 코드</th>
        <td>{{ house.dongCode }}</td>
      </tr>
      <tr>
        <th>토지 코드</th>
        <td>{{ house.landCode }}</td>
      </tr>
      <tr>
        <th>아파트명</th>
        <td>{{ house.apartmentName }}</td>
      </tr>
      <tr>
        <th>지번</th>
        <td>{{ house.jibun }}</td>
      </tr>
      <tr>
        <th>경도 (Longitude)</th>
        <td>{{ house.lng }}</td>
      </tr>
      <tr>
        <th>위도 (Latitude)</th>
        <td>{{ house.lat }}</td>
      </tr>
    </table>

    <!-- 수정 화면 이동 -->
    <!-- <RouterLink :to="{ name: 'article-modify', params: {} }">수정</RouterLink> -->
    <!-- 삭제 button -->
    <!-- <button @click="deleteBasket">삭제</button> -->
  </div>
</template>

<style scoped>
.basket-item:hover {
  background-color: rgb(237, 214, 255);
}
</style>

<style scoped></style>
