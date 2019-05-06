<template>
    <el-dropdown>
      <i class="el-icon-setting" style="margin-right: 15px"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>查看</el-dropdown-item>
        <el-dropdown-item>新增</el-dropdown-item>
      </el-dropdown-menu>
      <span>{{name}}</span>
    </el-dropdown>
</template>

<script>
    export default {
      name: "header",
      data(){
          return{
            name:sessionStorage.account,
          }
      },
      mounted() {
      }
    }
</script>

<style scoped>

</style>
