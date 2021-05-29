package com.sunhongyu.cpaassite20210201.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class DataUserVO {
    private Integer userId;

    private String userCode;

    private String username;

    private String userEmail;

    private String userStatus;

    private String userPhone;

    private Date createTime;

    private Date loginTime;

    private Date updateTime;

    private String userRole;

    private String userPermission;
}
