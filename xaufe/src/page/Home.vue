<template>
  <el-container style="height:100%">
    <el-aside class=".el-aside">
      <el-menu class="el-menu-vertical-demo"
               style="height:100%"
               :router="true"
               >
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>学生管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/home/student">学生信息管理</el-menu-item>
            <el-menu-item index="/home/score">学生成绩管理</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-menu-item index="/home">
          <i class="el-icon-menu"></i>
          <span slot="title">用户管理</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: "Home",
  data () {
    return {
      router: {
        student: {
          path: "/home/student"
        }, score: {
          path: "/home/score"
        }
      }
    }
  }
}
</script>

<style>
.el-aside {
  height: 100%;
}
</style>