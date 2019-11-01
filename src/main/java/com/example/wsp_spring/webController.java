package com.example.wsp_spring;


import com.example.wsp_spring.model.SignService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//add
import com.example.wsp_spring.model.RetrospectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Controller

public class webController {

    @GetMapping("test")
    @ResponseBody

    public String test(Model model){
        return LocalDateTime.now().toString();
    }

    @GetMapping("GetPost")
    public String get(Model model){

        return "retrospect";
    }

    @PostMapping("GetPost")
    public String post(String text, Model model){
        var message = service.modelText(text);
        model.addAttribute("message",message);
        //追加 10/29
        var retrospectives = service.findAll();
        model.addAttribute("retrospectives",retrospectives);
        return "retrospect";
    }


    @GetMapping("SignIn")
    public String signin(Model model){
        return "signin";

    }
    @GetMapping("Signed")
    public String getsigned(Model model){
        return "signed";
    }

    @PostMapping("Signed")
    public String signed (String text,Model model){
       var n = new SignService();
       var hantei = n.doSignIn(text,);
       if(hantei == true){
           return "signed";
       }
        return "signin";
    }

    //add
    @Autowired
    private RetrospectService service;


}
