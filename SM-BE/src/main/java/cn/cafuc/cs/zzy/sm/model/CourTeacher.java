package cn.cafuc.cs.zzy.sm.model;

/**
 * 课程老师关联
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.model
 * @Author:zzy
 */
public class CourTeacher {
    private Integer id;
    private Integer teaId;
    private Integer couId;
    private Course course;
    private Teacher teacher;

    @Override
    public String toString() {
        return "CourTeacher{" +
                "id=" + id +
                ", teaId=" + teaId +
                ", couId=" + couId +
                ", course=" + course +
                ", teacher=" + teacher +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public Integer getCouId() {
        return couId;
    }

    public void setCouId(Integer couId) {
        this.couId = couId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
