package com.han.dao;


import com.han.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository    //mapper层注解专用，是一个component，service层是service，controller层是controller，都是component
@Mapper
public interface UserMapper {

    //增加用户
    int addUser(User user);

    //删除用户
    int deleteUserById(@Param("userId") int id);

    //更新用户
    int updateUser(User user);

    //查询用户
    User queryUserById(@Param("userId") int id);

    User queryUserByUsername(@Param("name") String name);

    //查询用户
    List<User> queryAllUser();

}
