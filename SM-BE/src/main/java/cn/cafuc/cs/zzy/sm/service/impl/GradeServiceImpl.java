package cn.cafuc.cs.zzy.sm.service.impl;

import cn.cafuc.cs.zzy.sm.bean.ResponseBean;
import cn.cafuc.cs.zzy.sm.mapper.CourTeacherMapper;
import cn.cafuc.cs.zzy.sm.mapper.CourseMapper;
import cn.cafuc.cs.zzy.sm.mapper.StuCourMapper;
import cn.cafuc.cs.zzy.sm.mapper.StuMapper;
import cn.cafuc.cs.zzy.sm.model.*;
import cn.cafuc.cs.zzy.sm.service.GradeService;
import cn.cafuc.cs.zzy.sm.service.StuService;
import cn.cafuc.cs.zzy.sm.tools.Tools;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.service.impl
 * @Author:zzy
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Resource
    StuCourMapper stuCourMapper;
    @Resource
    CourTeacherMapper courTeacherMapper;
    @Resource
    StuMapper stuMapper;
    @Resource
    CourseMapper courseMapper;

    @Override
    public ResponseBean getGrade(String major, Integer sid) {
        List<Grade> grades = new ArrayList<>();
        if (sid != null) {
            addInfo(sid, grades);
        } else if (major != null) {
            List<Student> students = stuMapper.selectByMajor(major);
            for (Student s : students) {
                addInfo(s.getId(), grades);
            }
        } else {
            addInfo(null, grades);
        }
        return new ResponseBean(200, "success", grades);
    }

    @Override
    public ResponseBean searchByNum(String num) {
        if (!Tools.judgeStuNum(num) || num == null) {
            return new ResponseBean(401, "num is fault", null);
        }
        List<Grade> grades = new ArrayList<>();
        Student student = stuMapper.selectByNum(num);
        if (student == null) {
            return new ResponseBean(400, "fault", null);
        }
        addInfo(student.getId(), grades);
        if (!grades.isEmpty()) {
            return new ResponseBean(200, "success", grades);
        } else {
            return new ResponseBean(400, "fault", null);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBean modify(String num, String courName, Double grade) {
        if (grade > 100 || grade < 0) {
            return new ResponseBean(401, "fault", null);
        }
        StuCour stuCour = new StuCour();
        Student student = stuMapper.selectByNum(num);
        Course course = courseMapper.selectByName(courName);
        stuCour.setCid(course.getId());
        stuCour.setSid(student.getId());
        stuCour.setGrade(grade);
        try {
            stuCourMapper.modify(stuCour);
            return new ResponseBean(200, "fault", null);
        } catch (Exception e) {
            return new ResponseBean(400, "fault", null);
        }
    }

    @Override
    public ResponseBean delete(String num, String courName) {
        Student student = stuMapper.selectByNum(num);
        Course course = courseMapper.selectByName(courName);
        int cnt = stuCourMapper.delete(student.getId(), course.getId());
        if (cnt == 1) {
            return new ResponseBean(200, "success", null);
        }
        return new ResponseBean(400, "fault", null);
    }

    @Override
    public ResponseBean add(AddGrade addGrade) {
        Student student=stuMapper.selectByNum(addGrade.getNum());
        if(student==null||!student.getName().equals(addGrade.getName())){
            return new ResponseBean(400,"num is wrong",null);
        }

        StuCour stuCour=new StuCour();
        if(!stuCourMapper.selectInfo(student.getId(),addGrade.getCid()).isEmpty()){
            return new ResponseBean(402,"repeat",null);
        }

        stuCour.setGrade(addGrade.getGrade());
        stuCour.setSid(student.getId());
        stuCour.setCid(addGrade.getCid());
        try {
            stuCourMapper.insert(stuCour);
            return new ResponseBean(200,"success",null);
        }catch (Exception e){
            return new ResponseBean(401,"num is wrong",null);
        }
    }

    private void addInfo(Integer sid, List<Grade> grades) {
        List<StuCour> stuCours = stuCourMapper.selectInfo(sid, null);
        for (StuCour s : stuCours) {
            CourTeacher courTeacher = courTeacherMapper.selectInfo(null, s.getCid()).get(0);
            grades.add(new Grade(s.getStudent(), courTeacher.getTeacher(), courTeacher.getCourse(), s.getGrade()));
        }
    }

}
