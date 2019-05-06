package cn.cafuc.cs.zzy.sm.service.impl;

import cn.cafuc.cs.zzy.sm.bean.ResponseBean;
import cn.cafuc.cs.zzy.sm.mapper.StuMapper;
import cn.cafuc.cs.zzy.sm.mapper.UserMapper;
import cn.cafuc.cs.zzy.sm.model.Register;
import cn.cafuc.cs.zzy.sm.model.User;
import cn.cafuc.cs.zzy.sm.service.UserService;
import cn.cafuc.cs.zzy.sm.tools.MD5Util;
import cn.cafuc.cs.zzy.sm.tools.Tools;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.service.impl
 * @Author:zzy
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Resource
    StuMapper stuMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBean regist( Register register) {
        if(Tools.judgeStuNum(register.getStudent().getNum())){
            User user= userMapper.selectByAccount(register.getStudent().getNum());
            if(user!=null){
                return new ResponseBean(403,"用户名重复",null);
            }

            user =new User();
            user.setAccount(register.getStudent().getNum());
            user.setPassword(MD5Util.md5(register.getPassword()));
            try {
                stuMapper.insert(register.getStudent());
                userMapper.insert(user);
                return new ResponseBean(200,"success",null);
            }catch (Exception e){
//                e.printStackTrace();
               return new ResponseBean(402,"format is wrong",null);
            }
        }
        return new ResponseBean(401,"num is wrong",null);
    }

    @Override
    public User selectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

}
