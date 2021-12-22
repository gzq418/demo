package com.example.controller;


import java.io.*;
import java.net.URLDecoder;

import com.example.demo.ResultVO;
import com.example.entity.Book;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

@Controller
@RestController

public class FileUpload {

    @RequestMapping(value ={"/upload"} ,method = RequestMethod.GET)
    public ResultVO loginForm() {
//        ResultVO resultVO = null;
//        resultVO.setCode(200);
//        resultVO.setData("return success");
//        resultVO.setMsg("223");

        Book book=new Book();
        book.setName("安徒生童话");
        book.setAuther("安徒生");
        return new ResultVO(200,"success",book);
    }


    @RequestMapping(value = {"index"})
    public String index(){

        return "upload";
    }
    @RequestMapping(value = {"/gotoAction"})
    public ResultVO upload(@RequestParam("file") MultipartFile file){
            String storePath ="D:\\";
            String filename= file.getOriginalFilename();
            File filepath= new File(storePath,filename);
            System.out.println(filepath);
            if(!filepath.getParentFile().exists()){
                System.out.println("exist");
                filepath.getParentFile().mkdir();
            }
            try{
                System.out.println("not exist");
                file.transferTo(new File(storePath+File.separator+filename));
            }
            catch (IOException e){
                e.printStackTrace();
                return new ResultVO();
            }
        return new ResultVO(200,"success",filepath);
    }
    @RequestMapping(value = {"/uploadfile"})                                                       @ResponseBody
    public String uploadfile(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("utf-8");
        String filename=file.getOriginalFilename();
        if("".equals(filename)){
            return "upload";
        }
        System.out.println("上传文件名："+filename);
//        String path=this.getServletContext().getRealPath("/uploadfile");
        String path ="D:\\";
        File file1=new File(path,filename);
        if(!file1.getParentFile().exists()){
            file1.getParentFile().mkdir();
        }
        System.out.println("上传文件保存地址："+file1);
        InputStream in=file.getInputStream();
        OutputStream outputStream=new FileOutputStream(new File(path,filename));
        int len=0;
        byte [] bytes=new byte[1024];
        while((len=in.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
        }
        in.close();
        outputStream.close();
        return "success";
    }
    @RequestMapping(value = {"downloadfile"})
    public String download(HttpServletResponse response) throws IOException {
        String path="D:\\";
        String filename="hello.txt";
        File file1=new File(path,filename);
        response.reset();
        response.setCharacterEncoding("utf-8");
        //二进制流传输数据
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition","attachment;filename="+ URLDecoder.decode(filename,"utf-8"));
        FileInputStream in=new FileInputStream(file1);
        ServletOutputStream outputStream=response.getOutputStream();
        int len=0;
        byte[] bytes=new byte[1024];
        while((len=in.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
        }
        in.close();
        outputStream.close();
        return "download";
    }
}
