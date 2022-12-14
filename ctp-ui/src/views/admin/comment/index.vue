<template>
	<el-table
		:data="commentList"
		style="width: 100%"
	>
		<el-table-column
			label="评论时间"
			width="200"
		>
			<template slot-scope="scope">
				<i class="el-icon-time"></i>
				<span style="margin-left: 10px">{{ scope.row.createTime }}</span>
			</template>
		</el-table-column>
		<el-table-column
			label="回复内容"
			width="120"
		>
			<template slot-scope="scope">
				{{ scope.row.replyTo }}
			</template>
		</el-table-column>
		<el-table-column
			label="评论者"
			width="140"
		>
			<template slot-scope="scope">
				<el-tag size="medium">{{ scope.row.nickname }}</el-tag>
			</template>
		</el-table-column>

		<el-table-column
			label="评论内容"
			width="200"
		>
			<template slot-scope="scope">
				<span>{{ scope.row.content }}</span>
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

import {adminListComments, removeComment} from '@/api/comment'
	export default {
		name: "adminCommentView",
		data() {
			return {
				commentList: [],
			};
		},
		methods: {
			fetchCommentList() {
				adminListComments().then(res => {
					this.commentList = res.data
				}).catch()
			},
			handleDelete(row) {
				removeComment(row.id).then(res => {
					this.$notify.success(res.message)
					this.fetchCommentList()
				}).catch()
			},
		},

		created() {
			this.fetchCommentList()
		}
	};
</script>

<style>
</style>