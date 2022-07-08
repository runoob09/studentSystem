<template>
  <div class="dialog-container">
    <el-button type="text"
               @click="dialogVisible = true">修改</el-button>

    <el-dialog title="修改学生信息"
               :visible.sync="dialogVisible"
               width="30%"
               :destroy-on-close="true"
               :modal="false">
      <el-form :model="form"
               label-width="100px">
        <el-row>
          <el-col :span="18">
            <el-form-item label="姓名">
              <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="年龄">
              <el-input v-model="form.age"></el-input>
            </el-form-item>
            <el-form-item label="年级">
              <el-input v-model="form.grade"></el-input>
            </el-form-item>
            <el-form-item label="专业">
              <el-input v-model="form.object"></el-input>
            </el-form-item>
            <el-form-item label="民族">
              <el-input v-model="form.ethnic"></el-input>
            </el-form-item>
            <el-form-item label="家庭住址">
              <el-input v-model="form.address"></el-input>
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
        age: "",
        grade: "",
        object: "",
        ethnic: "",
        address: "",
      }
    };
  },
  methods: {
    submit () {
      this.$axios({
        method: "put",
        url: "http://localhost:8080/students",
        data: {
          id: this.form.id,
          name: this.form.name,
          age: this.form.age,
          grade: this.form.grade,
          object: this.form.object,
          ethnic: this.form.ethnic,
          address: this.form.address,
        }
      }).then(res=>{
        this.get()
        this.dialogVisible=false
        this.$message({
          type:res.data.code===200?"success":"warning",
          message:res.data.message
        })
      })
    }
  },
  props: ["data","get"],
  mounted () {
    Object.keys(this.form).forEach(item => {
      this.form[item] = this.data[item]
    })
  }
};
</script>
<style>
</style>