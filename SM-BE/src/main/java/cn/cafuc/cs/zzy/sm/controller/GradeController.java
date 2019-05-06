package cn.cafuc.cs.zzy.sm.controller;

import cn.cafuc.cs.zzy.sm.bean.ResponseBean;
import cn.cafuc.cs.zzy.sm.mapper.TeacherMapper;
import cn.cafuc.cs.zzy.sm.model.AddGrade;
import cn.cafuc.cs.zzy.sm.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.controller
 * @Author:zzy
 */
@RestController
@CrossOrigin
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    GradeService gradeService;

    /**
     * 成绩查询
     * 学生编号不为空时优先查询
     * @param major
     * @param sid
     * @return
     */
    @GetMapping("/getinfo")
    public ResponseBean getGrade(@Nullable String major, @Nullable Integer sid){
        return gradeService.getGrade(major,sid);
    }

    @GetMapping("/search/{num}")
    public ResponseBean search(@PathVariable("num") String num){
        return gradeService.searchByNum(num);
    }


    @GetMapping("/modify")
    public ResponseBean modify( String num, String courName,Double grade){
        return gradeService.modify(num,courName,grade);
    }
    @GetMapping("/delete")
    public ResponseBean delete( String num, String courName){
        return gradeService.delete(num,courName);
    }
    @PostMapping("/add")
    public ResponseBean add(@RequestBody AddGrade addGrade){
        return gradeService.add(addGrade);
    }
}
