import Vue from "vue"
import VueRouter from "vue-router"
import Login from "@/page/Login"
import Home from "@/page/Home"
import Student from "@/components/Student"
import Score from "@/components/Score"
Vue.use(VueRouter)
export default new VueRouter({
  routes:[
    {
      path:"/",
      component:Login,
      name:"login"
    },{
      path:"/home",
      component:Home,
      name:"home",
      children:[
        {
          path:"student",
          component:Student
        },{
          path:"score",
          component:Score
        }
      ]
    }
  ]
})