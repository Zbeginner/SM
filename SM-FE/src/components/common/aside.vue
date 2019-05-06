<template>
  <el-menu :default-openeds="['1','2', '3']">
    <el-submenu index="1">
      <template slot="title"><i class="el-icon-menu"></i>成绩管理</template>

      <el-menu-item index="1-1" @click="toOtherMain('/search')">查询</el-menu-item>
      <el-menu-item index="1-2" @click="toOtherMain('/modify')">修改</el-menu-item>
      <el-menu-item index="1-3" @click="toOtherMain('/add')">添加</el-menu-item>
    </el-submenu>
    <el-submenu index="2">
      <template slot="title"><i class="el-icon-menu"></i>课程管理</template>
      <el-menu-item index="2-1" @click="toOtherMain('/cm')">添加课程</el-menu-item>
      <el-menu-item index="2-3"@click="toOtherMain('/cd')">管理课程</el-menu-item>
    </el-submenu>
    <el-submenu index="3">
      <template slot="title"><i class="el-icon-menu"></i>用户管理</template>
      <el-menu-item index="3-1">添加用户</el-menu-item>
      <el-menu-item index="3-2">修改密码</el-menu-item>
      <el-menu-item index="3-3">更改权限</el-menu-item>
    </el-submenu>
  </el-menu>

</template>

<script>
  export default {
    name: "aside",
    methods: {
      toOtherMain(pathValue) {
        this.$router.push({
          path: pathValue
        })
      }
    }
  }
</script>

<style scoped>

</style>
