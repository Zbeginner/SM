<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246);height: 100%">
      <router-view name="aside"/>
    </el-aside>
    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <span class="index" @click="toIndex">首页</span>
        <router-view name="header"/>
      </el-header>
      <el-main style="height:100%">
        <router-view name="main"/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import StuGradeTab from "@/components/stuGradeTab";

  export default {
    components: {StuGradeTab},
    data() {
      return {
      }
    },
    methods: {
      toIndex() {
        let that=this;
        that.$router.push({
          path: "/index",
          query:{
            name:that.name,
            id:that.id
          }
        })
      }
    }
  }
</script>

<style scoped>

  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 80px;
  }

  .el-aside {
    color: #333;
  }

  .index {
    float: left;
    font-size: 20px;

  }
</style>
