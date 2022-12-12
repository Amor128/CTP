<template>
	<div id="want_layout">
		<div class="infinite_scroll_container" v-infinite-scroll="load">
            <el-card v-for="item in list" class="list-item" :key="item.id">
                <el-row class="want_container">
                    <el-col :span="4" class="want_img_container">
                        <el-image :src="item.headPic" fit="fill" style="height:100%; width:100%"/>
                    </el-col>
                    <el-col :span="1"><h5></h5></el-col>
                    <el-col :span="19" class="want_desc_container">
                        <div id="want_name">{{item.name}}</div>
                        <div id="want_content" style="height:50%">{{item.content}}</div>
                        <el-row class="want_trans_info">
                            <el-col :span="5">卖价：{{item.sellPrice}}</el-col>
                            <el-col :span="10">交易地点：{{item.transPlace}}</el-col>
                            <el-col :span="9">发布时间：{{item.createTime}}</el-col>
                        </el-row>


                        <el-row  class="want_contact_info">
                            <el-col :span="5">昵称：{{item.nickname}}</el-col>
                            <el-col :span="10">电话：{{item.phone}}</el-col>
                            <el-col :span="9">QQ：{{item.qq}}</el-col>
                        </el-row>
                    </el-col>
                </el-row>
            </el-card>
            <p v-if="loading" style="margin-top:10px;" class="loading">
                <span></span>
            </p>
            <p v-if="noMore" style="margin-top:10px;font-size:13px;color:#ccc">没有更多了</p>
        </div>
	</div>
</template>

<script>

import { getWantPage } from '@/api/want'

	export default {
		name: "GoodsWantHomeView",
        data () {
            return {
                count: 1,//起始页数值为0
                loading: false,
                totalPages: 100,//取后端返回内容的总页数
                list: [], //后端返回的数组
            }
        },

        computed: {
            noMore() {
                //当起始页数大于总页数时停止加载
                return this.count >= this.totalPages;
            },
            disabled() {
                return this.loading || this.noMore;
            }
        },

        created() {
            this.getMessage();
        },

        methods: {
            load () {
                //滑到底部时进行加载
                this.loading = true;
                this.count += 1; //页数+1
                if (this.count <= this.totalPages)
                    this.getMessage(); //调用接口，此时页数+1，查询下一页数据
            },

            getMessage() {
                let params = {page: this.count, perPage: 3}
                getWantPage(params).then(res => {
                    this.list = this.list.concat(res.data.list)
                    this.loading = false;
                    this.totalPages = Math.ceil(Number(res.data.total) / res.data.perPage);
                    console.log("pages", this.totalPages)
                }).catch()
            }
        }
	};
</script>

<style>
#want_layout {
    width: 70%;
    height: 80vh;
    margin: 0 auto;
}

.infinite_scroll_container {
    height: 100%;
    overflow-y: auto;
}

.list-item{
    height: 190px;
    margin-top: 10px;
}

.want_container {
    height: 150px;
}

.want_img_container, .want_desc_container{
    height: 100%;
}

#want_name {
    height: 20%;
    font-size: 20px;
    font-weight: 700;
    color: brown;
}

#want_content {
    height: 50%;
    font-size: 14px;
    color: gray;
}

.want_trans_info {
    height: 20%;
    font-size: 12px;
    color: coral;
    line-height: 1em;
}

.want_contact_info{
    height: 10%;
    font-size: 14px;
    font-weight: 700;
    line-height: 1em;
}

</style>