<template>
	<el-container style="height:100%">
		<el-aside width="200px">
			<el-menu
				default-active="2"
				class="el-menu-vertical-demo"
				@open="handleOpen"
				@close="handleClose"
			>
				<el-submenu index="1">
					<template slot="title">
						<i class="el-icon-location"></i>
						<span>用户管理</span>
					</template>

					<el-menu-item index="1-1">求改密码</el-menu-item>
					<el-menu-item index="1-2">冻结用户</el-menu-item>
					<el-menu-item index="1-3">管理员帐号</el-menu-item>
				</el-submenu>
				<el-menu-item index="2">
					<i class="el-icon-menu"></i>
					<span slot="title">商品管理</span>
				</el-menu-item>
				<el-menu-item index="3">
					<i class="el-icon-document"></i>
					<span slot="title">评论管理</span>
				</el-menu-item>
				<el-menu-item index="4">
					<i class="el-icon-setting"></i>
					<span slot="title">求购管理</span>
				</el-menu-item>
				<el-menu-item index="5">
					<i class="el-icon-setting"></i>
					<span slot="title">新闻管理</span>
				</el-menu-item>
				<el-menu-item index="6">
					<i class="el-icon-setting"></i>
					<span slot="title">分类管理</span>
				</el-menu-item>
			</el-menu>
		</el-aside>
		<el-container>
			<el-header style="border-bottom: solid gray 1px;">
				<el-breadcrumb
					separator-class="el-icon-arrow-right"
					class="breadcrumb_container"
				>
					<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
					<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
					<el-breadcrumb-item v-for="(breadcrumb, index) in breadcrumbList" :key="index">{{breadcrumb.name}}</el-breadcrumb-item>
				</el-breadcrumb>
			</el-header>
			<el-main>
				<router-view></router-view>
			</el-main>
		</el-container>
	</el-container>
</template>

<script>
	export default {
		name: "AdminLayoutView",
		data() {
			return {
				breadcrumbList:[],
			};
		},
		methods: {
			routeTo(name) {
				this.$router.push({ name });
			},
			handleOpen( ) {},

			handleClose() {}
		},
	};
</script>

<style scoped>
	.avatar {
		margin: 15px 15px 15px 15px;
	}
	.breadcrumb_container {
		margin: 22px 0 0 10px;
	}
</style>