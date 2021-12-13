package com.example.entity;

public class Book {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    private String name;
    private String auther;
    public void printbookinfo(){
        System.out.println("图书信息："+this.name+"作者："+this.auther);
    }

}
