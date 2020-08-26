package com.han;

import com.han.pojo.User;
import com.han.service.BookServiceImpl;
//import org.junit.Test;
import com.han.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringBootStudyApplicationTests {
	@Autowired
	BookServiceImpl bookService;

	@Autowired
	UserService userService;


//	测试是否可以从数据库查到数据：成功
	@Test
	void contextLoads(){
//		User user=new User("kk","hh",105);
//		System.out.println(userService.queryUserByUsername("admin1"));
	}


//	@Test
////	void contextLoads() throws SQLException {
//		System.out.println(dataSource.getClass());

////		获取数据库连接
//	Connection connection=dataSource.getConnection();
//
//		System.out.println(connection);
//
//    	connection.close();
//
//	}

}
