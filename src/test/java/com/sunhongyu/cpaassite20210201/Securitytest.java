package com.sunhongyu.cpaassite20210201;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class Securitytest {


    @Test
    public void test3(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("Avaya123");
        System.out.println(encode);
        //$2a$10$9mChc4j668Lg833MQWeToOITVMfb4oXf1hM4SpUah7WtwZWGwaWWq

    }

    @Test
    public void test4(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches("Avaya123", "$2a$10$9mChc4j668Lg833MQWeToOITVMfb4oXf1hM4SpUah7WtwZWGwaWWq");
        System.out.println(matches);

    }
}
