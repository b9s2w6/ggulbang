import { defineStore } from "pinia";
import { ref } from "vue";
import axios from "axios";

export const useHouseStore = defineStore("house", () => {
  // 매물 목록
  const houseList = ref({}); //목록 데이터
  const totalPageCount = ref(0); //전체 페이지 개수

  const getHouseList = async (params) => {
    const { data } = await axios.get(`/api/house`, {
      params: params,
    });

    console.log("getHouseList(params) 응답데이터:", data);
    houseList.value = data;
    totalPageCount.value = data.totalPageCount;
  };

  // 매물 상세
  const houseInfo = ref({});
  const getHouseInfo = async (aptCode) => {
    const { data } = await axios.get(`/api/house/${aptCode}`);
    console.log(`getHouseInfo(${aptCode}) 요청 응답: `, data);
    houseInfo.value = data;
  };

  // // 매물 등록
  // const addBasket = async (addBasketForm) => {
  //   console.log("addBasket() 요청 데이터:", addBasketForm);
  //   return await axios.post(`/api/basket`, addBasketForm);
  // };

  //   // 매물 수정
  //   const modifyArticle = async (modifyForm) => {
  //     console.log("modifyArticle() 요청 데이터:", modifyForm);
  //     return await axios.put(`/api/board`, modifyForm);
  //   };

  // // 매물 삭제
  // const deleteBasket = async (userId, aptCode) => {
  //   console.log(`deleteBasket(${userId}/${aptCode}) 요청 보냄`);
  //   return await axios.delete(`/api/basket/${userId}/${aptCode}`);
  // };

  return {
    houseList,
    getHouseList,
    houseInfo,
    getHouseInfo,
  };
});
