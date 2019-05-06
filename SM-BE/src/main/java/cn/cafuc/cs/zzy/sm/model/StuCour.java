package cn.cafuc.cs.zzy.sm.model;

import java.util.List;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.model
 * @Author:zzy
 */
public class StuCour {
    private Integer id;
    private Integer sid;
    private Integer cid;
    private Student student;
    private Double grade;

    @Override
    public String toString() {
        return "StuCour{" +
                "id=" + id +
                ", sid=" + sid +
                ", cid=" + cid +
                ", student=" + student +
                ", grade=" + grade +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
