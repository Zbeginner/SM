package cn.cafuc.cs.zzy.sm.bean;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.bean
 * @Author:zzy
 */
public class ResponseBean {
    private Integer code;
    private String msg;
    private Object Date;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDate() {
        return Date;
    }

    public void setDate(Object date) {
        Date = date;
    }

    public ResponseBean(Integer code, String msg, Object date) {
        this.code = code;
        this.msg = msg;
        Date = date;
    }
}
