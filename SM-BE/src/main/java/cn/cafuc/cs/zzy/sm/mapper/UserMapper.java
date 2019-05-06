package cn.cafuc.cs.zzy.sm.mapper;

import cn.cafuc.cs.zzy.sm.model.User;

import java.util.List;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.mapper
 * @Author:zzy
 */
public interface UserMapper{
    /**
     * 新增用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 通过用户名查询用户信息
     * 主要用来判断用户存不存在
     * @param account
     * @return
     */
    User selectByAccount(String account);
}
