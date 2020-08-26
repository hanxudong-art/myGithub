package com.han.dao;

        import com.han.pojo.Books;
        import org.apache.ibatis.annotations.Mapper;
        import org.apache.ibatis.annotations.Param;
        import org.springframework.stereotype.Repository;


        import java.util.List;

@Repository    //mapper层注解专用，是一个component，service层是service，controller层是controller，都是component
@Mapper
public interface BookMapper {

    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookId") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBooKById(@Param("bookId") int id);

    Books queryBooKByName(@Param("bookName") String bookName);

    //查询所有的书
    List<Books> queryAllBook();


}
