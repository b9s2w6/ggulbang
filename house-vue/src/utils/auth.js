import { useAuthStore } from "@/stores/auth";

//로그인 여부 반환
export const isAuthenticated = () => {
  const authStore = useAuthStore();
  return !!authStore.token;
};

//유저권한 반환
export const getUserRole = () => {
  const authStore = useAuthStore();
  return authStore.user.role;
};
