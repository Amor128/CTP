<template>
	<el-table
		:data="tableData"
		style="width: 100%"
	>
		<el-table-column
			label="注册时间"
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
			label="昵称"
			width="180"
		>
			<template slot-scope="scope">
				<el-tag size="medium">{{ scope.row.name }}</el-tag>
			</template>
		</el-table-column>

		<el-table-column label="新密码">
			<template slot-scope="scope">
				<el-input
					v-model="scope.row.password"
					placeholder="请输入新密码"
				></el-input>
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
					@click="handleEdit(scope.$index, scope.row)"
				>确认修改</el-button>
			</template>
		</el-table-column>

		<el-table-column label="冻结">
			<template slot-scope="scope">
				<el-button
					size="mini"
					type="primary"
					@click="handleEdit(scope.$index, scope.row)"
				>冻结</el-button>
			</template>
		</el-table-column>
	</el-table>
</template>

<script>
	export default {
		name: "adminUserView",
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