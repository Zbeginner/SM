import {SERVER_BASE,link} from "@/api/config";

export default {
  login(user){
    return link.get(SERVER_BASE+"/auth/login",{
      params:{
        account: user.username,
        password: user.password
      }
    })
  },
  regist(register){
    return link.post(SERVER_BASE+'/auth/regist',{
      password:register.password,
      student:{
        name: register.stuName,
        num: register.stuNum,
        major: register.stuMajor
      }
    })
  }
}
