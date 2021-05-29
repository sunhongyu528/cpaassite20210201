package com.sunhongyu.cpaassite20210201;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.sunhongyu.cpaassite20210201.mapper")
@EnableTransactionManagement

public class Cpaassite20210201Application {

    public static void main(String[] args) {
        SpringApplication.run(Cpaassite20210201Application.class, args);
    }


}
