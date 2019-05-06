package cn.cafuc.cs.zzy.sm.model;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.model
 * @Author:zzy
 */
public class Grade {
    private String name;
    private String num;
    private String major;
    private String cour;
    private Double grade;
    private String teacher;

    public Grade() {
    }

    public Grade(Student student, Teacher teacher, Course course, Double grade) {
        name = student.getName();
        num = student.getNum();
        major = student.getMajor();
        cour = course.getName();
        if (teacher != null) {
            this.teacher = teacher.getName();
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", major='" + major + '\'' +
                ", cour='" + cour + '\'' +
                ", grade=" + grade +
                ", teacher='" + teacher + '\'' +
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCour() {
        return cour;
    }

    public void setCour(String cour) {
        this.cour = cour;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
