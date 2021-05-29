package com.sunhongyu.cpaassite20210201.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping(value = "news/{content}")
    public String news(@PathVariable String content){
        return "page/news/"+content;
    }
    @RequestMapping("img/{content}")
    public String img(@PathVariable String content){
        return "page/img/"+content;
    }

    @RequestMapping("breeze/{content}")
    public String breeze(@PathVariable String content){
        return "page/breeze/"+content;
    }
    @RequestMapping("systemSetting/{content}")
    public String systemSetting(@PathVariable String content){
        return "page/systemSetting/"+content;
    }
    @RequestMapping("doc/{content}")
    public String doc(@PathVariable String content){
        return "page/doc/"+content;
    }
}
