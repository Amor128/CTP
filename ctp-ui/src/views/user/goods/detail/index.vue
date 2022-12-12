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
    <el-card class="post_comment_card">
      <el-row>
        <el-col :span="20" style="padding-left:68px">
          <el-input
            type="textarea"
            placeholder="请输入你的提问"
            v-model="comment.content"
            maxlength="30"
            show-word-limit
          >
          </el-input>
        </el-col>
        <el-col :span="4" style="padding-left:30px;margin-top:8px">
            <el-button type="success" icon="el-icon-check" circle @click="handlePostComment"></el-button>
            <el-button type="danger" icon="el-icon-delete" circle @click="comment.content = ''"></el-button>
        </el-col>
      </el-row>
    </el-card>
    <el-card class="comment_list_container" v-if="commentList.length > 0">
      <el-timeline>
        <el-timeline-item v-for="c in commentList" :key="c.id" :timestamp="c.createTime" placement="top">
          <el-card>
            <el-row style="height:50px">
              <el-col :span="2">
                <el-avatar
                  shape='circle'
                  class="comment_user_avatar"
                  fit='fill'
                  :src="c.headPic">
                </el-avatar>
              </el-col>
              <el-col :span="20">
                <p v-if="c.replyTo != null && c.replyTo != ''">回复 | {{c.replyTo}}</p>
                <p>{{c.nickname}} 说： {{c.content}}</p>
              </el-col>
              <el-col :span="2">
                <p class="reply_button" @click="handleReply(c.nickname, c.content)">回复</p>
              </el-col>
            </el-row>

          </el-card>
        </el-timeline-item>
      </el-timeline>
    </el-card>

    <el-dialog title="回复" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item>
          <div>回复 {{replyInfo.nickname}}：{{replyInfo.content}}</div>
          <el-input v-model="replyInfo.replyContent" type="textarea" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false;">取 消</el-button>
        <el-button type="primary" @click="submitReply">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getGoodsDetail } from "@/api/goods"
import { postComment, listComments } from "@/api/comment"
import { photo2Url } from "@/utils"

export default {

    name: "GoodsView",
    watch: {
      '$route': 'fetchGoodsData'
    },
    data() {
      return {
        src: "",
        goodsDetail: {
          id: '',
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
        comment:{
          content: '',
          replyTo: '',
        },
        srcList: [],
        commentList: [],
        dialogFormVisible: false,
        form: {
        },
        replyInfo: {
          nickname: '',
          content: '',
          replyContent: ''
        },
      }
    },
    computed: {
      userID() {return this.$store.getters.userID}
    },
    created () {
      // 组件创建完后获取数据，
      // 此时 data 已经被 observed 了
      this.fetchGoodsData()
      this.fetchCommentData()
    },
    methods: {
      fetchGoodsData() {
        getGoodsDetail(Number(this.$route.params.goodsID)).then(res => {
          res.data.photo = photo2Url(res.data.photo)
          this.goodsDetail = res.data
        }).catch()
      },

      fetchCommentData() {
        let params = {goodsID: Number(this.$route.params.goodsID)}
        listComments(params).then(res => {
          for (let i = 0; i< res.data.length; i++) {
            res.data[i].headPic = photo2Url(res.data[i].headPic)
          }
          this.commentList = res.data
        }).catch()
      },

      handleReply(nickname, content) {
        Object.assign(this.replyInfo, {nickname, content})
        this.dialogFormVisible = true
      },

      submitReply() {
        let data = {}
        data.userID = this.userID;
        data.goodsID = this.goodsDetail.id
        data.replyTo = this.replyInfo.nickname + "：" + this.replyInfo.content
        data.content = this.replyInfo.replyContent
        postComment(data).then(res => {
          // TODO 通知
          console.log(res)
          this.fetchCommentData()
          this.dialogFormVisible = false
          this.replyInfo.content = ''
        }).catch()
        
      },

      handlePostComment() {
        let data = {}
        Object.assign(data, this.comment)
        data.userID = this.userID
        if (data.replyTo == '') {
          delete data.replyTo
        }
        data.goodsID = this.goodsDetail.id

        postComment(data).then(res => {
          // TODO 通知
          console.log(res)
          this.fetchCommentData()
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

.post_comment_card,
.comment_list_container {
  margin-top: 10px;
  
}

.submit_comment_button_container {
  padding: 10px 0px 0px 33px;
}

.comment_user_avatar {
  margin: 0 auto;
}

.reply_button {
  text-decoration-line: underline;
  color: rgb(38, 38, 255);
}

.reply_button:hover {
  text-decoration-line: underline;
  color: pink;
}


</style>