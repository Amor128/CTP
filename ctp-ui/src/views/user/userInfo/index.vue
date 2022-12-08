<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="6">
        <div>
          <el-statistic
            group-separator=","
            :precision="2"
            :value="value2"
            :title="title"
          ></el-statistic>
        </div>
      </el-col>
      <el-col :span="6">
        <div>
          <el-statistic title="男女比">
            <template slot="formatter">
              456/2
            </template>

          </el-statistic>
        </div>
      </el-col>
      <el-col :span="6">
        <div>
          <el-statistic
            group-separator=","
            :precision="2"
            decimal-separator="."
            :value="value1"
            :title="title"
          >
            <template slot="prefix">
              <i
                class="el-icon-s-flag"
                style="color: red"
              ></i>
            </template>
            <template slot="suffix">
              <i
                class="el-icon-s-flag"
                style="color: blue"
              ></i>
            </template>
          </el-statistic>
        </div>

      </el-col>
      <el-col :span="6">
        <div>
          <el-statistic
            :value="like ? 521 : 520"
            title="Feedback"
          >
            <template slot="suffix">
              <span
                @click="like = !like"
                class="like"
              >
                <i
                  class="el-icon-star-on"
                  style="color:red"
                  v-show="!!like"
                ></i>
                <i
                  class="el-icon-star-off"
                  v-show="!like"
                ></i>
              </span> </template>
          </el-statistic>
        </div>
      </el-col>
    </el-row>
    <el-row style="margin-top: 60px">
      <el-col :span="24">
        <el-form
          ref="form"
          :model="form"
          label-width="80px"
        >
          <el-form-item label="学院">
            <el-input v-model="form.academy"></el-input>
          </el-form-item>
          <el-form-item label="昵称">
            <el-input v-model="form.nickname"></el-input>
          </el-form-item>
          <el-form-item label="QQ">
            <el-input v-model="form.qq"></el-input>
          </el-form-item>
          <el-form-item label="年级">
            <el-input v-model="form.grade"></el-input>
          </el-form-item>
          <el-form-item label="学校">
            <el-input v-model="form.school"></el-input>
          </el-form-item>
          <el-form-item label="学号">
            <el-input v-model="form.sn"></el-input>
          </el-form-item>
          <el-form-item label="电话">
            <el-input v-model="form.phone"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleUpdate">修改</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>

  </div>

</template>

<script>
import { getInfo, updateInfo } from "@/api/user"
import { copySameAttribute } from "@/utils"


export default {
  name: "UserInfoView",

  data() {
    return {
      form: {
        academy: "计算机科学与技术学院",
        nickname: "Ermao",
        qq: null,
        grade: "2019",
        school: "海南大学",
        sn: null,
        phone: "18871262086",
      },
      like: true,
      value1: 4154.564,
      value2: 2222,
      title: "今年的增长",
      input: "Hello Element UI!",
    };
  },
  computed: {
    userID() {return this.$store.getters.userID}
  },

  methods: {
    handleUpdate() {
      console.log("update useInfo:", this.form)
      updateInfo(this.userID, this.form).then(res => {
        console.log(res)
        this.$notify({title: "成功", message: "修改用户信息成功", type: "success"})
      }).catch()
    },
    freshUserInfo() {
      getInfo(this.userID).then(res => {
        console.log("freshUserInfo", res)
        copySameAttribute(this.form, res.data)
      }).catch()
    }
  },
  created() {
    this.freshUserInfo()
  }
};
</script>

<style>
.like {
  cursor: pointer;
  font-size: 25px;
  display: inline-block;
}
</style>