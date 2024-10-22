import {createRouter, createWebHistory} from "vue-router";
import HomeView from "@/views/01_router/HomeView.vue";
import RootRouter from "@/views/02_nestedRouter/RootRouter.vue";
// import NestedHome from "@/views/02_nestedRouter/NestedHome.vue";
import NestedView from "@/views/02_nestedRouter/NestedView.vue";

const route = createRouter({
    history: createWebHistory(),
    routes : [
        {
            path: '/',
            component: HomeView
        },
        {
            path: '/nested',
            component: RootRouter,
            children : [
                {
                    path : "home",
                    // component: NestedHome
                    /* lazy load : 코드를 분할해서 필요할 때마다 코드를 해당 시점에 로딩하여
                    메모리 사용 및 성능 향상의 목적 */
                    component: () => import('@/views/02_nestedRouter/NestedHome.vue')
                },
                {
                    path: "view",
                    component: NestedView
                }
            ]
        },
    ]
});

export default route;