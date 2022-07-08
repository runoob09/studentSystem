<template>
  <el-form :model="form"
           label-width="100px"
           ref="myForm">
    <el-col :span="6">
      <el-form-item label="用户名">
        <el-input v-model="form.username"
                  placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input type="password"
                  v-model="form.password"
                  placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item label="验证码">
        <el-input style="width:150px" v-model="form.code"></el-input>
        <el-image src="http://localhost:8080/code"></el-image>
      </el-form-item>
      <el-form-item>
        <el-button type="primary"
                   @click="login">登录</el-button>
        <el-button type="warning"
                   @click="reset">重置</el-button>
      </el-form-item>
    </el-col>
  </el-form>
</template>

<script>
export default {
  name: "Login",
  data () {
    return {
      form: {
        username: "",
        password: "",
        code:""
      }
    }
  }, methods: {
    reset () {
      Object.keys(this.form).forEach(item => {
        this.form[item] = ""
      })
    },
    login () {
      this.$axios({
        method: "post",
        url: "http://localhost:8080/user",
        data: {
          username: this.form.username,
          password: this.form.password,
          code: this.form.code
        }
      }).then(res => {
        if (res.data.code == 200) {
          this.$message({
            type: "success",
            message: res.data.message
          })
          this.$router.push({
            name: "home"
          })
        } else {
          this.$message({
            type: "warning",
            message: res.data.message
          })
        }
      }, err => {
        console.log(err.message);
      })
    }
  }, mounted () {
    this.$axios({
      method: 'get',
      url: "http://localhost:8080/user"
    }).then(res => {
      console.log(res.data.code);
      if (res.data.code == 200) {
        this.$router.push({
          name: "home"
        })
      }
    })
  }
}
</script>

<style>
</style>