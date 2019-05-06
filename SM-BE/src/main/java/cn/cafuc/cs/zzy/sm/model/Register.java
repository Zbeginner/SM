package cn.cafuc.cs.zzy.sm.model;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.model
 * @Author:zzy
 */
public class Register {
    private String password;
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Register{" +
                "password='" + password + '\'' +
                ", student=" + student +
                '}';
    }
}
