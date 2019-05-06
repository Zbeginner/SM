package cn.cafuc.cs.zzy.sm.model;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.model
 * @Author:zzy
 */
public class Course {
    private Integer id;
    private String name;
    private Integer score;
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
