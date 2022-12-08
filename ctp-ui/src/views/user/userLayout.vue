<template>
  <el-container>
    <el-header>
      <el-row>
        <el-col :span="23">
          <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
          >
            <el-menu-item index="1">处理中心</el-menu-item>
            <el-submenu index="2">
              <template slot="title">我的工作台</template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
              <el-menu-item index="2-3">选项3</el-menu-item>
              <el-submenu index="2-4">
                <template slot="title">选项4</template>
                <el-menu-item index="2-4-1">选项1</el-menu-item>
                <el-menu-item index="2-4-2">选项2</el-menu-item>
                <el-menu-item index="2-4-3">选项3</el-menu-item>
              </el-submenu>
            </el-submenu>
            <el-menu-item
              index="3"
              disabled
            >消息中心</el-menu-item>
            <el-menu-item index="4"><a
                href="https://www.ele.me"
                target="_blank"
              >订单管理</a></el-menu-item>
          </el-menu>
        </el-col>
        <el-col :span="1">
          <el-dropdown>
            <el-avatar
              class="avatar"
              :size="40"
              :src="circleUrl"
            ></el-avatar>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item @click.native="handleClick">个人中心</el-dropdown-item>
              <el-dropdown-item>退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>

        </el-col>
      </el-row>

    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: "0",
      circleUrl:
        "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },

    handleClick() {this.$router.push('/user/info')}
  },
};
</script>

<style scoped>
.avatar {
  margin: 15px 15px 15px 15px;
}

.el-dropdown-link {
  cursor: pointer;
  color: #409eff;
}
.el-icon-arrow-down {
  font-size: 12px;
}
</style>