package com.sunhongyu.cpaassite20210201;

import com.sunhongyu.cpaassite20210201.entity.User;
import com.sunhongyu.cpaassite20210201.service.UserService;
import com.sunhongyu.cpaassite20210201.vo.DataUserVO;
import com.sunhongyu.cpaassite20210201.vo.DataVO;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTes {
    @Autowired
    private UserService userService;

    @Test
    void test1(){
        DataVO<DataUserVO> data = userService.findData(1, 3);
        System.out.println(data);
    }

    @Test
    void test2(){
        DataVO<DataUserVO> dataUserVODataVO = userService.listDate();
        System.out.println(dataUserVODataVO);
    }
}
