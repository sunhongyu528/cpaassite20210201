package com.sunhongyu.cpaassite20210201.service.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunhongyu.cpaassite20210201.entity.Role;
import com.sunhongyu.cpaassite20210201.entity.User;
import com.sunhongyu.cpaassite20210201.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        if(username==null||"".equals(username)){
            throw new RuntimeException("用户不能为空！");
        }
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",username);
        User user = userService.getOne(queryWrapper);
        System.out.println(user);
        if(user==null){
            throw new RuntimeException("用户不存在！");
        }
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getUserRole());
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(grantedAuthority);

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
