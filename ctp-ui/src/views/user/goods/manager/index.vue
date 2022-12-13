<template>
	<el-card class="goods_manager">
		<el-collapse>
			<el-collapse-item title="我发布的商品">
				<el-card class="card_container" v-for="myGoods in myGoodsList" :key="myGoods.id">
                    <el-row class="goods_post_container">
                        <el-col class="goods_post_img_container" :span="6">
                            <el-image :src="myGoods.photoUrl" fit="fill" style="height:150px; width:80%"/>
                        </el-col>
                        <el-col :span="18">
                            <div style="height:30px">{{myGoods.name}}</div>
                            <div style="height:70px">{{myGoods.content}}</div>
                                <el-row style="height:50px">
                                    <el-col :span="3">
                                        <span style="color:green" v-if="myGoods.status==0">正在出售</span>
                                        <span style="color:orange" v-if="myGoods.status==1">已下架</span>
                                        <span style="color:red" v-if="myGoods.status==2">已售出</span>
                                    </el-col>
                                    <el-col :span="1">|</el-col>
                                    <el-col :span="9">{{myGoods.createTime}}</el-col>
                                    <el-col :span="3" v-if="myGoods.status != 2"><el-button round size="small" @click="handleUpdate(myGoods)">编辑</el-button></el-col>
                                    <el-col :span="3" v-if="myGoods.status == 1"><el-button size="small" type="danger" round @click="handleUp(myGoods.id)">上架</el-button></el-col>
                                    <el-col :span="3" v-if="myGoods.status == 0"><el-button size="small" type="danger" round @click="handleDown(myGoods.id)">下架</el-button></el-col>
                                    <el-col :span="5" v-if="myGoods.status != 2"><el-button size="small" type="success" round @click="handleFInish(myGoods.id)">确认售出</el-button></el-col>
                                    <el-col :span="5" v-if="myGoods.status == 2"><el-button size="small" type="success" round>已售出</el-button></el-col>
                                </el-row>
                        </el-col>
                    </el-row>
                </el-card>
			</el-collapse-item>
			<el-collapse-item title="我想要的商品">
				<el-card class="card_container" v-for="myWant in myWantList" :key="myWant.id">
                    <el-row class="goods_post_container">
                        <el-col class="goods_post_img_container" :span="6">
                            <el-image :src="src" fit="fill" style="height:150px; width:80%"/>
                        </el-col>
                        <el-col :span="18">
                            <div style="height:30px">{{myWant.name}}</div>
                            <div style="height:70px">{{myWant.content}}</div>
                                <el-row style="height:50px">
                                    <el-col :span="21">{{myWant.createTime}}</el-col>
                                    <el-col :span="3"><el-button size="small" type="danger" round @click="handleDel(myWant.id)">删除</el-button></el-col>
                                </el-row>
                        </el-col>
                    </el-row>
                </el-card>
			</el-collapse-item>
            <el-collapse-item title="我举报的商品" v-if="false">
				<el-card class="card_container">
                    <el-row class="goods_post_container">
                        <el-col class="goods_post_img_container" :span="6">
                            <el-image :src="src" fit="fill" style="height:150px; width:80%"/>
                        </el-col>
                        <el-col :span="18">
                            <div style="height:30px">商品名称</div>
                            <div style="height:70px">商品描述</div>
                                <el-row style="height:50px">
                                    <el-col :span="10">举报时间</el-col>
                                    <el-col :span="11">举报原因</el-col>
                                    <el-col :span="3"><el-button size="small" type="danger" round>删除</el-button></el-col>
                                </el-row>
                        </el-col>
                    </el-row>
                </el-card>
			</el-collapse-item>
		</el-collapse>
	</el-card>
</template>

<script>

    import { lsitMyGoods, updateGoods } from '@/api/goods'
    import { getMyWantList, removeWant } from '@/api/want'
    import { photo2Url } from '@/utils'

	export default {
		name: "GoodsManagerView",
        data() {
            return {
                src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
                myGoodsList: [],
                myWantList: []
            }
        },
        computed: {
            userID() {return this.$store.getters.userID}
        },
        created() {
            this.fetchMyGoodsList()
            this.fetchMyWantList()
        },
        methods: {
            handleUp(goodsID) {
                this.changeGoodsStatus(goodsID, 0)
            },
            handleDown(goodsID) {
                this.changeGoodsStatus(goodsID, 1)
            },
            handleFInish(goodsID) {
                this.changeGoodsStatus(goodsID, 2)
            },
            handleDel(wantID) {
                removeWant(wantID).then(res => {
                    console.log(res)
                    this.fetchMyWantList()
                }).catch()
            },

            fetchMyGoodsList() {
                let params = {}
                params.userID = this.userID
                lsitMyGoods(params).then(res => {
                    for (let i = 0; i < res.data.length; i++) {
                        res.data[i].photoUrl = photo2Url(res.data[i].photo)
                    }
                    this.myGoodsList = res.data
                }).catch()
            },

            fetchMyWantList() {
                let params = {}
                params.userID = this.userID
                getMyWantList(params).then(res => {
                    this.myWantList = res.data
                }).catch()
            },
            changeGoodsStatus(goodsID, newStatus) {
                let data = {status: newStatus}
                updateGoods(goodsID, data).then(res => {
                    console.log(res)
                    this.fetchMyGoodsList()
                }).catch()
            },
            handleUpdate(goods) {
                this.$router.push({name: 'userPostGoods', params: {goods}})
            }
        }
	};
</script>

<style>
	.goods_manager {
		width: 70%;
		margin: 0 auto;
	}

    .goods_post_container{
        height: 150px;
    }

    .card_container {
        margin-top: 10px;
    }
</style>