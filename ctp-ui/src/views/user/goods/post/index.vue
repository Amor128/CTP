<template>
  <el-card class="form_container">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="商品名称">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="买入价格">
        <el-input v-model="form.buyPrice"></el-input>
      </el-form-item>
      <el-form-item label="期望卖价">
        <el-input v-model="form.sellPrice"></el-input>
      </el-form-item>
      <el-form-item label="交易地点">
        <el-input v-model="form.transPlace"></el-input>
      </el-form-item>
      <el-form-item label="商品类型">
        <el-cascader
          v-model="form.goodsCategoryID"
          :options="categories"
          :props="{ expandTrigger: 'hover',label: 'name', value: 'id' }"
          @change="handleChange"></el-cascader>
      </el-form-item>
      <el-form-item label="商品描述">
        <el-input type="textarea" v-model="form.content"></el-input>
      </el-form-item>
      <el-form-item label="商品图片">
        <el-upload
          class="avatar-uploader"
          action="/api/files"
          :show-file-list="false"
          :on-success='onSuccess'>
          <img v-if="photoUrl" :src="photoUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      
      <el-form-item>
        <div class="post_button">
          <el-button type="primary" @click="onSubmit">发布</el-button>
          <el-button>清空</el-button>
        </div>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import { insertGoods } from "@/api/goods"
import { listCategories } from "@/api/category"
import { deleteEmptyArray, convertStringToNumber } from '@/utils'

export default {
  name: "PostGoodsView",

  data() {
    return {
      form: {
        name: '',
        buyPrice: '',
        sellPrice: '',
        goodsCategoryID: '',
        photo: '',
        content: '',
        transPlace: ''
      },
      photoUrl: '',
      categories: [],

      // 防止重复提交
    }
  },

  computed: {
    userID() {return this.$store.getters.userID}
  },

  methods: {
    onSubmit() {
      let data = {}
      Object.assign(data, this.form)
      data.sellPrice = Number(data.sellPrice)
      data.buyPrice = Number(data.buyPrice)
      data.userID = this.userID
      data.goodsCategoryID = data.goodsCategoryID[1]
      convertStringToNumber(data)
      console.log(data)
      insertGoods(data).then(res => {
        console.log(res)
        // TODO 发布成功，notify，跳转到管理商品页面
      }).catch(err => console.log(err))
    },

    handleChange(value) {
      console.log(value);
    },

    onSuccess(res) {
      console.log(res)
      this.form.photo = res.data.url
      this.photoUrl = "http://localhost:8080" + res.data.url
    },

    fechCategories() {
      console.log("fech")
      listCategories().then(res => {
        for (let i = 0; i < res.data.length; i++)
          deleteEmptyArray(res.data[i])
        console.log(res)
        this.categories = res.data
      }).catch()
    }
  },
  created() {
    this.fechCategories()
  }
}
</script>

<style>


  .form_container {
    margin: 0 auto;
    width: 70%;
  }

  .post_button {
    margin: 0 auto;
    width: 200px;
  }

  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }

  .cropper-content .cropper {
    width: auto;
    height: 300px;
  }

</style>