package com.sunhongyu.cpaassite20210201.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {

    public static final String RETURN_TYPE = "html"; // 登录失败时，用来判断是返回json数据还是跳转html页面

    @Autowired
    private ObjectMapper objectMapper;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败:" + exception.getMessage());
        log.info("username=>" + request.getParameter("username"));

        if (RETURN_TYPE.equals("html")) {
            request.setAttribute("msg","登录失败!");
            redirectStrategy.sendRedirect(request, response, "/loginfail");
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("code","1002");
            map.put("msg","登录失败");
            map.put("data",exception.getMessage());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(map));
        }
    }
}