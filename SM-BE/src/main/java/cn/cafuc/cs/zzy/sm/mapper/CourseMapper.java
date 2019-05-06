package cn.cafuc.cs.zzy.sm.mapper;

import cn.cafuc.cs.zzy.sm.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.mapper
 * @Author:zzy
 */
public interface CourseMapper {
    Course selectById(Integer id);
    Course selectByName(String name);

    /**
     * 查询所有课程信息
     * @return
     */
    List<Course> getCourse(String name);

    /**
     * 新增课程
     * @param course
     * @return
     */
    Integer addCourse(Course course);

    /**
     * 删除课程信息
     * @param id
     * @return
     */
    Integer delete(Integer id);


}
