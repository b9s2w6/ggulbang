<script setup>
import { onMounted, ref } from "vue";

//지도
const container = ref(null); //<div id="map"> 엘리먼트 객체
const map = ref(null); //kakaoMap 객체

const message = ref("");

//최초에 javascript 파일 가져올 때만 실행될 메소드
const loadScript = () => {
  const script = document.createElement("script");
  script.src = `//dapi.kakao.com/v2/maps/sdk.js?appkey=${import.meta.env.VITE_KAKAO_MAP_API_KEY}&autoload=false`;
  script.onload = () => kakao.maps.load(loadMap);
  document.head.appendChild(script);
};

//지도 불러오는 메소드
const loadMap = () => {
  //1.지도 출력
  const options = {
    center: new kakao.maps.LatLng(33.450701, 126.570667),
    level: 3,
  };
  map.value = new kakao.maps.Map(container.value, options);

  //2. 마커 찍기
  const marker = new kakao.maps.Marker({
    position: map.value.getCenter(),
  });
  marker.setMap(map.value);

  //3. 지도 click 이벤트 핸들링
  kakao.maps.event.addListener(map.value, "click", (mouseEvent) => {
    // 클릭한 위도, 경도 정보를 가져옵니다
    const latlng = mouseEvent.latLng;
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);

    message.value = `<h3>클릭한 위치의 위도는 ${latlng.getLat()}이고, 경도는 ${latlng.getLng()} 입니다</h3>`;
  });
};

onMounted(() => {
  if (window.kakao && window.kakao.maps) loadMap();
  else loadScript();
});
</script>

<template>
  <div>
    <div ref="container" id="map" style="width: 500px; height: 400px"></div>
    <p><em>지도를 클릭해주세요!</em></p>
    <div v-html="message"></div>
  </div>
</template>

<style scoped></style>
