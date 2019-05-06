<template>
  <div class="addMain">
    <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
      <el-form-item label="姓名">
        <el-input v-model="formLabelAlign.name"></el-input>
      </el-form-item>
      <el-form-item label="学号">
        <el-input v-model="formLabelAlign.num"></el-input>
      </el-form-item>
      <el-form-item label="课程">
        <el-select v-model="formLabelAlign.courid" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.name"
            :label="item.name"
            :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="成绩">
        <el-input v-model="formLabelAlign.grade"></el-input>
      </el-form-item>

      <el-button type="primary" @click="add">确 定</el-button>
    </el-form>
  </div>
</template>

<script>
  import Link from "@/api/garde"
  import Cour from "@/api/course"
  export default {
    name: "add",
    data() {
      return {
        labelPosition: 'right',
        formLabelAlign: {
          name: '',
          grade: '',
          num: '',
          courid: ''
        },
        options: [
          {
            id: '1',
            name: '大物'
          }, {
            id: '2',
            name: '离散数学  '
          },
        ],
      }
    },
    methods: {
      open(val) {
        this.$alert(val, '提示', {
          confirmButtonText: '确定',
          // center:true
        })
      },
      add() {
        let that = this;
        var judge = /^[\u4e00-\u9fa5]{2,4}$/;
        if (!judge.test(that.formLabelAlign.name)) {
          that.open('姓名需要全中文');
          return;
        }
        var num=/^20[0-9]{9}$/
        if(!num.test(that.formLabelAlign.num)){
          that.open('学号有问题');
          return;
        }
        var grade=/^[0-9]{1,2}(\.[05])?$/
        if(!grade.test(that.formLabelAlign.grade)){
          that.open('成绩有问题');
          return;
        }
        Link.add(that.formLabelAlign).then(function (resp) {
          if(resp.data.code==200){
            that.$message({
              message:'添加成功',
              type:'success'
            });
          }else if(resp.data.code==400){
            alert("学号或姓名错误！反正没对上号！");
            return;
          }
          else if(resp.data.code==402){
            alert("重复添加！");
            return;
          }
          else {
            that.$message.error('添加失败,肯定有什么乱搞了!');
          }
        })
      }
    },
    mounted() {
      let that=this
      Cour.getlist().then(function (resp) {
        console.log(resp.data.date)
        that.options=resp.data.date
      })
    }
  }
</script>

<style scoped>
  .el-button {
    float: right;
  }

  .el-form {
    margin-top: 20px;
  }

  .addMain {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }

  .el-input {
    width: 100%;
  }
</style>
