package com.example.controller;


import java.io.File;
import java.io.IOException;

import com.example.demo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
@Controller
public class FileUpload {
    /**
     * 首次进入时候的页面

     * @return
     */
    @RequestMapping(value ={"/gotoAction"} ,method = RequestMethod.GET)
    public ResultVO loginForm() {
        return new ResultVO();
    }

    @RequestMapping(value = {"/upload"}, method = RequestMethod.POST)
    public ResultVO upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        if(!file.isEmpty()){
            String contentpath= request.getContextPath();
            String servletpath=request.getServletPath();
            String scheme=request.getScheme();
            String storePath ="D:\\";
            String filename= file.getOriginalFilename();
            File filepath= new File(storePath,filename);
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdir();
            }
            try{
                file.transferTo(new File(storePath+File.separator+filename));
            }
            catch (IOException e){
                e.printStackTrace();
                return new ResultVO();
            }



        }
        return new ResultVO(); }
}
