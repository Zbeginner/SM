package cn.cafuc.cs.zzy.sm.model;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.model
 * @Author:zzy
 */
public class Student {
    private Integer id;
    private String name;
    private String num;
    private String major;
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
