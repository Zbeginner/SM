package cn.cafuc.cs.zzy.sm.shiro;

import cn.cafuc.cs.zzy.sm.mapper.UserMapper;
import cn.cafuc.cs.zzy.sm.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.shiro
 * @Author:zzy
 */
@Component
public class MyRealm extends AuthorizingRealm {
    @Resource
    UserMapper userMapper;
    /**
     * 授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        String account = principalCollection.getPrimaryPrincipal().toString();
//        User user = userService.selectByAccount(account);
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        for ( Role role : user.getRoles() ) {
//            simpleAuthorizationInfo.addRole(role.getRoleName());
//        }
//        return simpleAuthorizationInfo;
        return null;
    }

    /**
     * 认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        User user=userMapper.selectByAccount(token.getUsername());
        if(user==null){
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(token,user.getPassword(),getName());
    }
}
