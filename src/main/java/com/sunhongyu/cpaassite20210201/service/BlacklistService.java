package com.sunhongyu.cpaassite20210201.service;

import com.sunhongyu.cpaassite20210201.entity.Blacklist;
import com.baomidou.mybatisplus.extension.service.IService;

import com.sunhongyu.cpaassite20210201.vo.DataVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 孙宏宇
 * @since 2021-03-10
 */
public interface BlacklistService extends IService<Blacklist> {
    public DataVO<Blacklist> findData(Integer page, Integer limit);
}
