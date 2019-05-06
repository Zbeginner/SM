package cn.cafuc.cs.zzy.sm.service;

import cn.cafuc.cs.zzy.sm.bean.ResponseBean;
import cn.cafuc.cs.zzy.sm.model.Register;
import cn.cafuc.cs.zzy.sm.model.User;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.service
 * @Author:zzy
 */
public interface UserService {
    /**
     * 用户注册
     * @param register
     * @return
     */
    ResponseBean regist(Register register);

    /**
     * 通过账号查找用户信息
     * @param account
     * @return
     */
    User selectByAccount(String account);
}
