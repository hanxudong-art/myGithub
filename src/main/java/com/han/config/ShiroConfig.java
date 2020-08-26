//package com.han.config;
//
//
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//
//@Configuration
//public class ShiroConfig {
//
////    ShiroFilterFactory
//    @Bean
//    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
//        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
////        设置安全管理器
//        bean.setSecurityManager(defaultWebSecurityManager);
//
////        添加shiro的内置过滤器：anon  authc  user  perms  role
//
////        Map<String,String> filterMap=new LinkedHashMap<>();
////        filterMap.put("/home","authc");
////        filterMap.put("/main","authc");
//
////        bean.setFilterChainDefinitionMap(filterMap);
//
////        bean.setLoginUrl("/index");
//
//
//        return bean;
//    }
//
////    DafaultWebSecurityManger
//    @Bean(name = "securityManager")
//    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
//        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
//        //关联UserRealm
//        securityManager.setRealm(userRealm);
//        return securityManager;
//    }
//
////    创建Realm对象
//    @Bean()
//    public UserRealm userRealm(){
//        return new UserRealm();
//    }
//}
//
