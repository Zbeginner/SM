package cn.cafuc.cs.zzy.sm.service;

import cn.cafuc.cs.zzy.sm.bean.ResponseBean;
import cn.cafuc.cs.zzy.sm.model.Course;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.service
 * @Author:zzy
 */
public interface CourseService {
    ResponseBean getCourseInfo(Integer cid,Integer tid);
    ResponseBean getCourseList(String name);
    ResponseBean addCourse(Course course,Integer tid);
    ResponseBean delete(Integer id);
    ResponseBean modify(Integer cid,Integer tid);
}
