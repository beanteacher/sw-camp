import {createRouter,  createWebHistory} from 'vue-router';
import { useAuthStore } from '@/stores/auth';
import Main from "@/views/main/Main.vue";
import BasicTest from "@/views/basic/BasicTest.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            component: Main
        },
        {
            path: '/basic',
            component: BasicTest
        },
        {
            path: '/login',
            component: () => import('@/views/user/Login.vue'),
        },
        {
            path: '/register',
            component: () => import('@/views/user/Register.vue'),
        },
        {
            path: '/mypage',
            component: () => import('@/views/user/MyPage.vue'),
            meta: { requiresAuth: true },
        },
    ]
})

/* Navigation Guard : beforeEach 가드를 사용하여 라우트 이동 전에 인증 상태를 체크한다. */
router.beforeEach((to, from, next) => {
    const authStore = useAuthStore();

    // 인증이 필요한 페이지에 접근할 때
    if (to.meta.requiresAuth && !authStore.accessToken) {
        next({ path: '/login' }); // 로그인 페이지로 리디렉션
    }
    // 이미 로그인한 상태에서 로그인, 회원가입 페이지에 접근할 때
    else if (authStore.accessToken && (to.path === '/login' || to.path === '/register')) {
        next({ path: '/mypage' }); // 마이페이지로 리디렉션
    } else {
        next(); // 나머지 경우는 계속 진행
    }
});

export default router;