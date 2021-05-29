package com.sunhongyu.cpaassite20210201.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunhongyu.cpaassite20210201.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

public class HelloController {
    @Autowired
    UserService userServicel;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("msg","更多内容请注册后登录");
        return "index";
    }


    @RequestMapping("/admin")
    public String admin(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if("anonymousUser".equals(principal)) {
            model.addAttribute("usercode","anonymous");
        }else {
            User user = (User)principal;

            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("username",user.getUsername());
            com.sunhongyu.cpaassite20210201.entity.User one = userServicel.getOne(queryWrapper);
            model.addAttribute("usercode",one.getUserCode());
        }

        return "admin";
    }



    @RequestMapping("/main")
    public String main(){
        return "page/main";
    }

    @RequestMapping("/404")
    public String p404(){
        return "page/404";
    }


   @RequestMapping("/login")
    public String login(){
    System.out.println("login");
    return "redirect:/admin";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "/";
    }


    @RequestMapping("/loginfail")
    public String loginfail(Model model){
        model.addAttribute("msg","用户或密码错误，登录失败");
        return "index";
    }
}
