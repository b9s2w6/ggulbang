<!-- 
[추가 기능 개선]
일괄 삭제 기능 -->

<script setup>
import PageNavigation from "../../components/navigation/PageNavigation.vue";
import SearchBar from "../../components/SearchBar.vue";
import { RouterLink, useRouter } from "vue-router";
import { ref, computed } from "vue";

// 1. store 객체 얻어오기
import { useBasketStore } from "../../stores/basket";
const basketStore = useBasketStore();

// 2. 반응형 데이터 연결하기
const baskets = computed(() => basketStore.baskets);
const totalPageCount = computed(() => basketStore.totalPageCount);

const router = useRouter();

const params = ref({
  key: "", //조건 검색 시 컬럼명
  word: "", //해당 컬럼에 일치하는 데이터
  pgno: 1, //조회할 페이지 번호
  spp: 30, //한번에 얻어올 게시글 개수
});

// 테스트코드, 추후에 변경 필
const userId = "temp01";

// 목록 조회
basketStore.getMyBasket(userId, params.value);

const moveDetail = (userId, aptCode) => {
  router.push({ name: "basket-detail", params: { userId, aptCode } });
};

const changePage = (pageNum) => {
  params.value.pgno = pageNum;

  // 목록 조회 필요
  basketStore.getMyBasket(userId, params.value);
};

// 검색 파트, 추후에 기능 추가
// const getSearchArticles = (searchKeyword) => {
//   // console.log("BoardList의 조건 검색 메소드 호출:", searchKeyword);

//   params.value.key = searchKeyword.key;
//   params.value.word = searchKeyword.word;
//   params.value.pgno = 1;

//   // 목록 조회 필요
//   basketStore.getMyBasket(params.value);
// };
</script>

<template>
  <div>
    <h1>장바구니 목록</h1>

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
        <th>장바구니 번호</th>
        <th>아파트 코드</th>
      </tr>
      <tr
        class="basket-item"
        v-for="basket in baskets"
        :key="basket.aptCode"
        @click="moveDetail(basket.userId, basket.aptCode)"
      >
        <td>{{ basket.userId }}</td>
        <td>{{ basket.aptCode }}</td>
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
