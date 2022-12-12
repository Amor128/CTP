<template>
	<el-container>
		<el-aside width="200px">
			<el-tree
				:data="categoryList"
				:props="defaultProps"
				@node-click="handleCategoryClick"
			></el-tree>
		</el-aside>
		<el-container style="width:70%; margin:0 auto">
			<el-header style="padding-left:20%">
				<el-input
					placeholder="请输入商品名称"
					v-model="searchGoodsName"
					class="search_bar"
				>
					<el-button
						slot="append"
						icon="el-icon-search"
                        @click="handleSearchGoods"
					></el-button>
				</el-input>
			</el-header>
			<el-main>
				<el-row>
					<el-col
						:span="8"
						v-for="goods in goodsList"
						:key="goods.id"
					>
						<el-card class="goods_container">
							<el-image
								class="goods_img"
								fit="fill"
								:src="goods.photo"
							></el-image>
							<div class="goods_desc_container">
								<div class="goods_name">{{goods.name}}</div>
								<div class="bottom clearfix">
									<time class="time">{{goods.createTime}}</time>
									<el-button
										type="text"
										class="button"
										@click="handleGoodsDetail(goods.id)"
									>查看详情</el-button>
								</div>
							</div>
						</el-card>
					</el-col>
				</el-row>
				<div
					v-if="goodsList.length > 0"
					class="page_container"
				>
					<el-pagination
						style="margin: 0 auto"
						background
						layout="prev, pager, next"
						@current-change="handlePageChange"
						:page-size="pageParam.perPage"
						:current-page.sync="pageParam.page"
						:total="pageParam.total"
					>
					</el-pagination>
				</div>
			</el-main>
		</el-container>
	</el-container>
</template>

<script>
	import { listCategories } from "@/api/category";
	import { getGoodsPage } from "@/api/goods";
	import { deleteEmptyArray, copySameAttribute, photo2Url } from "@/utils";
	export default {
		name: "GoodsSearchView",
		data() {
			return {
                searchGoodsName: '',
				categoryList: [],
				defaultProps: {
					children: "children",
					label: "name",
				},
				goodsList: [],
				pageParam: {
					perPage: 6,
					total: 30,
					page: 1,
				},
                defaultPageParam: {
					perPage: 6,
					page: 1,
					total: 0,
				},
				pageHelper: {
					flag: 2,	// 0 代表根据类型分页，1 代表根据名称分页
					category: '',
					name: ''
				}
			};
		},
		methods: {
			handleGoodsDetail(goodsID) {
				this.$router.push({name: 'userGoodsDetail', params: {goodsID}})
			},

			fechCategoryList() {
				console.log("fech");
				listCategories()
					.then((res) => {
						for (let i = 0; i < res.data.length; i++)
							deleteEmptyArray(res.data[i]);
						console.log(res);
						this.categoryList = res.data;
					})
					.catch();
			},

            handleCategoryClick(node) {
                if (node.children == null) {
					// 重置分页参数
					Object.assign(this.pageParam, this.defaultPageParam)
					this.pageHelper.flag = 0
					this.pageHelper.category = node.id

                    // 分页查找发送
					let params = {}
					Object.assign(params, this.pageParam)
					params.category = node.id
					delete params.total
					this.fetchGoodsPage(params)
                }
            },

            handleSearchGoods() {
				// 重置分页参数
				Object.assign(this.pageParam, this.defaultPageParam)

				this.pageHelper.flag = 1
				this.pageHelper.name = this.searchGoodsName

				// 分页查找发送
				let params = {}
				Object.assign(params, this.pageParam)
				params.name = this.searchGoodsName
				delete params.total
				this.fetchGoodsPage(params)
            },

			handlePageChange() {
				let params = {}
				Object.assign(params, this.pageParam)
				delete params.total
				if (this.pageHelper.flag == 0) {
					// category
					params.category = this.pageHelper.category
				} else if (this.pageHelper.flag == 1) {
					// name
					params.name = this.pageHelper.name
				}
				this.fetchGoodsPage(params)
			},

			fetchGoodsPage(params) {
				getGoodsPage(params).then(res => {
					this.goodsList = res.data.list;
					for (let i = 0; i < res.data.list.length; i++) {
						res.data.list[i].photo = photo2Url(res.data.list[i].photo)
					}
					copySameAttribute(this.pageParam, res.data)
				}).catch()
			}
		},

        created() {
            this.fechCategoryList()
        }
	};
</script>

<style>
	.search_bar {
		width: 75%;
	}

	.goods_container {
		width: 280px;
		height: 300px;
		margin-top: 10px;
	}

	.goods_desc_container {
		padding: 0px;
		height: 60px;
		margin-top: 10px;
	}

	.goods_name {
		height: 30%;
		overflow-inline: hidden;
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

	.goods_img {
		width: 240px;
		height: 210px;
	}

	.page_container {
		margin-top: 10px;
		width: 100%;
		text-align: center;
	}
</style>