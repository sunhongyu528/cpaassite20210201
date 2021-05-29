package com.sunhongyu.cpaassite20210201.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello!!!";
    }

    @RequestMapping("/admin")
    public String test1(){
        return "admin";
    }


    @RequestMapping("/login")
    public String login(){
        return "/page/login/login";
    }


}
