package cn.cafuc.cs.zzy.sm.service.impl;

import cn.cafuc.cs.zzy.sm.bean.ResponseBean;
import cn.cafuc.cs.zzy.sm.mapper.CourTeacherMapper;
import cn.cafuc.cs.zzy.sm.mapper.CourseMapper;
import cn.cafuc.cs.zzy.sm.model.Course;
import cn.cafuc.cs.zzy.sm.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.service.impl
 * @Author:zzy
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    CourTeacherMapper courTeacherMapper;
    @Resource
    CourseMapper courseMapper;
    @Override
    public ResponseBean getCourseInfo(Integer cid,Integer tid) {
        return new ResponseBean(200,"success",courTeacherMapper.selectInfo(tid,cid));
    }

    @Override
    public ResponseBean getCourseList(String name) {
        return new ResponseBean(200,"success",courseMapper.getCourse(name));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBean addCourse(Course course, Integer tid) {
        try {
            courseMapper.addCourse(course);
            courTeacherMapper.addOne(tid,course.getId());
        }catch (Exception e){
            return new ResponseBean(400,"success",null);
        }
        return new ResponseBean(200,"success",null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBean delete(Integer id) {
        try {
            courTeacherMapper.delete(id);
            courseMapper.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(400,"success",null);
        }
        return new ResponseBean(200,"success",null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBean modify(Integer cid, Integer tid) {
        try {
            courTeacherMapper.modify(cid,tid);
            return new ResponseBean(200,"success",null);
        }catch (Exception e){
            return new ResponseBean(400,"fault",null);
        }
    }
}
