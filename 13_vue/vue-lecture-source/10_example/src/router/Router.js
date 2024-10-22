import {createRouter, createWebHistory} from 'vue-router';
import Main from "@/views/main/Main.vue";


const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            component: Main
        },
        {
            path: '/products',
            component: () => import('@/views/product/ProductList.vue')
        },
        {
            path: '/products/:id',
            component: () => import('@/views/product/ProductDetail.vue')
        },
        {
            path: '/products/create',
            component: () => import('@/views/product/ProductCreate.vue')
        },
        {
            path: '/products/:id/edit',
            component: () => import('@/views/product/ProductEdit.vue')
        },
    ]
})

export default router;