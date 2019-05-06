package cn.cafuc.cs.zzy.sm.service.impl;

import cn.cafuc.cs.zzy.sm.mapper.StuMapper;
import cn.cafuc.cs.zzy.sm.model.Student;
import cn.cafuc.cs.zzy.sm.service.StuService;

import javax.annotation.Resource;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.service.impl
 * @Author:zzy
 */
public class StuServiceImpl implements StuService {
    @Resource
    StuMapper stuMapper;
    @Override
    public Integer insert(Student student) {
        return null;
    }
}
