import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)


export const constantRoutes = [
    {
        path: '/login',
        name: 'userLogin',
        component: () => import('@/views/user/login')
    },
    {
        path: '/register',
        name: 'userRegister',
        component: () => import('@/views/user/register')
    },
    
    {
        path: '/user',
        component: () => import('@/views/user/userLayout'),
        children: [
            {
                path:'',
                name: 'userHome',
                component: () => import('@/views/user/home')
            },
            {
                path: 'info',
                name: 'userInfo',
                component: () => import('@/views/user/userInfo')
            },

            {
                path: 'goods/post',
                name: 'userPostGoods',
                component: () => import('@/views/user/goods/post')
            },
            {
                path: 'goods/detail',
                name: 'userGoodsDetail',
                component: () => import('@/views/user/goods/detail')
            },
            {
                path: 'goods/manager',
                name: 'userGoodsManager',
                component: () => import('@/views/user/goods/manager')
            },
            {
                path: 'goods/want/home',
                name: 'userWantHome',
                component: () => import('@/views/user/goods/want')
            },
            {
                path: 'goods/want/post',
                name: 'userWantPost',
                component: () => import('@/views/user/goods/want/post')
            },
            {
                path: 'news',
                name: 'newsHome',
                component: () => import('@/views/user/news')
            },
            {
                path: 'explore',
                name: 'GoodsExplore',
                component: () => import('@/views/user/goods/search')
            }
        ]
    },

    {
        path: '/admin',
        component: () => import('@/views/admin/adminLayout'),
        meta:{
            title:"??????",
            showInbreadcrumb:true
        },
        children: [
            {
                path: 'login',
                name: 'adminLogin',
                component: () => import('@/views/admin/login/index'),
            },
            {
                path: 'user',
                name: 'adminUser',
                component: () => import('@/views/admin/user/user'),
                meta:{
                    title:"????????????",
                    showInbreadcrumb:true
                },
            },
            {
                path: 'administor',
                name: 'adminAdministor',
                component: () => import('@/views/admin/user/administor'),
                meta:{
                    title:"?????????????????????",
                    showInbreadcrumb:true
                },
            },
            {
                path: 'goods',
                name: 'adminGoods',
                component: () => import('@/views/admin/goods'),
                meta:{
                    title:"????????????",
                    showInbreadcrumb:true
                },
            },
            {
                path: 'comment',
                name: 'adminComment',
                component: () => import('@/views/admin/comment'),
                meta:{
                    title:"????????????",
                    showInbreadcrumb:true
                },
            },
            {
                path: 'want',
                name: 'adminWant',
                component: () => import('@/views/admin/want'),
                meta:{
                    title:"????????????",
                    showInbreadcrumb:true
                },
            },
            {
                path: 'news',
                name: 'adminNews',
                component: () => import('@/views/admin/news'),
                meta:{
                    title:"????????????",
                    showInbreadcrumb:true
                },
            },
            {
                path: 'category',
                name: 'adminCategory',
                component: () => import('@/views/admin/category'),
                meta:{
                    title:"????????????",
                    showInbreadcrumb:true
                },
            },
        ]
    },


    {
        path: '/404',
        component: () => import('@/views/404'),
    },

    // 404 page must be placed at the end !!!
    { path: '*', redirect: '/404'}
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
