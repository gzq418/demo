package com.example.controller;

import com.example.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.*;
@Controller
@RestController
public class BookController {
    @RequestMapping(value = {"/book"}, method = RequestMethod.GET)
    public Book book(){
        Book book=new Book();
        book.setName("安徒生童话");
        book.setAuther("安徒生");
        return book;
    }


}
