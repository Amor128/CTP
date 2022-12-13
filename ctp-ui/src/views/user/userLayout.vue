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
            <el-menu-item index="1">首页</el-menu-item>
            <el-submenu index="2">
              <template slot="title">商品</template>
              <el-menu-item index="2-1">分类浏览</el-menu-item>
              <el-menu-item index="2-2">发布商品</el-menu-item>
              <el-menu-item index="2-3">管理商品</el-menu-item>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title">想要</template>
              <el-menu-item index="3-1">求助广场</el-menu-item>
              <el-menu-item index="3-2">发布求助</el-menu-item>
            </el-submenu>
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
              <el-dropdown-item @click.native="handleLogout">退出登录</el-dropdown-item>
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
      activeIndex: "1",
      circleUrl:
        "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
    };
  },
  methods: {
    handleSelect(key) {
      switch(key) {
        case "1":
          this.routeTo("userHome")
          break
        case "2-1":
          this.routeTo("GoodsExplore")
          break;
        case "2-2":
          this.routeTo("userPostGoods")
          break;
        case "2-3":
          this.routeTo("userGoodsManager")
          break;
        case "3-1":
          this.routeTo("userWantHome")
          break;
        case "3-2":
          this.routeTo("userWantPost")
          break;
        default:
      }
    },
    handleLogout() {
      this.$store.dispatch("user/logout")
      this.$router.push('/login')
    },

    handleClick() {this.$router.push('/user/info')},
    routeTo(name) {this.$router.push({name})}
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