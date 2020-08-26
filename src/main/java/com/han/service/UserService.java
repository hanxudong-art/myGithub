package com.han.service;

import com.han.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    //增加用户
    int addUser(User user);

    //删除用户
    int deleteUserById(@Param("userId") int id);

    //更新用户
    int updateUser(User user);

    //查询用户
    User queryUserById(@Param("userId") int id);

    User queryUserByUsername(String name);

    //查询用户
    List<User> queryAllUser();
}
