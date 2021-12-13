package com.example.demo;

import com.example.entity.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        Book book=applicationContext.getBean("book",Book.class);
        book.printbookinfo();
        book.setName("java");
        System.out.println(book.getName());

    }

}
