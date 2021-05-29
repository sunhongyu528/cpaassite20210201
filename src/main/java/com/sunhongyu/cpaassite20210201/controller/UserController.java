package com.sunhongyu.cpaassite20210201.controller;


import com.sunhongyu.cpaassite20210201.entity.User;
import com.sunhongyu.cpaassite20210201.service.UserService;
import com.sunhongyu.cpaassite20210201.utils.PinYinUtil;
import com.sunhongyu.cpaassite20210201.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 孙宏宇
 * @since 2021-02-03
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/useradd")
    @ResponseBody
    public String useradd(String usercode,String email,String password,String phone,String role){
        System.out.println("abcd"+usercode+email);
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(password);
        System.out.println(encode);
        String username= PinYinUtil.getPinyin(usercode);
        String perms="user:view";
        String status="1";
        User user = new User();
        user.setUserCode(usercode);
        user.setUsername(username);
        user.setUserEmail(email);
        user.setPassword(encode);
        user.setUserPhone(phone);
        user.setUserPermission(perms);
        user.setUserRole(role);
        user.setUserStatus(status);
        boolean b = userService.save(user);
        System.out.println(b);
        return "success";
    }

    @RequestMapping("/userdel")
    @ResponseBody
    public String userdel(@RequestBody Map<String, String> map){
        // if(map.containsKey("id")){
        Integer id = Integer.parseInt(map.get("id"));
        User user = userService.getById(id);
        System.out.println(user);
        boolean b = userService.removeById(id);
        System.out.println(b);
        //}



        return "success";

    }

    @RequestMapping("/userList")
    public String userList(){
        return "page/user/userList";
    }

    @RequestMapping("/userlist")
    @ResponseBody
    public DataVO userlist(Integer page, Integer limit){
        return userService.findData(page,limit);
    }


    @RequestMapping("/list")
    @ResponseBody
    public DataVO userlist1(){
      return userService.listDate();
    }
}
