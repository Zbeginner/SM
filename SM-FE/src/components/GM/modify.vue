<template>
  <div class="search">
    <el-input class="input"
              placeholder="输入要修改成绩的学生学号"
              prefix-icon="el-icon-search"
              v-model="stuNum"
    >
    </el-input>
    <el-button class="button" type="primary" @click="searchByNum">查询</el-button>
    <a class="zw"></a>
    <el-table
      :data="stuGrade"
      border
      height="500px"
      style="width: 100%"
    >
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
        label="老师">
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
      title="修改成绩"
      :visible.sync="dialogVisible"
      width="30%">
      <el-form>
        <el-form-item :label-width="labelWidth" label="姓名">
          {{modifInfo.name}}
        </el-form-item>
        <el-form-item :label-width="labelWidth" label="学号">
          {{modifInfo.num}}
        </el-form-item>
        <el-form-item :label-width="labelWidth" label="课程">
          {{modifInfo.className}}
        </el-form-item>
        <el-form-item :label-width="labelWidth" label="成绩">
          <el-input style="width: 180px" placeholder="输入要修改的成绩" v-model="modifInfo.grade"></el-input>
        </el-form-item>
        <el-button @click="dialogVisible=false">取 消</el-button>
        <el-button type="primary" @click="modfiy">确 定</el-button>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  import Link from '@/api/garde'

  export default {
    name: "modify",
    data() {
      return {
        stuNum: '',
        dialogVisible: false,
        stuGrade: [],
        labelWidth: '100px',
        modifInfo: {
          name: '',
          num: '',
          className: '',
          grade: ''
        }
      }
    },
    methods: {
      searchByNum() {
        let that = this;
        Link.searchByNum(that.stuNum).then(function (resp) {
          if(resp.data.code==200){
            that.stuGrade = resp.data.date;
          }else{
            alert("输入的学号有误！")
          }
        })
      },
      handle1(index, row) {
        this.modifInfo.name = row.name;
        this.modifInfo.num = row.num;
        this.modifInfo.className = row.cour;
        this.dialogVisible = true;
      },
      handle2(index, row) {
        let that=this;
        that.modifInfo.name = row.name;
        that.modifInfo.num = row.num;
        that.modifInfo.className = row.cour;
        that.$confirm('此操作将永久删除该成绩, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          Link.delete(that.modifInfo).then(function (resp) {
            if(resp.data.code==200){
              that.$message({
                type: 'success',
                message: '删除成功!'
              });
            }else{
              that.$message({
                type: 'warning',
                message: '删除失败!'
              });
            }
          })
        }).catch(() => {
          that.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      handleDelete(index, row) {

      },
      isNumber(val){
        var regNeg = /^[0-9]{1,2}(\.)?[05]?$/; //负浮点数
        if(regNeg.test(val)){
          return true;
        }else{
          return false;
        }

      },
      modfiy(){
        let that=this;
        if(!that.isNumber(that.modifInfo.grade)){
          alert("输入的成绩有误哟！")
          return;
        }
        Link.modfiyInfo(that.modifInfo).then(function (resp) {
          if(resp.data.code==200){
              that.$msgbox("修改成功，麻烦再点一下查询！")
              that.dialogVisible=false;
              that.modifInfo.grade='';
              return;
          }
          if(resp.data.code==400){
            alert("修改失败！")
          }
          else{
            alert("分数不对啊兄弟！")
          }
        })
      }
    }
  }
</script>

<style scoped>
  .search {
    display: flex;
    justify-content: center;
    align-items: flex-start;
    flex-wrap: wrap;
    height: 100%;
  }

  .input {
    width: 25%;
    margin-top: 20px;
    margin-bottom: 20px;
  }

  .button {
    margin-left: 8px;
    margin-top: 20px;
    margin-bottom: 20px;
  }

  .zw {
    width: 100%;
  }
</style>
