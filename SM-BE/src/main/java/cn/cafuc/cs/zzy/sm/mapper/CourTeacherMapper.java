package cn.cafuc.cs.zzy.sm.mapper;

import cn.cafuc.cs.zzy.sm.model.CourTeacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.mapper
 * @Author:zzy
 */
public interface CourTeacherMapper {
    /**
     * 通过老师或者课程查询课程信息
     * 为空时查询所有
     * @param tid
     * @param cid
     * @return
     */
    List<CourTeacher> selectInfo(@Param("tid") Integer tid, @Param("cid") Integer cid);

    Integer addOne(@Param("tid") Integer tid,@Param("cid") Integer cid);

    /**
     * 根据id删除课程老师对应关系
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 为课程安排老师
     * @param cid
     * @param tid
     * @return
     */
    Integer modify(@Param("cid") Integer cid, @Param("tid") Integer tid);
}
