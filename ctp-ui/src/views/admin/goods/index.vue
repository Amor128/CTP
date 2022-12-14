<template>
	<el-table
		:data="tableData"
		style="width: 100%"
	>
		<el-table-column label="商品图片" width="120">
			<el-image
				style="width: 88px; height: 88px"
				src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"
				fit="fill"
			></el-image>
		</el-table-column>
		<el-table-column
			label="发布时间"
			width="200"
		>
			<template slot-scope="scope">
				<i class="el-icon-time"></i>
				<span style="margin-left: 10px">{{ scope.row.date }}</span>
			</template>
		</el-table-column>
		<el-table-column
			label="ID"
			width="100"
		>
			<template slot-scope="scope">
				<el-tag size="medium">{{ scope.row.name }}</el-tag>
			</template>
		</el-table-column>
		<el-table-column
			label="商品名称"
			width="180"
		>
			<template slot-scope="scope">
				<el-tag size="medium">{{ scope.row.name }}</el-tag>
			</template>
		</el-table-column>

        <el-table-column
			label="商品描述"
			width="200"
		>
			<template slot-scope="scope">
				<span>{{ scope.row.date }}</span>
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
					@click="handleEdit(scope.$index, scope.row)"
				>下架</el-button>
			</template>
		</el-table-column>
	</el-table>
</template>

<script>
	export default {
		name: "adminGoodsView",
		data() {
			return {
				tableData: [
					{
						date: "2016-05-02",
						name: "王小虎",
						address: "上海市普陀区金沙江路 1518 弄",
					},
					{
						date: "2016-05-04",
						name: "王小虎",
						address: "上海市普陀区金沙江路 1517 弄",
					},
					{
						date: "2016-05-01",
						name: "王小虎",
						address: "上海市普陀区金沙江路 1519 弄",
					},
					{
						date: "2016-05-03",
						name: "王小虎",
						address: "上海市普陀区金沙江路 1516 弄",
					},
				],
			};
		},
		methods: {
			handleEdit(index, row) {
				console.log(index, row);
			},
			handleDelete(index, row) {
				console.log(index, row);
			},
		},
	};
</script>

<style>
</style>