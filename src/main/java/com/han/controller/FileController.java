package com.han.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@Controller
public class FileController {

    @RequestMapping("/file")
    public String tofile(){
        return "file";
    }




//    文件上传请求处理
    @PostMapping("/fileUpload")
    public  String upload(MultipartFile file, Model model) throws IOException {
//        采用file.Transto来保存上传的文件
        if (file.isEmpty()){
            model.addAttribute("msg","请选择文件");
            return "file";
        }
//       fileName: 文件名
        String fileName=file.getOriginalFilename();
//        filepath：文件保存的路径
        String filePath="C:\\Users\\韩英俊\\Desktop\\SpringBootStudy\\src\\main\\resources\\static\\uploadFiles\\uploadFile";
        File dest=new File(filePath+"/"+fileName);
        try {
           file.transferTo(dest);
        model.addAttribute("msg","上传成功");
            return "file";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("msg","文件上传失败");
        return "email";
    }


//    下载文件请求处理:这段代码有一个异常错误
//    @RequestMapping("/download")
//    public String download( HttpServletResponse response,Model model) {
//        //设置要下载的文件路径
//        String filePath = "C:\\Users\\韩英俊\\Desktop\\SpringBootStudy\\src\\main\\resources\\static\\uploadFiles\\uploadFile\\后端准备工作.txt";
//        //设置下载后的文件名以及格式word、txt、pdf...
//        String fileName = "测试文件.txt";

        //使用流的形式下载文件
       // try {
//            //加载文件
//            File file = new File(filePath);
//            //读取文件到输入流
//            InputStream is = new BufferedInputStream(new FileInputStream(file));
//            // 创建缓冲区：大小自适应
//            byte[] buffer = new byte[is.available()];
//            //从缓冲区读取文件
//            is.read(buffer);
//            //读完后关闭输入流
//            is.close();
//
//            //清空response
//            response.reset();
//            // 设置response的Header请求头
//            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
//            response.addHeader("Content-Length", "" +file.length());
//            //携带请求头将文件通过输出流响应给客户端
//            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
//            //通知客户文件的MOME类型
//            response.setContentType("application/octet-stream");
//            //写入缓冲区
//            toClient.write(buffer);
//            //刷新
//            toClient.flush();
//            model.addAttribute("message","文件下载成功");
//            //关闭输出流
//            toClient.close();
//            return "file";
//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute("message","文件下载失败");
//            return "file";
//        }



//}


    @RequestMapping("/download")
    public String downLoad(HttpServletResponse response,Model model) throws UnsupportedEncodingException {
        String filename="han.docx";
        String filePath = "C:\\Users\\韩英俊\\Desktop\\SpringBootStudy\\src\\main\\resources\\static\\uploadFiles\\uploadFile" ;
        File file = new File(filePath + "/" + filename);
        if(file.exists()){ //判断文件父目录是否存在
            response.reset();
            // 设置response的Header请求头
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("UTF-8"), "ISO-8859-1"));
            response.addHeader("Content-Length", "" +file.length());
//            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
//            response.setCharacterEncoding("UTF-8");
//            // response.setContentType("application/force-download");
//            response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(filename,"UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;
            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download---" + filename);
            try {
                bis.close();
                fis.close();
                model.addAttribute("msg","文件下载成功");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

//    注入邮件接口实现类
@Autowired
    JavaMailSenderImpl mailSender;


    @RequestMapping("/simpleEmail")
    public String toSimpleEmail(){
        return "simpleEmail";
    }

    @RequestMapping("/email")
    public String sendEmail(String to,String subject,String text, Model model){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        mailMessage.setTo(to);
        mailMessage.setFrom("2951466637@qq.com");
        mailSender.send(mailMessage);
        model.addAttribute("msg","邮件发送成功");

        return "simpleEmail";
    }

//去邮件发送页面
    @RequestMapping("/Email")
    public String toEmail(){
        return "emailHome";
    }


    @RequestMapping("/toMimeEmail")
    public String toMimeEmail(){
        return "email";
    }

    @RequestMapping("/MimeEmail")
    public String sendMimeEmail(String to,String subject,String text,MultipartFile file, Model model) throws MessagingException, IOException {
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        helper.setSubject(subject);
        helper.setText(text,true);
//        添加附件内容
        //        采用file.Transto来保存上传的文件
        if (file.isEmpty()){
            model.addAttribute("msg","请选择文件");
            return "email";
        }
//////       fileName: 文件名
        String fileName=file.getOriginalFilename();
//////        filepath：文件保存的路径
        String filePath="C:\\Users\\韩英俊\\Desktop\\SpringBootStudy\\src\\main\\resources\\static\\uploadFiles\\uploadFile";
        File dest=new File(filePath+"/"+fileName);
        try {
            file.transferTo(dest);
            model.addAttribute("msg","上传及发送成功");
//            return "email";
        } catch (Exception e) {
            e.printStackTrace();
        }
        helper.addAttachment(fileName,dest);
        helper.setTo(to);
        helper.setFrom("2951466637@qq.com");
        mailSender.send(mimeMessage);


        return "email";
    }

}
