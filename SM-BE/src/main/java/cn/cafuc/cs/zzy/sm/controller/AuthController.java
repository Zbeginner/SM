package cn.cafuc.cs.zzy.sm.controller;

import cn.cafuc.cs.zzy.sm.bean.ResponseBean;

import cn.cafuc.cs.zzy.sm.model.Register;
import cn.cafuc.cs.zzy.sm.model.User;
import cn.cafuc.cs.zzy.sm.service.UserService;
import cn.cafuc.cs.zzy.sm.tools.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;


/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.controller
 * @Author:zzy
 */
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService userService;
    @GetMapping("/login")
    public ResponseBean login(User user){
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getAccount(), MD5Util.md5(user.getPassword()));
        try {
            subject.login(token);
            User u=userService.selectByAccount(user.getAccount());
            u.setPassword(null);
            return new ResponseBean(200,"This is a Token",u);
        }catch (UnknownAccountException e){
            return new ResponseBean(401,"account is wrong!",null);
        }catch (IncorrectCredentialsException e){
            return new ResponseBean(402,"password is wrong",null);
        }catch (Exception e){
            return new ResponseBean(403,"something is wrong",null);
        }
    }
    @PostMapping("/regist")
    public ResponseBean regist(@RequestBody Register register){
//        System.out.println(register);
//        return null;
        return userService.regist(register);
    }
    @GetMapping("/logout")
    public ResponseBean logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ResponseBean(200,"success",null);
    }
    @GetMapping("/wrong")
    public ResponseBean wrong(){

        return new ResponseBean(501,"error request",null);
    }
}
