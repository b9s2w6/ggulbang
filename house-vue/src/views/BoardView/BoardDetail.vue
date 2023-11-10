<script setup>
import { ref, computed } from "vue";
import { useRoute, useRouter, RouterLink } from "vue-router";
import axios from "axios";

// 1. store 객체 얻기
import { useBoardStore } from "../../stores/board";
const boardStore = useBoardStore();

// 2. 반응형 데이터 처리
const article = computed(() => boardStore.article);

const router = useRouter();
//articeNo를 얻어와야 함
const route = useRoute();
console.log("현재 라우트 정보:", route);

const getArticle = async () => {
  const url = `http://localhost/vue/board/${route.params.articleNo}`;
  const response = await axios.get(url);
  article.value = response.data;
};

// 3. 메서드 사용
boardStore.getArticle(route.params.articleNo);

const deleteArticle = async () => {
  if (!confirm("정말 삭제하시겠습니까?")) return;

  const url = `http://localhost/vue/board/${article.value.articleNo}`;
  const response = await boardStore.deleteArticle(article.value.articleNo);
  console.log("삭제 응답:", response);

  router.push("/board");
};
</script>

<template>
  <div>
    <h1>게시판 상세</h1>
    <!-- 목록 화면 이동 -->
    <RouterLink to="/board">목록</RouterLink>
    <table>
      <tr>
        <th>글 번호</th>
        <td>{{ article.articleNo }}</td>
      </tr>
      <tr>
        <th>글 제목</th>
        <td>{{ article.subject }}</td>
      </tr>
      <tr>
        <th>조회수</th>
        <td>{{ article.hit }}</td>
      </tr>
      <tr>
        <th>작성일</th>
        <td>{{ article.registerTime }}</td>
      </tr>
      <tr>
        <th>작성자</th>
        <td>{{ article.userId }}</td>
      </tr>
      <tr>
        <td>{{ article.content }}</td>
      </tr>
    </table>
    <!-- 수정 화면 이동 -->
    <RouterLink
      :to="{ name: 'article-modify', params: { articleNo: article.articleNo } }"
      >수정</RouterLink
    >
    <!-- 삭제 button -->
    <button @click="deleteArticle">삭제</button>
  </div>
</template>

<style scoped></style>
