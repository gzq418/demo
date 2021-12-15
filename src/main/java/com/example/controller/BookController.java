package com.example.controller;

import com.example.demo.ResultVO;
import com.example.entity.FileDemo;
import org.springframework.stereotype.Controller;
import org.springframework.*;

import javax.xml.ws.RequestWrapper;

import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/file")

public class BookController {

    public ResultVO filedown(){
        String name=null;
        String path=null;
        FileDemo fileDemo=new FileDemo(null, null);
        return new ResultVO();
    }


}
