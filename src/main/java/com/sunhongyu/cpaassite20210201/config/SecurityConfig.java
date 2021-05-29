package com.sunhongyu.cpaassite20210201.config;

import com.sunhongyu.cpaassite20210201.handler.MyAccessDeniedHandler;
import com.sunhongyu.cpaassite20210201.handler.MyAuthenticationFailHandler;
import com.sunhongyu.cpaassite20210201.handler.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailHandler authenticationFailHandler;


    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwrd());
    }
    @Bean
    PasswordEncoder passwrd(){
        return new BCryptPasswordEncoder();
    }
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
            .headers().frameOptions().disable()
                .and()
            .formLogin()
                //自动定义登录界面
                .loginPage("/")
                //自定义登录from action接口
                .loginProcessingUrl("/login")
                //登录后成功界面
               .successForwardUrl("/admin")
                //.successHandler(authenticationSuccessHandler)
                //登录失败界面
                //.failureForwardUrl("/")
                .failureHandler(authenticationFailHandler)
                .and()
            .authorizeRequests()
                .antMatchers("/**/*.js", "/**/*.css", "/**/images/**/*.*","/**/fonts/**").permitAll() // 静态资源放行
                .antMatchers("/","/login","/loginfail").permitAll()
                //所以资源必须验证
                .anyRequest().authenticated();
        //异常处理
        http.exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);


    }
    @Override
    public void configure(WebSecurity web) {
        //将项目中静态资源路径开放出来
        web.ignoring().antMatchers("/config/**", "/css/**", "/fonts/**", "/img/**", "/js/**");
    }
}
