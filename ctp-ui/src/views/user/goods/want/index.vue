<template>
	<div id="want_layout">
		<div class="infinite_scroll_container" v-infinite-scroll="load">
            <el-card v-for="(i,index) in list" class="list-item" :key="index">
                <el-row class="want_container">
                    <el-col :span="4" class="want_img_container">
                        <el-image :src="src" fit="fill" style="height:100%; width:100%"/>
                    </el-col>
                    <el-col :span="1"><h5></h5></el-col>
                    <el-col :span="19" class="want_desc_container">
                        <div id="want_name">求购名称</div>
                        <div id="want_content" style="height:50%">求购内容</div>
                        <el-row class="want_trans_info">
                            <el-col :span="5">期望价格</el-col>
                            <el-col :span="8">期望交易地点</el-col>
                            <el-col :span="6">发布时间</el-col>
                        </el-row>


                        <el-row  class="want_contact_info">
                            <el-col :span="5">昵称</el-col>
                            <el-col :span="8">电话</el-col>
                            <el-col :span="6">QQ</el-col>
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
	export default {
		name: "GoodsWantHomeView",
        data () {
            return {
                count: 0,//起始页数值为0
                loading: false,
                totalPages: 20,//取后端返回内容的总页数
                list: [], //后端返回的数组
                src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
            }
        },

        computed: {
            noMore() {
                //当起始页数大于总页数时停止加载
                return this.count >= this.totalPages - 1;
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
                if (this.count < this.totalPages)
                    this.getMessage(); //调用接口，此时页数+1，查询下一页数据
            },

            getMessage() {
                let content = [{name: "ermao"}, {name: "ermao"}, {name: "ermao"}]
                this.list = this.list.concat(content); //因为每次后端返回的都是数组，所以这边把数组拼接到一起
                console.log(this.list)
                this.totalPages = 20;
                this.loading = false;
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