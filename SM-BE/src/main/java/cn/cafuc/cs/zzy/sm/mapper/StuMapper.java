package cn.cafuc.cs.zzy.sm.mapper;

import cn.cafuc.cs.zzy.sm.model.Student;

import java.util.List;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.mapper
 * @Author:zzy
 */
public interface StuMapper {
    /**
     * 插入学生信息
     * @param student
     * @return
     */
    Integer insert(Student student);

    /**
     * 通过id查询学生信息
     * @param id
     * @return
     */
    Student selectById(Integer id);

    /**
     * 查询某个专业的学生信息
     * @param major
     * @return
     */
    List<Student> selectByMajor(String major);

    /**
     * 通过学号查询学生信息
     * @param num
     * @return
     */
    Student selectByNum(String num);
}
