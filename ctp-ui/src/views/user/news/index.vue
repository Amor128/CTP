<template>
  <div id="news_layout">
    <el-card class="news_container">
        <el-skeleton animated :loading="this.loading">
            <template slot="template">
                <div style="padding: 14px;">
                    <el-skeleton-item variant="h1" style="width: 50%" />
                    <el-skeleton-item variant="text" style="width:100%" />
                    <el-skeleton-item variant="text" style="width:100%" />
                    <el-skeleton-item variant="text" style="width:100%" />
                    <el-skeleton-item variant="text" style="width: 30%;" />
                </div>
            </template>
        </el-skeleton>

        <div>
            <h1>文章标题</h1>
        </div>
        <el-divider></el-divider>
        <div>内容</div>
        <div>日期</div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "NewsView",

  data() {
    return {
      loading: false
    }
  },

  methods: {
  }


}
</script>

<style>
#news_layout {
    width: 70%;
    margin: 0 auto;
}


</style>