//package com.han.config;
//
//import com.han.pojo.User;
//import com.han.service.UserService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class UserRealm extends AuthorizingRealm {
//
//    @Autowired
//    UserService userService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("执行了授权");
//        return null;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println("执行了认证");
////        UsernamePasswordToken userToken=(UsernamePasswordToken) token;
////        //连接数据库
////        User user=userService.queryUserByUsername(userToken.getUsername());
////        if(user==null){
////            return null;  //即抛出UnknownAccountException
////        }
//// //shiro来验证密码
////        return new SimpleAuthenticationInfo("",user.getPassword(),"");
//        return null;
//    }
//}
