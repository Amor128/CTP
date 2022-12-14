<template>
	<el-table
		:data="wantList"
		style="width: 100%"
	>
		<el-table-column
			label="发布时间"
			width="200"
		>
			<template slot-scope="scope">
				<i class="el-icon-time"></i>
				<span style="margin-left: 10px">{{ scope.row.createTime }}</span>
			</template>
		</el-table-column>
		<el-table-column
			label="求购名称"
			width="140"
		>
			<template slot-scope="scope">
				<el-tag size="medium">{{ scope.row.name }}</el-tag>
			</template>
		</el-table-column>
		<el-table-column
			label="求购内容"
			width="120"
		>
			<template slot-scope="scope">
				{{ scope.row.content }}
			</template>
		</el-table-column>

		<el-table-column
			label="预期价格"
			width="200"
		>
			<template slot-scope="scope">
				<span>{{ scope.row.sellPrice }}</span>
			</template>
		</el-table-column>

		<el-table-column
			label="操作"
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
</template>

<script>
	import { lsitWant, removeWant } from "@/api/want";
	export default {
		name: "adminWant",
		data() {
			return {
				wantList: [],
			};
		},
		methods: {
			fetchWantList() {
				lsitWant()
					.then((res) => {
						this.wantList = res.data;
					})
					.catch();
			},
			handleDelete(want) {
				removeWant(want.id)
					.then((res) => {
						this.$notify.success(res.message);
						this.fetchWantList()
					})
					.catch();
			},
		},
		created() {
			this.fetchWantList();
		},
	};
</script>

<style>
</style>