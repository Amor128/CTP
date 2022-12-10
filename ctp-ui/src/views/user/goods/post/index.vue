<template>
  <div class="post_goods">
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
    <el-dialog title="图片剪裁" :visible.sync="dialogVisible" append-to-body>
        <div class="cropper-content">
          <div class="cropper" style="text-align:center">
          <vue-cropper
            ref="cropper"
            :img="option.img"
            :outputSize="option.size"
            :outputType="option.outputType"
            :info="true"
            :full="option.full"
            :canMove="option.canMove"
            :canMoveBox="option.canMoveBox"
            :original="option.original"
            :autoCrop="option.autoCrop"
            :fixed="option.fixed"
            :fixedNumber="option.fixedNumber"
            :centerBox="option.centerBox"
            :infoTrue="option.infoTrue"
            :fixedBox="option.fixedBox"
          ></vue-cropper>
          </div>
        </div>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="finish" :loading="loading">确认</el-button>
        </div>
      </el-dialog>
  </div>
</template>

<script>
import { VueCropper }  from 'vue-cropper' 
import { upload } from '@/api/file'


export default {
  components: {
    VueCropper
  },
  
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

      dialogVisible: false,
      // 裁剪组件的基础配置option
      option: {
        img: '', // 裁剪图片的地址
        info: true, // 裁剪框的大小信息
        outputSize: 0.8, // 裁剪生成图片的质量
        outputType: 'jpeg', // 裁剪生成图片的格式
        canScale: false, // 图片是否允许滚轮缩放
        autoCrop: true, // 是否默认生成截图框
        fixedBox: true, // 固定截图框大小 不允许改变
        fixed: true, // 是否开启截图框宽高固定比例
        fixedNumber: [4, 3], // 截图框的宽高比例
        full: true, // 是否输出原图比例的截图
        canMoveBox: false, // 截图框能否拖动
        original: false, // 上传图片按照原始比例渲染
        centerBox: true, // 截图框是否被限制在图片里面
        infoTrue: true // true 为展示真实输出图片宽高 false 展示看到的截图框宽高
      },
      picsList: [],  //页面显示的数组
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


    
    // 点击裁剪，这一步是可以拿到处理后的地址
    finish() {
      this.$refs.cropper.
      this.$refs.cropper.getCropBlob((data) => {
        upload(data).then(res => {
          console.log(res)
          this.form.photo = res.data.url
          this.photoUrl = "http://localhost:8080" + res.data.url
          this.dialogVisible = false
        }).catch().then(
          this.loading = false
        )
      })
    }
  }


}
</script>

<style>


  .form_container {
    margin: 0 auto;
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