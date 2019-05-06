package cn.cafuc.cs.zzy.sm.model;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.mapper
 * @Author:zzy
 */
public class AddGrade {
    private String name;
    private String num;
    private Integer cid;
    private Double grade;

    @Override
    public String toString() {
        return "AddGrade{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", cid=" + cid +
                ", grade=" + grade +
                '}';
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
