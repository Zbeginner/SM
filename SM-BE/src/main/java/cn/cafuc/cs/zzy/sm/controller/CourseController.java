package cn.cafuc.cs.zzy.sm.controller;

import cn.cafuc.cs.zzy.sm.bean.ResponseBean;
import cn.cafuc.cs.zzy.sm.model.Course;
import cn.cafuc.cs.zzy.sm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.controller
 * @Author:zzy
 */
@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    /**
     * 获取所有课程老师对应信息
     * 可以根据老师id或者课程id区分
     * @return
     */
    @GetMapping("/getinfo")
    public ResponseBean getinfo(@Nullable Integer cid,@Nullable Integer tid){
        return courseService.getCourseInfo(cid,tid);
    }

    /**
     * 获得课程信息
     * 可以根据课程名精确查找
     * @return
     */
    @GetMapping("/list")
    public ResponseBean getCourseList(@Nullable String name){
        return courseService.getCourseList(name);
    }

    /**
     * 添加一门新课程并关联老师
     * @param course
     * @param tid
     * @return
     */
    @PostMapping("/add/{tid}")
    public ResponseBean addCourse(@RequestBody Course course,@PathVariable Integer tid){
        return courseService.addCourse(course,tid);
    }

    /**
     * 删除某个课程与老师的对应关系;
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ResponseBean delete(@PathVariable Integer id){
       return courseService.delete(id);
    }

    @GetMapping("/modify")
    public ResponseBean modify(Integer cid,Integer tid){
        return courseService.modify(cid,tid);
    }
}
