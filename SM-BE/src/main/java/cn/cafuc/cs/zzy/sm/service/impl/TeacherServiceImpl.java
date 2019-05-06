package cn.cafuc.cs.zzy.sm.service.impl;

import cn.cafuc.cs.zzy.sm.bean.ResponseBean;
import cn.cafuc.cs.zzy.sm.mapper.TeacherMapper;
import cn.cafuc.cs.zzy.sm.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.service.impl
 * @Author:zzy
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    TeacherMapper teacherMapper;
    @Override
    public ResponseBean getList() {
        return new ResponseBean(200,"success",teacherMapper.selectAll());
    }
}
