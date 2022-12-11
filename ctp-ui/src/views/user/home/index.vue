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
						:src=product.photo
					></el-image>
					<div class="goods_desc_container">
						<div class="goods_name">{{product.name}}</div>
						<div class="bottom clearfix">
							<time class="time">{{product.createTime}}</time>
							<el-button
								type="text"
								class="button"
								@click="handleGoodsDetail(product.id)"
							>查看详情</el-button>
						</div>
					</div>
				</el-card>
			</el-col>
		</el-row>
	</div>

</template>

<script>
	import { listHomeGoods } from "@/api/goods";
	import { photo2Url } from "@/utils"

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
				products: [],
			};
		},

		methods: {
			freshRecommendGoodsList() {
				listHomeGoods()
					.then((res) => {
						console.log(res);
						for (let i = 0; i < res.data.length; i++) {
							res.data[i].photo = photo2Url(res.data[i].photo)
						}
						this.products = res.data;
					})
					.catch();
			},

			handleGoodsDetail(goodsID) {
				console.log(goodsID)
				this.$router.push({name: "userGoodsDetail", params: { goodsID }})
			}
		},

		created() {
			this.freshRecommendGoodsList();
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