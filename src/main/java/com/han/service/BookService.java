package com.han.service;

        import com.han.pojo.Books;
        import org.apache.ibatis.annotations.Param;

        import java.util.List;

public interface BookService {

    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById( int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBooKById( int id);

    Books queryBooKByName( String bookName);

    //查询所有的书
    List<Books> queryAllBook();

}
