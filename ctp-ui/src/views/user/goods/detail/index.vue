<template>
  <div class="goods_layout">
    <el-row class="goods_detail">
      <el-col class="image_container" :span="16">
        <el-image :src="src" :preview-src-list="srcList" :fit="fit" style="height:100%; width:100%">
          <div slot="error" class="image-slot">
            <i class="el-icon-picture-outline"></i>
          </div>
        </el-image>
      </el-col>
      <el-col class="desc_container" :span="8">
        <div class="goods_name_container"><p>商品介绍内容</p></div>
        <el-descriptions style="margin-top: 10px" :column="1" :size="medium">
          <el-descriptions-item label="原价" label-class-name="detail_attribute" content-class-name="buy_prive">kooriookami</el-descriptions-item>
          <el-descriptions-item label="二手价" label-class-name="detail_attribute" content-class-name="sell_price">kooriookami</el-descriptions-item>
          <el-descriptions-item label="发布时间" label-class-name="detail_attribute" content-class-name="detail_value">kooriookami</el-descriptions-item>
          <el-descriptions-item label="交易地点" label-class-name="detail_attribute" content-class-name="detail_value">18100000000</el-descriptions-item>
          <el-descriptions-item label="学校" label-class-name="detail_attribute" content-class-name="detail_value">苏州市</el-descriptions-item>
          <el-descriptions-item label="学院" label-class-name="detail_attribute" content-class-name="detail_value">苏州市</el-descriptions-item>
          <el-descriptions-item label="年级" label-class-name="detail_attribute" content-class-name="detail_value">苏州市</el-descriptions-item>
          <el-descriptions-item label="卖家" label-class-name="detail_attribute" content-class-name="detail_value">苏州市</el-descriptions-item>
        </el-descriptions>
      </el-col>
    </el-row>
    <el-card class="goods_content_container">
      <span>dhoafhdsahofha</span>
    </el-card>
    <el-card class="goods_content_container"></el-card>
  </div>
</template>

<script>
export default {
    name: "GoodsView",
    data() {
      return {
        src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
        srcList: [
          "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
        ]
      }
    }
}
</script>

<style>
.goods_detail {
  border: solid 2px purple;
}

.goods_layout {
  width: 70%;
  margin: 0 auto;
  border: solid 2px green;
}

.image_container, .desc_container {
  border: solid 2px red;
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
  border: 1px solid red;
  justify-content: flex-start;
  width: 60%;
}

.detail_attribute {
  font-size: 16px;
  border: 1px solid green;
  justify-content: flex-end;
  width: 30%;
}

.goods_content_container, .goods_content_container {
  border: solid 2px orange;
  margin: 10px 0 0;
}



</style>