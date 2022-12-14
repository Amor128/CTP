<template>
	<div>
		<div>
			<div style=" margin:10px auto; text-align: right;">
				<el-button
					type="success"
					@click="dialogFormVisible=true"
				>增加分类</el-button>
			</div>
			<el-table
				:data="categoryList"
				style="width: 100%"
			>
				<el-table-column
					label="ID"
					width="100"
				>
					<template slot-scope="scope">
						<el-tag size="medium">{{ scope.row.id }}</el-tag>
					</template>
				</el-table-column>
				<el-table-column
					label="名称"
					width="200"
				>
					<template slot-scope="scope">
						<el-input
							size="mini"
							v-model="scope.row.name"
						></el-input>
					</template>
				</el-table-column>
				<el-table-column
					label="父类"
					width="180"
				>
					<template slot-scope="scope">
						<el-tag size="medium">{{ scope.row.parentID }}</el-tag>
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
			</el-table>

			<el-dialog
				title="增加分类"
				:visible.sync="dialogFormVisible"
			>
				<el-form :model="categoryForm">
					<el-form-item label="父类">
						<el-select
							v-model="categoryForm.parentID"
							placeholder="请选择"
						>
							<el-option
								v-for="(item,index) in parentCategoryList"
								:key="index"
								:label="item.name"
								:value="item.id"
							>
							</el-option>
						</el-select>
					</el-form-item>

					<el-form-item label="名称">
						<el-input
							v-model="categoryForm.name"
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
						@click="handleInserCategory"
					>确 定</el-button>
				</div>
			</el-dialog>
		</div>
	</div>

</template>

<script>
	import {
		adminListCategories,
		updateCategory,
		listParentCategories,
		insertCategory,
	} from "@/api/category";

	export default {
		name: "adminCategory",
		data() {
			return {
				dialogFormVisible: false,
				categoryForm: {},
				categoryList: [],
				parentCategoryList: [],
			};
		},
		methods: {
			fetchCategoryList() {
				adminListCategories()
					.then((res) => {
						this.categoryList = res.data;
					})
					.catch();
			},
			fetchParentCategoryList() {
				listParentCategories()
					.then((res) => {
						this.parentCategoryList = res.data;
					})
					.catch();
			},

			handleEdit(category) {
				let data = { id: "", name: "" };
				Object.assign(data, category);
				console.log(data);
				updateCategory(data)
					.then((res) => {
						this.$notify.success(res.message);
					})
					.catch();
			},
			handleInserCategory() {
				let data = { name: "" };
				Object.assign(data, this.categoryForm);
				insertCategory(data)
					.then((res) => {
						this.$notify.success(res.message);
                        this.dialogFormVisible = false;
                        this.fetchCategoryList()
                        this.fetchParentCategoryList()
                        this.categoryForm.parentID = null
                        this.categoryForm.name = null
					})
					.catch();
			},
		},
		created() {
			this.fetchCategoryList();
			this.fetchParentCategoryList();
		},
	};
</script>

<style>
</style>