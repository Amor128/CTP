<template>
    <div id="want_post_layout">
        <el-card class="form_container">
            <el-form ref="form" :model="form" label-width="100px">
                <el-form-item label="商品名称">
                <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="商品描述">
                <el-input type="textarea" v-model="form.content"></el-input>
                </el-form-item>
                <el-form-item label="期望价格">
                <el-input v-model="form.sellPrice"></el-input>
                </el-form-item>
                <el-form-item label="期望交易地点">
                <el-input v-model="form.transPlace"></el-input>
                </el-form-item>

                <el-form-item>
                <div class="post_button">
                    <el-button type="primary" @click="onSubmit">发布</el-button>
                    <el-button>清空</el-button>
                </div>
                </el-form-item>
            </el-form>
        </el-card>
    </div>
  
</template>

<script>
import { insertWant } from '@/api/want'
import { convertStringToNumber } from '@/utils'

export default {
    name: "GoodsWantPostView",
    data() {
        return {
            form: {
                name: '',
                content: '',
                sellPrice: '',
                transPlace: ''
            },
        }
    },
    computed: {
        userID() {return this.$store.getters.userID}
    },
    methods: {
        onSubmit() {
            this.form.userID = this.userID
            let data = {}
            Object.assign(data, this.form)
            convertStringToNumber(data)
            insertWant(data).then(res => {
                console.log(res)
            }).catch(err => console.log(err))
        },
    }

}
</script>

<style>
#want_post_layout {
    width: 70%;
    margin: 0 auto;
}

</style>