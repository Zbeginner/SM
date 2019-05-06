<template>
  <div>
    <el-button class="button1" type="primary" @click="searchByNum">搜索</el-button>
    <el-input
      class="input1"
      placeholder="输入学号查询指定学生成绩"
      prefix-icon="el-icon-search"
      v-model="stuNum"
      @keyup.enter.native="searchByNum"
    >
    </el-input>
    <el-table
      :data="stuGrade"
      height="520"
      border
      style="width: 100%">
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="num"
        label="学号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="major"
        label="专业"
        width="180">
      </el-table-column>
      <el-table-column
        prop="cour"
        label="课程"
        width="180">
      </el-table-column>
      <el-table-column
        prop="grade"
        label="成绩"
        width="180">
      </el-table-column>
      <el-table-column
        prop="teacher"
        label="老师"
      >
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import Link from '@/api/garde'

  export default {
    name: "StuGradeTab",

    data() {
      return {
        test: 'zzz',
        stuNum: '',
        stuGrade: [
        ],
      }
    },
    mounted() {
      this.addInfo()
    },
    methods: {
      addInfo() {
        let that = this;
        Link.getinfo().then(function (resp) {
          that.stuGrade = resp.data.date;
        })
      },
      searchByNum() {
        let that = this;
        Link.searchByNum(that.stuNum).then(function (resp) {
          if (resp.data.code == 200) {
            that.stuGrade = resp.data.date;
          } else{
            alert("输入的学号应该是出错了。");
          }
        })
      }
    }
  }
</script>

<style scoped>
  .input1 {
    float: right;
    width: 300px;
    margin-bottom: 10px;
    margin-right: 5px;
  }

  .button1 {
    float: right;
    margin-bottom: 10px;
  }
</style>
