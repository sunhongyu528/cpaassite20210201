package com.sunhongyu.cpaassite20210201.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhongyu.cpaassite20210201.entity.Blacklist;
import com.sunhongyu.cpaassite20210201.service.BlacklistService;
import com.sunhongyu.cpaassite20210201.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 孙宏宇
 * @since 2021-03-10
 */
@Controller
@RequestMapping("/blacklist")
public class BlacklistController {
    @Autowired
    BlacklistService blacklistService;

    @ResponseBody
    @RequestMapping("/list1")
    public List<Blacklist> list(){
        return blacklistService.list(null);
    }

    @ResponseBody
    @RequestMapping("/list")
    public DataVO blacklist(Integer page, Integer limit){
        return blacklistService.findData(page,limit);
    }
    @ResponseBody
    @RequestMapping("/del")
    public String bldel(@RequestBody Map<String, String> map){
        Integer id = Integer.parseInt(map.get("id"));
        blacklistService.removeById(id);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(String calling){
        Blacklist blacklist=new Blacklist();
        blacklist.setCalling(calling);
        boolean b = blacklistService.save(blacklist);
        System.out.println(b);
        return "success";
    }

}
