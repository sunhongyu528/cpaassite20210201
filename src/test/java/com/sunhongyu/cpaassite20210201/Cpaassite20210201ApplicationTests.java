package com.sunhongyu.cpaassite20210201;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Cpaassite20210201ApplicationTests {

    @Test
    void contextLoads() {

        String str1="tran=MYD;caller=69015;ucid=12345040881615946360;called=019127244879;agid=30938 1en=68";
        String[] strs=str1.split(";");
        for (String s:strs)
        {
            System.out.println(s);
        }
        String str2 = strs[4];
        System.out.println(str2);
        String[] strs2=str2.split(" ");
        String str3=strs2[0].substring(5);
        System.out.println(str3);

    }

}
