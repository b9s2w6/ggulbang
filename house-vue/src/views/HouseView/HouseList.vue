<script setup>
import PageNavigation from "../../components/navigation/PageNavigation.vue";
import SearchBar from "../../components/SearchBar.vue";
import { RouterLink, useRouter } from "vue-router";
import { ref, computed } from "vue";
import KakaoMap from "../../components/common/KakaoMap.vue";
// import VKakaoMap from "@/components/common/VKakaoMap.vue";
import { useHouseStore } from "../../stores/house";

const houseStore = useHouseStore();
const houseList = computed(() => houseStore.houseList);
const totalPageCount = computed(() => houseStore.totalPageCount);
const router = useRouter();
const params = ref({
  key: "", //조건 검색 시 컬럼명
  word: "", //해당 컬럼에 일치하는 데이터
  pgno: 1, //조회할 페이지 번호
  spp: 30, //한번에 얻어올 게시글 개수
});

houseStore.getHouseList();

const moveDetail = (aptCode) => {
  router.push({ name: "house-detail", params: { aptCode } });
};

const changePage = (pageNum) => {
  params.value.pgno = pageNum;

  houseStore.getHouseList();
};

// 검색 파트, 추후에 기능 추가
// const getSearchArticles = (searchKeyword) => {
//   // console.log("BoardList의 조건 검색 메소드 호출:", searchKeyword);

//   params.value.key = searchKeyword.key;
//   params.value.word = searchKeyword.word;
//   params.value.pgno = 1;

//   // 목록 조회 필요
//   houseStore.getMyBasket(params.value);
// };
</script>
<script>
export default {
  name: "App",
  components: {
    KakaoMap,
  },
};
</script>

<template>
  <div>
    <KakaoMap />
    <!-- <VKakaoMap :houses="houseList" /> -->
    <h1>매물 목록</h1>

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
        <th>건축 연도</th>
        <th>도로명</th>
        <th>도로명 본번</th>
        <th>도로명 부번</th>
        <th>도로명 일련번호</th>
        <th>도로명 지하 부호</th>
        <th>도로명 코드</th>
        <th>동</th>
        <th>본번</th>
        <th>부번</th>
        <th>시군구 코드</th>
        <th>읍면동 코드</th>
        <th>동 코드</th>
        <th>토지 코드</th>
        <th>아파트명</th>
        <th>지번</th>
        <th>경도 (Longitude)</th>
        <th>위도 (Latitude)</th>
      </tr>
      <tr
        class="basket-item"
        v-for="house in houseList"
        :key="house.aptCode"
        @click="moveDetail(house.aptCode)"
      >
        <td>{{ house.aptCode }}</td>
        <td>{{ house.buildYear }}</td>
        <td>{{ house.roadName }}</td>
        <td>{{ house.roadNameBonbun }}</td>
        <td>{{ house.roadNameBubun }}</td>
        <td>{{ house.roadNameSeq }}</td>
        <td>{{ house.roadNameBasementCode }}</td>
        <td>{{ house.roadNameCode }}</td>
        <td>{{ house.dong }}</td>
        <td>{{ house.bonbun }}</td>
        <td>{{ house.bubun }}</td>
        <td>{{ house.sigunguCode }}</td>
        <td>{{ house.eubmyundongCode }}</td>
        <td>{{ house.dongCode }}</td>
        <td>{{ house.landCode }}</td>
        <td>{{ house.apartmentName }}</td>
        <td>{{ house.jibun }}</td>
        <td>{{ house.jibun }}</td>
        <td>{{ house.lng }}</td>
        <td>{{ house.lat }}</td>
      </tr>
    </table>
    <PageNavigation
      v-on:change-page="changePage"
      :current-page="params.pgno"
      :total-page-count="totalPageCount"
      :navigation-size="5"
    ></PageNavigation>
  </div>
</template>

<style scoped>
.basket-item:hover {
  background-color: rgb(237, 214, 255);
}
</style>
