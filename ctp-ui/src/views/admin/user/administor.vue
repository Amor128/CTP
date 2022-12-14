<template>
	<div>
		<div>
			<div style=" margin:10px auto; text-align: right;">
				<el-button type="success" @click="dialogFormVisible=true">创建管理员</el-button>
			</div>
			<el-table
				:data="tableData"
				style="width: 100%"
			>
				<el-table-column
					label="创建时间"
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
					label="帐号"
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

			<el-dialog
				title="新管理员"
				:visible.sync="dialogFormVisible"
			>
				<el-form :model="form">
					<el-form-item
						label="帐号"
						:label-width="formLabelWidth"
					>
						<el-input
							v-model="form.name"
							autocomplete="off"
						></el-input>
					</el-form-item>

          <el-form-item
						label="密码"
						:label-width="formLabelWidth"
					>
						<el-input
							v-model="form.name"
							autocomplete="off"
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
						@click="dialogFormVisible = false"
					>确 定</el-button>
				</div>
			</el-dialog>
		</div>
	</div>

</template>

<script>
	export default {
		name: "administorView",
		data() {
			return {
        dialogFormVisible: false,
        form: {},
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
	};
</script>

<style>
</style>