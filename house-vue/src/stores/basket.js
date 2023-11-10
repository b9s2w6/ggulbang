import { defineStore } from "pinia";
import { ref } from "vue";
import axios from "axios";

export const useBasketStore = defineStore("basket", () => {
  // 장바구니 목록
  const baskets = ref([]); //목록 데이터
  const totalPageCount = ref(0); //전체 페이지 개수

  const getMyBasket = async (userId, params) => {
    const { data } = await axios.get(`/api/basket/${userId}`, {
      params: params,
    });

    console.log("getMyBasket(params) 응답데이터:", data);
    baskets.value = data.baskets;
    totalPageCount.value = data.totalPageCount;
  };

  // 장바구니 상세
  const basketInfo = ref({});
  const getBasketInfo = async (userId, aptCode) => {
    const { data } = await axios.get(`/api/basket/${userId}/${aptCode}`);
    console.log(`getBasketInfo(${userId}/${aptCode}) 요청 응답: `, data);
    basketInfo.value = data;
  };

  // 장바구니 등록
  const addBasket = async (addBasketForm) => {
    console.log("addBasket() 요청 데이터:", addBasketForm);
    return await axios.post(`/api/basket`, addBasketForm);
  };

  //   // 게시글 수정
  //   const modifyArticle = async (modifyForm) => {
  //     console.log("modifyArticle() 요청 데이터:", modifyForm);
  //     return await axios.put(`/api/board`, modifyForm);
  //   };

  // 장바구니 삭제
  const deleteBasket = async (userId, aptCode) => {
    console.log(`deleteBasket(${userId}/${aptCode}) 요청 보냄`);

    return await axios.delete(`/api/basket/${userId}/${aptCode}`);
  };

  return {
    baskets,
    totalPageCount,
    getMyBasket,
    basketInfo,
    getBasketInfo,
    addBasket,
    deleteBasket,
  };
});
