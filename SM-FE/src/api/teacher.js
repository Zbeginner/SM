import {SERVER_BASE,link} from "@/api/config";

export default {
  getlist(){
    return link.get(SERVER_BASE+"/teacher/list")
  },

}
