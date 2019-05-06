<template>
  <div class="cm">
    <el-form :label-position="labelPosition" label-width="80px" :model="course">
      <el-form-item label="课程名">
        <el-input v-model="course.name"></el-input>
      </el-form-item>
      <el-form-item label="学分">
        <el-input v-model="course.score"></el-input>
      </el-form-item>
      <el-form-item label="老师">
        <el-select v-model="course.id" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.name"
            :label="item.name"
            :value="item.id"
          >
          </el-option>
        </el-select>
      </el-form-item>
      <el-button style="float: right;" type="primary" @click="add">确 定</el-button>
    </el-form>
  </div>
</template>

<script>
  import TeacheLink from '@/api/teacher'
  import CourLink from '@/api/course'

  export default {
    name: "CourManager",
    data() {
      return {
        labelPosition:'right',
        course: {
          name: '',
          score: '',
          id: ''
        },
        options: [],
      }
    },
    mounted() {
      let that = this;
      TeacheLink.getlist().then(function (resp) {
        that.options = resp.data.date;
      })
    },
    methods: {
      add() {
        let that = this;
        if (that.course.score == '' || that.course.name == '' || that.course.id == '') {
          alert("有信息没填呢...  ")
        }
        var judge=/^[1-9]$/;
        if(!judge.test(that.course.score)){
          alert("学分格式错误")
          return;
        }
        CourLink.add(that.course).then(function (resp) {

        })
      }
    }
  }
</script>

<style scoped>
  .cm {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
  }

  .el-input {
    width: 230px;
  }
</style>
