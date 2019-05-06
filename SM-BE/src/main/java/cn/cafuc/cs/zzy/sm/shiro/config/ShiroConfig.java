package cn.cafuc.cs.zzy.sm.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import cn.cafuc.cs.zzy.sm.shiro.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.shiro.config
 * @Author:zzy
 */
@Configuration
public class ShiroConfig {
    /**
     * 添加Url过滤器
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> filterMap=new HashMap<>();
        filterMap.put("/auth/login","anon");
        filterMap.put("/auth/regist","anon");
//        filterMap.put("/**","authc");
        filterMap.put("/**","anon");
        shiroFilterFactoryBean.setLoginUrl("/auth/wrong");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/auth/wrong");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }
    @Bean
    public SecurityManager SecurityManager(MyRealm realm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }
}
