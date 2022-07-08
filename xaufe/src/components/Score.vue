<template>
  <div>
    <insert-score :get="get"></insert-score>
    <el-table :data="score"
              style="width: 100%"
              :key="Math.random()">
      <el-table-column prop="id"
                       label="学号">
      </el-table-column>
      <el-table-column prop="name"
                       label="科目">
      </el-table-column>
      <el-table-column prop="score"
                       label="成绩">
      </el-table-column>
      <el-table-column fixed="right"
                       label="操作">
        <template slot-scope="scope">
          <updata-score :data="scope.row" :get="get"></updata-score>
          <el-button type="text"
                     style="color:#F56C6C" @click="deleteScore(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import UpdataScore from '@/components/UpdataScore.vue'
import InsertScore from './InsertScore.vue'
export default {
  components: { UpdataScore ,InsertScore},
  name: "Score",
  data () {
    return {
      score: []
    }
  }, mounted () {
    this.get()
  }, methods: {
    get () {
      this.$axios({
        methods: "get",
        url: "http://localhost:8080/score"
      }).then(res => {
        this.score=[]
        res.data.data.forEach(item => {
          this.score.push(item)
        })
      })
    },deleteScore(id){
      this.$axios({
        method: "delete",
        url: "http://localhost:8080/score",
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
    }
  }
}
</script>

<style>
</style>