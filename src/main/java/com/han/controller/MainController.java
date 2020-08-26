package com.han.controller;


import com.han.pojo.Books;
import com.han.pojo.User;
import com.han.service.BookServiceImpl;
import com.han.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller          //RestController=Controller+ResponseBody
public class MainController {

    @Autowired
    BookServiceImpl bookService;

    @Autowired
    UserService userService;


    //返回主页
    @GetMapping ("/tomain")
    public String tomain(){
        return "main";
    }


//    查询所有书籍展示在/home
    @GetMapping("/home")
//    @ResponseBody
    public  String main(Model model){
        Collection<Books> list=bookService.queryAllBook();
        System.out.println("jjjjjjjj");
        model.addAttribute("booklist",list);
        return "home";
    }



//    删除书籍
    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") int id){ //PathVariable 表明它是前端传过来的一个参数
        int i=bookService.deleteBookById(id);
        if(i>0)
            System.out.println("删除成功");
        return "redirect:/home";
    }




//    修改书籍
    @GetMapping("/upd/{id}")
    public String update(@PathVariable("id") int id,Model model){
        Books books=bookService.queryBooKById(id);
        model.addAttribute("books",books); //返回给前端要修改的书籍的所有信息
//        System.out.println("hh");
        return "upd";   //返回到修改书籍信息的页面
    }



//修改书籍的请求处理
    @PostMapping("/updbook")
    public String updatebook( Books books){
        bookService.updateBook(books);
        return "redirect:/home";
    }





    //    添加书籍的页面
    @GetMapping("/add")
    public String add(){
//        System.out.println("hh");
        return "add";   //返回到修改书籍信息的页面
    }




//添加书籍的请求处理
    @PostMapping("/addbook")
    public String addbook( Books books){
        bookService.addBook(books);
//        System.out.println(books);
        return "redirect:/home";
    }

    @GetMapping("/index")
    public String login(HttpSession session){
//        退出后台主页，清除session，返回登录页面
        session.invalidate();
        return "index";
    }



//    查询书籍
    @PostMapping("/search")
    public  String search(String queryBookName,Model model){
        Books books=bookService.queryBooKByName(queryBookName);
//        System.out.println(books);

        List<Books> list=new ArrayList<Books>();
        list.add(books);

        if (books==null){
            list=bookService.queryAllBook();
            model.addAttribute("error","未查到相关书籍");
        }

        model.addAttribute("booklist",list);
        return "home";


    }



    @PostMapping("/login")
    public  String loginByInfo(String username, String password, Model model, HttpSession session) {
//1.通过shiro来进行登录的认证和授权
        //        //获取当前的用户
//        Subject subject= SecurityUtils.getSubject();
//        //封装用户的登录数据
//        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
//        try {
//            //执行登录
//            subject.login(token);
//            return "main";
//        } catch (UnknownAccountException e) {
////            用户名错误
//            model.addAttribute("msg","用户名错误");
//            return "index";
//        }catch (IncorrectCredentialsException e){
//            model.addAttribute("msg","密码错误");
//        return "index";
//        }



//       2. 通过session来进行登录认证
        User user = userService.queryUserByUsername(username);
//        System.out.println(username==user.getUsername()&&password==user.getPassword());
    //    System.out.println(username.equals(user.getUsername())&&password.equals(user.getPassword()));


        if (username.equals(user.getUsername())&&password.equals(user.getPassword())) {

            session.setAttribute("loginUser", username);

//            System.out.println(session);
            return "main";
        }else{
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }
    }


}

