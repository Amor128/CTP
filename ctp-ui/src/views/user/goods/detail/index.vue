<template>
  <div class="goods_layout">
    <el-row class="goods_detail">
      <el-col class="image_container" :span="16">
        <el-image :src="goodsDetail.photo" :preview-src-list="srcList" style="height:100%; width:100%">
          <div slot="error" class="image-slot">
            <i class="el-icon-picture-outline"></i>
          </div>
        </el-image>
      </el-col>
      <el-col class="desc_container" :span="8">
        <div class="goods_name_container"><p>{{goodsDetail.name}}</p></div>
        <el-descriptions style="margin-top: 10px" :column="1">
          <el-descriptions-item label="原价" label-class-name="detail_attribute" content-class-name="buy_prive">{{goodsDetail.buyPrice}}</el-descriptions-item>
          <el-descriptions-item label="二手价" label-class-name="detail_attribute" content-class-name="sell_price">{{goodsDetail.sellPrice}}</el-descriptions-item>
          <el-descriptions-item label="发布时间" label-class-name="detail_attribute" content-class-name="detail_value">{{goodsDetail.createTime}}</el-descriptions-item>
          <el-descriptions-item label="交易地点" label-class-name="detail_attribute" content-class-name="detail_value">{{goodsDetail.transPlace}}</el-descriptions-item>
          <el-descriptions-item label="学校" label-class-name="detail_attribute" content-class-name="detail_value">{{goodsDetail.school}}</el-descriptions-item>
          <el-descriptions-item label="学院" label-class-name="detail_attribute" content-class-name="detail_value">{{goodsDetail.academy}}</el-descriptions-item>
          <el-descriptions-item label="年级" label-class-name="detail_attribute" content-class-name="detail_value">{{goodsDetail.grade}}</el-descriptions-item>
          <el-descriptions-item label="卖家" label-class-name="detail_attribute" content-class-name="detail_value">{{goodsDetail.nickname}}</el-descriptions-item>
          <el-descriptions-item label="电话" label-class-name="detail_attribute" content-class-name="detail_value">{{goodsDetail.phone}}</el-descriptions-item>
          <el-descriptions-item label="QQ" label-class-name="detail_attribute" content-class-name="detail_value">{{goodsDetail.qq}}</el-descriptions-item>
        </el-descriptions>
      </el-col>
    </el-row>
    <el-card class="goods_content_container">
      <span>{{goodsDetail.content}}</span>
    </el-card>
    <el-card class="goods_content_container"></el-card>
  </div>
</template>

<script>
import { getGoodsDetail } from "@/api/goods"
import { photo2Url } from "@/utils"

export default {

    name: "GoodsView",
    watch: {
      '$route': 'fetchGoodsDate'
    },
    data() {
      return {
        src: "",
        goodsDetail: {
          id: 1,
          photo: "",
          name: "",
          buyPrice: "",
          sellPrice: "",
          createTime: "",
          transPlace: "",
          userID: '',
          school: "",
          academy: "",
          grade: "",
          nickname: "",
          phone: "",
          qq: "",
          content: ""
        },
        srcList: []
      }
    },
    created () {
      // 组件创建完后获取数据，
      // 此时 data 已经被 observed 了
      this.fetchGoodsDate()
    },
    methods: {
      fetchGoodsDate() {
        getGoodsDetail(Number(this.$route.params.goodsID)).then(res => {
          res.data.photo = photo2Url(res.data.photo)
          this.goodsDetail = res.data
        }).catch()
      }
    }
}
</script>

<style>
.goods_layout {
  width: 70%;
  margin: 0 auto;
}

.image_container, .desc_container {
  height: 440px;
}

.desc_container {
  overflow-y: auto;
}

.goods_name_container {
  padding-left: 10px;
}

.goods_name_container p {
  font-size: 30px;
  font-weight:500;
  color: red;
  line-height: 1.3em;
  margin-block-start: 5px;
}

.detail_value {
  font-size: 14px;
  justify-content: flex-start;
  width: 60%;
}

.detail_attribute {
  font-size: 16px;
  justify-content: flex-end;
  width: 30%;
}

.goods_content_container, .goods_content_container {
  margin: 10px 0 0;
}



</style>