package cn.cafuc.cs.zzy.sm.mapper;

import cn.cafuc.cs.zzy.sm.model.StuCour;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.mapper
 * @Author:zzy
 */
public interface StuCourMapper {
    Integer insert(StuCour stuCour);
    /**
     * 查询学生成绩信息
     * 可以根据学生编号或者课程编号精确查找
     * @param sid
     * @param cid
     * @return
     */
    List<StuCour> selectInfo(@Param("sid") Integer sid, @Param("cid") Integer cid);

    /**
     * 查询某个学生的每个课程编号
     * @param sid
     * @return
     */
    Integer selectCourse(Integer sid);

    /**
     * 调整成绩
     * @param stuCour
     * @return
     */
    Integer modify(StuCour stuCour);

    /**
     * 删除一条成绩记录
     * @param sid
     * @param cid
     * @return
     */
    Integer delete(@Param("sid") Integer sid, @Param("cid") Integer cid);
}
