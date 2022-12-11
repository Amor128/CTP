<template>
	<div id="user_home">
		<el-carousel type="card">
			<el-carousel-item
				class="banner_item"
				v-for="item in items"
				:key="item.id"
			><img
					class="banner_iamger"
					:src="item.src"
					alt=""
				></el-carousel-item>
		</el-carousel>
		<el-row style="margin: 25px auto 0px">
			<el-col
				:span="6"
				v-for="product in products"
				:key="product.id"
			>
				<el-card class="my_el_card">
						<el-image
							class="goods_img"
							fit="cover"
							:src=product.src
						></el-image>
					<div class="goods_desc_container">
						<div class="goods_name">商品名称</div>
						<div class="bottom clearfix">
							<time class="time">商品上架时间</time>
							<el-button
								type="text"
								class="button"
							>查看详情</el-button>
						</div>
					</div>
				</el-card>
			</el-col>
		</el-row>
	</div>

</template>

<script>
	export default {
		name: "HomeVIew",
		data() {
			return {
				items: [
					{
						id: 1,
						src: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
					},
					{
						id: 2,
						src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
					},
					{
						id: 3,
						src: "https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
					},
				],
				products: [
					{
						id: 1,
						src: "https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
						name: "Product 1",
					},
					{
						id: 2,
						src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
						name: "Product 2",
					},
					{
						id: 3,
						src: "http://via.placeholder.com/150x150",
						name: "Product 3",
					},
					{
						id: 4,
						src: "http://via.placeholder.com/150x150",
						name: "Product 4",
					}
				],
			};
		},
	};
</script>

<style scoped>

	#user_home {
		width: 100%;
		margin: 0 auto;
	}


	.bottom {
		margin-top: 10px;
		line-height: 12px;
	}


	.clearfix:before,
	.clearfix:after {
		display: table;
		content: "";
	}

	.clearfix:after {
		clear: both;
	}

	.my_el_card {
		width: 95%;
		margin: 0 auto;
		height: 300px;
	}

	.banner_iamger {
		width: 100%;
		height: 100%;
	}

	.goods_img {
		width: 100%;
		height: 200px;
	}

	.goods_desc_container {
		padding: 0px;
		height: 70px;
		margin-top: 10px;
	}

	.goods_name {
		height: 30%;
	}

	.time {
		font-size: 13px;
		color: #999;
		float: left;
	}
	
	.button {
		padding: 0;
		float: right;
	}
</style>