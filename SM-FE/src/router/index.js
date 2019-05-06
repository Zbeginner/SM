import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/login'
import Index from '@/components/index'
import aside from '@/components/common/aside'
import header from '@/components/common/header'
import StuGradeTab from '@/components/stuGradeTab'
import modify from '@/components/GM/modify'
import hello from '@/components/Hello'
import gradeAdd from '@/components/GM/add'
import courManager from '@/components/CM/CourManager'
import courDelete from '@/components/CM/CourDelete'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/index',
      name: 'index',
      component: Index,
      children: [
        {
          path: '',
          components: {
            header: header,
            aside: aside,
            main: hello
          }
        }, {
          path: '/search',
          components: {
            header: header,
            aside: aside,
            main: StuGradeTab
          }
        }, {
          path: '/modify',
          components: {
            header: header,
            aside: aside,
            main: modify
          }
        }, {
          path: '/add',
          components: {
            header: header,
            aside: aside,
            main: gradeAdd
          }
        }, {
          path: '/cm',
          components: {
            header: header,
            aside: aside,
            main: courManager
          }
        }, {
          path: '/cd',
          components: {
            header: header,
            aside: aside,
            main: courDelete
          }
        },
      ]
    }
  ]
})
