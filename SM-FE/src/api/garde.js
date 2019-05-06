import {SERVER_BASE,link} from "@/api/config";
export default {
  getinfo(major,sid){
    return link.get(SERVER_BASE+"/grade/getinfo",{
      params:{
        major:major,
        sid:sid
      }
    })
  },
  searchByNum(num) {
    return link.get(SERVER_BASE+"/grade/search/"+num)
  },
  modfiyInfo(modifInfo) {
    return link.get(SERVER_BASE+"/grade/modify",{
        params:{
          num:modifInfo.num,
          courName:modifInfo.className,
          grade:modifInfo.grade
        }
    })
  },
  delete(modifInfo) {
    return link.get(SERVER_BASE+"/grade/delete",{
      params:{
        num:modifInfo.num,
        courName:modifInfo.className,
      }
    })
  },
  add(val){
    return link.post(SERVER_BASE+"/grade/add",{
      name:val.name,
      num:val.num,
      cid:val.courid,
      grade:val.grade
    })
  },
}
