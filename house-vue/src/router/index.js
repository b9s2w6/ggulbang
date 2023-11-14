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
import ChatForm2 from "@/views/ChatForm2.vue";

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
        },
        //BoardWrite
        {
          name: "article-write",
          path: "write",
          component: BoardWrite,
        },
        //BoardModify
        {
          name: "article-modify",
          path: "modify/:articleNo",
          component: BoardModify,
        },
      ],
    },

    // BasketView
    {
      path: "/basket",
      component: BasketView,
      redirect: "/basket/list",
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
      path: "/login",
      name: "login",
      component: LoginForm,
    },
    // Chat
    {
      path: "/chat",
      name: "chat",
      component: ChatForm,
    },
    // Chat 2
    {
      path: "/chat2",
      name: "chat2",
      component: ChatForm2,
    },
  ],
});

export default router;
