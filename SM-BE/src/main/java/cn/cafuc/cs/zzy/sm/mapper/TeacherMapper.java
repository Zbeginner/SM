package cn.cafuc.cs.zzy.sm.mapper;

import cn.cafuc.cs.zzy.sm.model.Teacher;

import java.util.List;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.mapper
 * @Author:zzy
 */
public interface TeacherMapper {
    Teacher selectById(Integer id);
    List<Teacher> selectAll();
}
