package com.sunhongyu.cpaassite20210201;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhongyu.cpaassite20210201.entity.Blacklist;
import com.sunhongyu.cpaassite20210201.entity.User;
import com.sunhongyu.cpaassite20210201.service.BlacklistService;
import com.sunhongyu.cpaassite20210201.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisTest {
    @Autowired
    UserService userService;
    @Autowired
    BlacklistService blacklistService;
    @Test
    void test1(){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("username","admin");
        User user = userService.getOne(queryWrapper);
        System.out.println(user);
        String role=user.getUserRole();
        System.out.println(role);
    }
    @Test
    void test2(){
        List<Blacklist> list = blacklistService.list();
        System.out.println(list);

    }
    @Test
    void test3() {
        QueryWrapper<Blacklist> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        IPage<Blacklist> page=new Page<>(1,5);
        IPage<Blacklist> page1 = blacklistService.page(page, queryWrapper);
        System.out.println("***********************");
        System.out.println(page1.toString());
    }
}




