package cn.cafuc.cs.zzy.sm.controller;

import cn.cafuc.cs.zzy.sm.bean.ResponseBean;
import cn.cafuc.cs.zzy.sm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.controller
 * @Author:zzy
 */
@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping("/list")
    public ResponseBean getTeacherList(){
        return teacherService.getList();
    }
}
