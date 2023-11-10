import { fileURLToPath, URL } from "node:url";

import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      "@": fileURLToPath(new URL("./src", import.meta.url)),
    },
  },
  server: {
    proxy: {
      "/api": {
        target: "http://localhost",

        // 직접 공공 데이터를 가져오는 경우, origin 변경을 위해 쓰면 됨
        // changeOrigin: true,
        // rewrite: (path) => path.replace(/^\/api/, ""), // /api를 ""으로 대체하는 셈
        // 걍 문자 그대로 앞 주소를 지우고 링크를 바꿔버린다~
        // 정규식은 추후에 공부하세요
      },
    },
  },
});
