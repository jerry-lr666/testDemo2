package cn.tedu.demo1.rui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {
    @GetMapping("/login.html")
    public String login(){
        return "login";
    }
    @GetMapping("/register.html")
    public String register(){
        return "register";
    }

    @GetMapping("/index.html")
    public String index(){
        return "index";
    }
}
