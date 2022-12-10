import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)


export const constantRoutes = [
    {
        path: '/login',
        component: () => import('@/views/user/login')
    },
    {
        path: '/register',
        component: () => import('@/views/user/register')
    },
    
    {
        path: '/user',
        component: () => import('@/views/user/userLayout'),
        children: [
            {
                path:'',
                component: () => import('@/views/user/home')
            },
            {
                path: 'info',
                component: () => import('@/views/user/userInfo')
            },

            {
                path: 'goods/post',
                component: () => import('@/views/user/goods/post')
            },
            {
                path: 'goods/detail',
                component: () => import('@/views/user/goods/detail')
            },
            {
                path: 'goods/manager',
                component: () => import('@/views/user/goods/manager')
            },

            
        ]
    },
    {
        path: '/admin/login',
        component: () => import('@/views/admin/login/index'),
        hidden: true
    },

    {
        path: '/404',
        component: () => import('@/views/404'),
        hidden: true
    },

    // 404 page must be placed at the end !!!
    { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
    mode: 'history', // require service support
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
    const newRouter = createRouter()
    router.matcher = newRouter.matcher // reset router
}

export default router
