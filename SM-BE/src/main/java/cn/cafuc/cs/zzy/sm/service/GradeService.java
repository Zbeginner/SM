package cn.cafuc.cs.zzy.sm.service;

import cn.cafuc.cs.zzy.sm.bean.ResponseBean;
import cn.cafuc.cs.zzy.sm.model.AddGrade;


/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.service
 * @Author:zzy
 */
public interface GradeService {
    ResponseBean getGrade(String major,Integer sid);
    ResponseBean searchByNum(String num);
    ResponseBean modify( String num, String courName,Double grade);
    ResponseBean delete( String num, String courName);
    ResponseBean add(AddGrade addGrade);
}
