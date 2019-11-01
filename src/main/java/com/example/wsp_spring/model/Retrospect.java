package com.example.wsp_spring.model;

import java.sql.SQLOutput;
import java.time.LocalDateTime;

public class Retrospect {

    private String text;
    private String textPass;
    private LocalDateTime postedAt;

    public Retrospect(String text,String textPass){
        this.text = text;
        this.textPass = textPass;
        this.postedAt = LocalDateTime.now();
        this.print();
    }
    public Retrospect(){
        this.text = "";
        this.postedAt = LocalDateTime.MIN;
    }

    public void  setPostedAt(LocalDateTime postedat){
        this.postedAt = postedat;
    }
    public void setText(String text){
        this.text = text;
    }
    public void setTextPass(String textPass){this.textPass=textPass;}



    public  String getText(){
        return text;
    }
    public  String getTextPass(){return textPass;}

    public LocalDateTime getPostedAt(){
        return postedAt;
    }

    public void print(){
        System.out.println(String.join(",",super.toString(),text,postedAt.toString()));
    }
}
