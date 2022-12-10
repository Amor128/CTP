<template>
	<div class="goods_manager">
		<el-collapse>
			<el-collapse-item title="我发布的商品">
				<el-card class="card_container">
                    <el-row class="goods_post_container">
                        <el-col class="goods_post_img_container" :span="6">
                            <el-image :src="src" fit="fill" style="height:150px; width:80%"/>
                        </el-col>
                        <el-col :span="18">
                            <div style="height:30px">商品名称</div>
                            <div style="height:70px">商品描述</div>
                                <el-row style="height:50px">
                                    <el-col :span="3">商品状态</el-col>
                                    <el-col :span="1">|</el-col>
                                    <el-col :span="10">上架时间</el-col>
                                    <el-col :span="3"><el-button round>编辑</el-button></el-col>
                                    <el-col :span="3"><el-button type="danger" round>下架</el-button></el-col>
                                    <el-col :span="4"><el-button type="success" round>确认出售</el-button></el-col>
                                </el-row>
                        </el-col>
                    </el-row>
                </el-card>
				<el-card class="card_container">
                    <el-row class="goods_post_container">
                        <el-col class="goods_post_img_container" :span="6">
                            <el-image :src="src" fit="fill" style="height:150px; width:80%"/>
                        </el-col>
                        <el-col :span="18">
                            <div style="height:30px">商品名称</div>
                            <div style="height:70px">商品描述</div>
                                <el-row style="height:50px">
                                    <el-col :span="3">商品状态</el-col>
                                    <el-col :span="1">|</el-col>
                                    <el-col :span="10">上架时间</el-col>
                                    <el-col :span="3"><el-button round>编辑</el-button></el-col>
                                    <el-col :span="3"><el-button type="danger" round>下架</el-button></el-col>
                                    <el-col :span="4"><el-button type="success" round>确认出售</el-button></el-col>
                                </el-row>
                        </el-col>
                    </el-row>
                </el-card>
			</el-collapse-item>
			<el-collapse-item title="我想要的商品">
				<el-card class="card_container">
                    <el-row class="goods_post_container">
                        <el-col class="goods_post_img_container" :span="6">
                            <el-image :src="src" fit="fill" style="height:150px; width:80%"/>
                        </el-col>
                        <el-col :span="18">
                            <div style="height:30px">商品名称</div>
                            <div style="height:70px">商品描述</div>
                                <el-row style="height:50px">
                                    <el-col :span="18">上架时间</el-col>
                                    <el-col :span="3"><el-button round>编辑</el-button></el-col>
                                    <el-col :span="3"><el-button type="danger" round>删除</el-button></el-col>
                                </el-row>
                        </el-col>
                    </el-row>
                </el-card>
				<el-card class="card_container">
                    <el-row class="goods_post_container">
                        <el-col class="goods_post_img_container" :span="6">
                            <el-image :src="src" fit="fill" style="height:150px; width:80%"/>
                        </el-col>
                        <el-col :span="18">
                            <div style="height:30px">商品名称</div>
                            <div style="height:70px">商品描述</div>
                                <el-row style="height:50px">
                                    <el-col :span="18">上架时间</el-col>
                                    <el-col :span="3"><el-button round>编辑</el-button></el-col>
                                    <el-col :span="3"><el-button type="danger" round>删除</el-button></el-col>
                                </el-row>
                        </el-col>
                    </el-row>
                </el-card>
			</el-collapse-item>
            <el-collapse-item title="我举报的商品">
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
                                    <el-col :span="3"><el-button type="danger" round>删除</el-button></el-col>
                                </el-row>
                        </el-col>
                    </el-row>
                </el-card>
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
                                    <el-col :span="3"><el-button type="danger" round>删除</el-button></el-col>
                                </el-row>
                        </el-col>
                    </el-row>
                </el-card>
			</el-collapse-item>
		</el-collapse>
	</div>
</template>

<script>
	export default {
		name: "GoodsManagerView",
        data() {
            return {
                src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
            }
        },
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