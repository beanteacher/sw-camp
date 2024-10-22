import {createRouter, createWebHashHistory, createWebHistory} from "vue-router";
import HomeView from "@/views/01_router/HomeView.vue";
import PathVariable from "@/views/01_router/PathVariable.vue";
import QueryString from "@/views/01_router/QueryString.vue";

const router = createRouter({
    // history: createWebHashHistory(),
    history: createWebHistory(),
    routes : [
        {
            path : '/',
            component: HomeView
        },
        {
            /* PathVariable 방식으로 라우팅할 경우 해당 값을 처리할 변수명을 작성한다. */
            path : '/pathvariable/:id',
            component: PathVariable
        },
        {
            path : '/querystring',
            component: QueryString
        },
    ]
});

export default router;


