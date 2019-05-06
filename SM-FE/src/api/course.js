import {SERVER_BASE, link} from "@/api/config"

export default {
  getlist() {
    return link.get(SERVER_BASE + "/course/list")
  },
  add(info) {
    return link.post(SERVER_BASE + '/course/add/'+info.id, {
      name: info.name,
      score: info.score
    })
  },
  getTeaCourInfo(){
    return link.get(SERVER_BASE + "/course/getinfo")
  },
  delete(id){
    return link.get(SERVER_BASE + "/course/delete/"+id)
  },
  modify(cid,tid){
    return link.get(SERVER_BASE + "/course/modify/",{
      params:{
        cid:cid,
        tid:tid
      }
    })
  }
}
