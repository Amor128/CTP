<template>
  <div class="login">
    <el-form
      ref="loginForm"
      :model="loginForm"
      :rules="loginRules"
      class="login-form"
    >
      <h3 class="title">SYSTEM_NAME</h3>
      <el-form-item prop="phone">
        <el-input
          v-model="loginForm.phone"
          type="text"
          auto-complete="off"
          placeholder="手机号"
        >
          <i
            slot="prefix"
            icon-class="user"
            class="el-icon-user-solid el-input__icon"
          />
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          v-model="loginForm.password"
          type="password"
          auto-complete="off"
          placeholder="密码"
          @keyup.enter.native="handleLogin"
        >
          <i
            slot="prefix"
            icon-class="password"
            class="el-icon-lock el-input__icon"
          />
        </el-input>
      </el-form-item>
      <el-checkbox
        v-model="rememberMe"
        style="margin: 0px 0px 25px 0px"
      >记住密码</el-checkbox>
      <el-form-item style="width: 100%">
        <el-button
          :loading="loading"
          size="medium"
          type="primary"
          style="width: 100%"
          @click.native.prevent="handleLogin"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
        <div style="float: right">
          <router-link
            class="link-type"
            :to="'/register'"
          >立即注册</router-link>
        </div>
      </el-form-item>
    </el-form>

    <div class="el-login-footer">
      <span>YSTEM_NAME</span>
    </div>
  </div>
</template>

<script>
import Cookies from "js-cookie";

export default {
  name: "LoginView",
  data() {
    return {
      rememberMe: Boolean(Cookies.get("rememberMe")),
      loginForm: {
        phone:  Cookies.get("phone"),
        password: Cookies.get("password"),
      },

      loginRules: {
        phone: [
          { required: true, trigger: "blur", message: "请输入您的手机号" },
          { min: 11, max: 11, message: "请输入正确的手机号", trigger: "blur" },
        ],
        password: [{ required: true, trigger: "blur", message: "请输入您的密码" }],
      },
      loading: false,
    };
  },

  methods: {
    handleLogin() {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          if (this.rememberMe) {
            Cookies.set("phone", this.loginForm.phone, { expires: 30 });
            Cookies.set("password", this.loginForm.password, { expires: 30 });
            Cookies.set("rememberMe", this.rememberMe, { expires: 30 });
          } else {
            Cookies.remove("phone");
            Cookies.remove("password");
            Cookies.remove("rememberMe");
          }
          this.$store.dispatch("user/Login", this.loginForm).then(() => {
            this.$router.push('/user')
          }).catch().then(this.loading = false)
        }
      });
    },
  },
};
</script>


<style rel="stylesheet/scss" lang="scss" scoped>
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-image: url("@/assets/bg.jpg");
  background-size: cover;
}

.title {
  margin: 0px auto 30px auto;
  text-align: center;
  color: #707070;
}

.login-form {
  border-radius: 6px;
  background: #ffffff;
  width: 300px;
  padding: 25px 25px 5px 25px;

  .el-input {
    height: 38px;

    input {
      height: 38px;
    }
  }

  .input-icon {
    height: 39px;
    width: 14px;
    margin-left: 2px;
  }
}

.el-login-footer {
  height: 40px;
  line-height: 40px;
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
  color: #fff;
  font-family: Arial;
  font-size: 12px;
  letter-spacing: 1px;
}

.login-code-img {
  height: 38px;
}
</style>