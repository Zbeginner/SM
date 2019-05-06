<template>
  <div class="cd">
    <el-table
      :data="course"
      border>
      <el-table-column
        prop="name"
        label="课程名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="tname"
        label="老师"
        width="180">
      </el-table-column>
      <el-table-column
        prop="score"
        label="学分"
        width="180">
      </el-table-column>
      <el-table-column>
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handle1(scope.$index, scope.row)">编辑
          </el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handle2(scope.$index, scope.row)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog
      title="修改课程信息"
      :visible.sync="dialogVisible"
      width="30%">
      <el-form class="form">
        <el-form-item class="formItem" label-width="labelWidth" label="课程名">
          {{selectedCourse.name}}
        </el-form-item>
        <el-form-item class="formItem" label-width="labelWidth" label="老师">
          <el-select v-model="selectedCourse.tid" placeholder="请选择要修改的老师">
            <el-option
              v-for="item in teacher"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item class="formItem" label-width="labelWidth" label="学分">
          {{selectedCourse.score}}
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="modifyCourse" >确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import CourLink from '@/api/course'
  import TeacherLink from '@/api/teacher'

  export default {
    name: "CourDelete",
    data() {
      return {
        dialogVisible:false,
        labelWidth:'100px',
        course: [],
        selectedCourse: {
          name: '',
          tid: '',
          score: ''
        },
        teacher:[]
      }
    },
    methods: {
      modifyCourse(){
        let that=this;
        CourLink.modify(this.selectedCourse.cid,this.selectedCourse.tid).then(function (resp) {
          if(resp.data.code==200){
            that.$message({
              type: 'success',
              message: '修改成功!'
            });
          }else{
            that.$message({
              type: 'warning',
              message: '修改失败!'
            });
          }
          that.dialogVisible=false;
        })
      },
      getTeacher(){
        let that=this;
        TeacherLink.getlist().then(function(resp){
          that.teacher=resp.data.date;
        })
      },
      handle1(index, row) {
        this.selectedCourse = row;
        this.dialogVisible=true;
      },
      handle2(index, row) {
        let that = this;
        CourLink.delete(row.cid).then(function (resp) {
          console.log(resp)
          if (resp.data.code == 200) {
            that.$message({
              type: 'success',
              message: '删除成功!'
            });
          } else {
            that.$message({
              type: 'warning',
              message: '删除失败!'
            });
          }
        })

      }
    },
    mounted() {
      this.getTeacher();
      let that = this
      CourLink.getTeaCourInfo().then(function (resp) {
        var item = resp.data.date;
        for (var i = 0; i < item.length; i++) {
          var temp = {
            cid: '',
            name: '',
            tname: '',
            score: ''
          }

          temp.cid = item[i].course.id;
          temp.name = item[i].course.name;
          if (item[i].teacher != null) {
            temp.tname = item[i].teacher.name;
          } else {
            temp.tname = '';
          }
          temp.score = item[i].course.score;
          that.course.push(temp);
        }
      })
    }
  }
</script>

<style scoped>
  .cd {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    height: 100%;
    width: 100%;
  }
  .el-input{
    width: 200px;
  }
  .form{
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
  }
  .formItem{
    width: 100%;
    height: 30%;
  }

</style>
