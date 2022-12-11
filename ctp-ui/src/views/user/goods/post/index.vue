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
        <el-input v-model="form.sellPrice"></el-input>
      </el-form-item>
      <el-form-item label="商品类型">
        <el-cascader
          v-model="form.goodsCategoryID"
          :options="categories"
          :props="{ expandTrigger: 'hover' }"
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
export default {
  name: "PostGoodsView",

  data() {
    return {
      form: {
        name: '',
        buyPrice: '',
        sellPrice: '',
        goodsCategoryID: '',
        photo: ''
      },
      photoUrl: '',
      categories: [
        {
          value: 'zhinan',
          label: '指南',
          children: [
            {
              value: 'shejiyuanze',
              label: '设计原则',
              children: [
                {
                value: 'yizhi',
                label: '一致'
                },
                {
                  value: 'fankui',
                  label: '反馈'
                }
              ]
            }
          ]
        },
        {
          value: 'zhinan',
          label: '指南',
          children: [
            {
              value: 'shejiyuanze',
              label: '设计原则',
              children: [
                {
                value: 'yizhi',
                label: '一致'
                },
                {
                  value: 'fankui',
                  label: '反馈'
                }
              ]
            }
          ]
        }
      ],

      imgUrl: '',
      // 防止重复提交
      loading: false
    }
  },

  methods: {
    onSubmit() {
      console.log('submit!');
    },

    handleChange(value) {
      console.log(value);
    },

    onSuccess(res) {
      console.log(res)
      this.form.photo = res.data.url
      this.photoUrl = "http://localhost:8080" + res.data.url
    },
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