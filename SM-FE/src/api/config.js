import axios from "axios"

const SERVER_BASE="http://127.0.0.1:8080"

let link=axios.create()
link.interceptors.request.use(config => {
  if (sessionStorage.$token) {
    config.headers = { 'token': sessionStorage.$token }
  }
  return config
}, err => {
  return Promise.reject(err)
})
link.interceptors.response.use((data) => {
  return data
}, err => {
  Message.warning("发生错误")
  return Promise.reject(err)
})
export {
  SERVER_BASE,
  link
}
