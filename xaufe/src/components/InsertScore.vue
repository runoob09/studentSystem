<template>
  <div class="dialog-container">
    <el-button type="primary"
               @click="dialogVisible = true">添加</el-button>

    <el-dialog title="修改学生信息"
               :visible.sync="dialogVisible"
               width="30%"
               :destroy-on-close="true"
               :modal="false">
      <el-form :model="form"
               label-width="100px">
        <el-row>
          <el-col :span="18">
            <el-form-item label="学号">
              <el-input v-model="form.id"></el-input>
            </el-form-item>
            <el-form-item label="科目">
              <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="成绩">
              <el-input v-model="form.score"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <span slot="footer"
            class="dialog-footer">
        <el-button @click="submit">提交</el-button>
        <el-button type="primary"
                   @click="dialogVisible = false">关闭</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data () {
    return {
      dialogVisible: false,
      form: {
        id: "",
        name: "",
        score: ""
      }
    };
  },
  methods: {
    submit () {
      this.$axios({
        method: "post",
        url: "http://localhost:8080/score",
        data: {
          id: this.form.id,
          name: this.form.name,
          score: this.form.score
        }
      }).then(res => {
        this.get()
        this.dialogVisible = false
        this.$message({
          type: res.data.code === 200 ? "success" : "warning",
          message: res.data.message
        })
      })
    }
  },
  props: ["data", "get"],
  mounted () {
    Object.keys(this.form).forEach(item => {
      this.form[item] = this.data[item]
    })
  }
};
</script>
<style>
</style>