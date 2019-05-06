<template>
  <div class="index" >
    <el-form>
      <el-form-item  :label-width="labelWidth" label="用户名" class="xxx">
        <el-input class="indexInput" v-model="user.username" placeholder="请输入账号"></el-input>
      </el-form-item>
      <el-form-item :label-width="labelWidth" label="密码">
        <el-input class="indexInput" v-model="user.password" placeholder="请输入密码" type="password" @keyup.enter.native="login"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button class="formbutton" @click="login" >登陆</el-button>
        <el-link class="link" type="info" @click="dialogVisible=true">注册</el-link>
      </el-form-item>
    </el-form>

    <el-dialog
      title="注册"
      :visible.sync="dialogVisible"
      width="30%">
      <el-link type="danger" style="margin-block-end: 10px;font-size: large" :underline="false" >学号将会是你的登陆账号</el-link>
      <el-form>
        <el-form-item :label-width="labelWidth" label="姓名">
          <el-input placeholder="请输入你的姓名" v-model="register.stuName"></el-input>
        </el-form-item>
        <el-form-item :label-width="labelWidth" label="学号">
          <el-input placeholder="请输入你的学号,学号会成功以后登陆的用户名！" v-model="register.stuNum"></el-input>
        </el-form-item>
        <el-form-item :label-width="labelWidth" label="专业">
          <el-input placeholder="请输入你的专业" v-model="register.stuMajor"></el-input>
        </el-form-item>
        <el-form-item :label-width="labelWidth" label="密码">
          <el-input placeholder="请输入你的密码" type="password" v-model="register.password"></el-input>
        </el-form-item>
        <el-form-item :label-width="labelWidth" label="重复密码">
          <el-input type="password" placeholder="请再次输入密码" v-model="register.repassword"></el-input>
        </el-form-item>
      </el-form>
      <el-button @click="cacel">取 消</el-button>
      <el-button type="primary" @click="regist">确 定</el-button>
      <!--  </span>-->
    </el-dialog>

  </div>

</template>

<script>
  import loginController from '@/api/login'

  export default {
    name: "login",
    data() {
      return {
        dialogVisible: false,
        labelWidth: '100px',
        user: {
          username: '',
          password: '',
        },
        register: {
          stuName:'',
          stuMajor:'',
          stuNum: '',
          password: '',
          repassword: ''
        },
      }
    },
    methods: {
      login() {
        let that=this;
        loginController.login(this.user).then(function (resp) {
          if(resp.data.code==200){
            console.log(resp.data.date)
            // that.LoginAction(resp.data.date);
            sessionStorage.setItem('$token',resp.data.msg);
            sessionStorage.setItem('account',resp.data.date.account);
            that.$router.push('/index')
          }else{
            alert("用户名或密码错误!")
          }
          that.setRegistNull()
        })
      },
      setRegistNull() {
        this.register.stuNum = '';
        this.register.stuName = '';
        this.register.stuMajor = '';
        this.register.username = '';
        this.register.password = '';
        this.register.repassword = '';
      },
      cacel(){
        this.setRegistNull();
        this.dialogVisible=false;
      },
      regist() {
        let that = this;
        if (that.register.stuNum == '' || that.register.password == '' || that.register.repassword == '' || that.register.stuName == ''|| that.register.stuMajor == '') {
          alert("有信息没填!")
          return;
        }
        if (that.register.password != that.register.repassword) {
          alert("两次密码好像不太一样？do you think so?")
          return;
        }
        var judge=/^[\u4e00-\u9fa5]{2,4}$/;
        if(!judge.test(this.register.stuName)){
          alert("听说名字要全中文？do you know that?")
          return;
        }
        loginController.regist(that.register).then(function (resp) {
          if (resp.data.code == 200) {
            alert("注册成功！");
            that.dialogVisible = false;
          } else if (resp.data.code == 401) {
            alert("学号错啦!")
          } else if (resp.data.code == 403) {
            alert("此用户名已经存在!")
          } else {
            alert("账号或密码格式不对啦!")
          }
          that.setRegistNull();
        })
      },
    },
  }
</script>

<style scoped>
  .index {
    display: flex;
    margin-top: 15%;
    flex-wrap: nowrap;
    justify-content: center;
    flex-direction: row;
  }

  .indexInput {
    width: 100%;
  }

  .link {
    font-size: 20px;
    text-align: end;
    align-self: flex-end;
    margin-right: 10px;
    float: right;
  }

  .formbutton {
    display: flex;
    width: 70px;
    float: right;
  }
</style>
