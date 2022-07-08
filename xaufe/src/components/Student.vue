<template>
  <div>
    <insert-student :get="get"></insert-student>
    <el-table :data="students"
              style="width: 100%"
              ref="table">
      <el-table-column fixed
                       prop="id"
                       label="学号">
      </el-table-column>
      <el-table-column prop="name"
                       label="姓名">
      </el-table-column>
      <el-table-column prop="age"
                       label="年龄"
                       :sortable="true">
      </el-table-column>
      <el-table-column prop="grade"
                       label="年级">
      </el-table-column>
      <el-table-column prop="object"
                       label="专业">
      </el-table-column>
      <el-table-column prop="ethnic"
                       label="民族">
      </el-table-column>
      <el-table-column prop="address"
                       label="家庭住址">
      </el-table-column>
      <el-table-column fixed="right"
                       label="操作"
                       width="100">
        <template slot-scope="scope">
          <UpdataStudent :data="scope.row" :get="get"></UpdataStudent>
          <el-button type="text"
                     style="color:#F56C6C"
                     @click="deleteStudent(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import UpdataStudent from '@/components/UpdataStudent.vue';
import InsertStudent from './InsertStudent.vue';
export default {
  name: "Student",
  components:{
    UpdataStudent,InsertStudent
  },
  data () {
    return {
      students: [],
      num: 0
    }
  }, mounted () {
    this.get()
  }, methods: {
    deleteStudent (id) {
      this.$axios({
        method: "delete",
        url: "http://localhost:8080/students",
        data: {
          id
        }
      }).then(res => {
        this.$message({
          type: res.data.code === 200 ? "success" : "warning",
          message: res.data.message
        })
        this.get()
      })
    }, get () {
      this.$axios({
        methods: "get",
        url: "http://localhost:8080/students"
      }).then(res => {
        this.students=[]
        res.data.data.forEach(item => {
          this.students.push(item)
        })
      })
    }
  }
}
</script>

<style>
</style>