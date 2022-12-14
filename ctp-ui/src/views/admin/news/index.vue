<template>
	<div>
		<div>
			<div style=" margin:10px auto; text-align: right;">
				<el-button
					type="success"
					@click="dialogFormVisible=true"
				>发布新闻</el-button>
			</div>
			<el-table
				:data="newsList"
				style="width: 100%"
			>
				<el-table-column
					label="发表时间"
					width="200"
				>
					<template slot-scope="scope">
						<i class="el-icon-time"></i>
						<span style="margin-left: 10px">{{ scope.row.createTime }}</span>
					</template>
				</el-table-column>
				<el-table-column
					label="ID"
					width="100"
				>
					<template slot-scope="scope">
						<el-tag size="medium">{{ scope.row.id }}</el-tag>
					</template>
				</el-table-column>
				<el-table-column
					label="优先级"
					width="200"
				>
					<template slot-scope="scope">
						<el-input-number
							size="mini"
							v-model="scope.row.sort"
						></el-input-number>
					</template>
				</el-table-column>
				<el-table-column
					label="标题"
					width="180"
				>
					<template slot-scope="scope">
						<el-tag size="medium">{{ scope.row.title }}</el-tag>
					</template>
				</el-table-column>

				<el-table-column
					label="操作"
					width="120"
				>
					<template slot-scope="scope">
						<el-button
							size="mini"
							type="success"
							@click="handleEdit(scope.row)"
						>确认修改</el-button>
					</template>
				</el-table-column>

				<el-table-column
					label="删除"
					width="120"
				>
					<template slot-scope="scope">
						<el-button
							size="mini"
							type="danger"
							@click="handleDelete(scope.row)"
						>删除</el-button>
					</template>
				</el-table-column>
			</el-table>

			<el-dialog
				title="发表新闻"
				:visible.sync="dialogFormVisible"
			>
				<el-form :model="newsForm">
					<el-form-item label="标题">
						<el-input
							v-model="newsForm.title"
							autocomplete="off"
						></el-input>
					</el-form-item>

					<el-form-item label="内容">
						<el-input
							v-model="newsForm.content"
							autocomplete="off"
							type="textarea"
						></el-input>
					</el-form-item>

				</el-form>
				<div
					slot="footer"
					class="dialog-footer"
				>
					<el-button @click="dialogFormVisible = false">取 消</el-button>
					<el-button
						type="primary"
						@click="handlePubNews"
					>确 定</el-button>
				</div>
			</el-dialog>
		</div>
	</div>

</template>

<script>
	import { insertNews, listNews, updateNews, removeNews } from "@/api/news";
	export default {
		name: "adminNewsView",
		data() {
			return {
				dialogFormVisible: false,
				newsForm: {},
				newsList: [],
			};
		},
		methods: {
			fechNewsList() {
				listNews()
					.then((res) => {
						this.newsList = res.data;
					})
					.catch();
			},
			handlePubNews() {
				let data = {};
				Object.assign(data, this.newsForm);
				insertNews(data)
					.then((res) => {
						this.$notify.success(res.message);
						this.dialogFormVisible = false;
						this.fechNewsList();
						this.newsForm.title = "";
						this.newsForm.content = "";
					})
					.catch();
			},
			handleEdit(news) {
				let data = {};
				data.id = news.id;
				data.sort = news.sort;
				updateNews(data)
					.then((res) => {
						this.$notify.success(res.message);
					})
					.catch();
			},
			handleDelete(news) {
				removeNews(news.id)
					.then((res) => {
						this.$notify.success(res.message);
						this.fechNewsList();
					})
					.catch();
			},
		},
		created() {
			this.fechNewsList();
		},
	};
</script>

<style>
</style>