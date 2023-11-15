import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";

// BoardView
import BoardView from "@/views/BoardView.vue";
import BoardList from "@/views/BoardView/BoardList.vue";
import BoardDetail from "@/views/BoardView/BoardDetail.vue";
import BoardWrite from "@/views/BoardView/BoardWrite.vue";
import BoardModify from "@/views/BoardView/BoardModify.vue";

// BasketView
import BasketView from "@/views/BasketView.vue";
import BasketList from "@/views/BasketView/BasketList.vue";
import BasketDetail from "@/views/BasketView/BasketDetail.vue";
// console.log("HomView import 정보 : ", HomeView);

// HouseView
import HouseView from "@/views/HouseView.vue";
import HouseList from "@/views/HouseView/HouseList.vue";
import HouseDetail from "@/views/HouseView/HouseDetail.vue";

// Login
import LoginForm from "@/views/LoginForm.vue";

// Chat
import ChatForm from "@/views/ChatForm.vue";
// import ChatForm2 from "@/views/ChatForm2.vue";

//loginCheck
import { useAuthStore } from "../stores/auth";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    //HomeView
    {
      path: "/",
      component: HomeView,
    },
    //BoardView
    {
      path: "/board",
      component: BoardView,
      redirect: "/board/list",
      children: [
        //BoardList
        {
          path: "list",
          component: BoardList,
        },
        //BoardDetail
        {
          name: "article-detail",
          path: "detail/:articleNo",
          component: BoardDetail,
          meta: { requiresAuth: true },
        },
        //BoardWrite
        {
          name: "article-write",
          path: "write",
          component: BoardWrite,
          meta: { requiresAuth: true },
        },
        //BoardModify
        {
          name: "article-modify",
          path: "modify/:articleNo",
          component: BoardModify,
          meta: { requiresAuth: true },
        },
      ],
    },

    // BasketView
    {
      path: "/basket",
      component: BasketView,
      redirect: "/basket/list",
      meta: { requiresAuth: true },
      children: [
        // BasketList
        {
          path: "list",
          component: BasketList,
        },
        // BasketDetail
        {
          name: "basket-detail",
          path: "detail/:userId/:aptCode",
          component: BasketDetail,
        },
        // //BoardWrite
        // {
        //   name: "article-write",
        //   path: "write",
        //   component: BoardWrite,
        // },
        // //BoardModify
        // {
        //   name: "article-modify",
        //   path: "modify/:articleNo",
        //   component: BoardModify,
        // },
      ],
    },

    // HouseView
    {
      path: "/house",
      component: HouseView,
      redirect: "/house/list",
      children: [
        // BasketList
        {
          path: "list",
          component: HouseList,
        },
        // BasketDetail
        {
          name: "house-detail",
          path: "detail/:aptCode",
          component: HouseDetail,
        },
        // //BoardWrite
        // {
        //   name: "article-write",
        //   path: "write",
        //   component: BoardWrite,
        // },
        // //BoardModify
        // {
        //   name: "article-modify",
        //   path: "modify/:articleNo",
        //   component: BoardModify,
        // },
      ],
    },
    // Login
    {
      name: "login",
      path: "/login",
      component: LoginForm,
    },
    // Chat
    {
      name: "chat",
      path: "/chat",
      component: ChatForm,
      meta: { requiresAuth: true },
    },
    // // Chat 2
    // {
    //   path: "/chat2",
    //   name: "chat2",
    //   component: ChatForm2,
    // },
  ],
});

router.beforeEach((to, from, next) => {
  const authStore = useAuthStore();
  //로그인 필요
  if (to.matched.some((record) => record.meta.requiresAuth)) {
    if (!authStore.token) {
      alert("로그인 권한 필요");
      next({ path: "/login" }); // 인증되지 않은 경우, 로그인 페이지로 리다이렉트
    } else {
      //관리자 권한 필요
      if (to.matched.some((record) => record.meta.requiresAdmin)) {
        // 관리자가 아닌 경우 홈으로
        if (authStore.user.role !== "admin") {
          alert("관리자 권한 필요");
          next({ path: "/" });
        } else next(); // 관리자인 경우, 해당 경로로 이동
      } else next(); // 인증된 경우 해당 경로로 이동
    }
  } else next(); // 인증이 필요하지 않은 경우 해당 경로로 이동
});

export default router;
