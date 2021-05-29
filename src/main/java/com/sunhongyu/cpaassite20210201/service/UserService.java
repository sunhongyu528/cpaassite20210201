package com.sunhongyu.cpaassite20210201.service;

import com.sunhongyu.cpaassite20210201.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sunhongyu.cpaassite20210201.vo.DataUserVO;
import com.sunhongyu.cpaassite20210201.vo.DataVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 孙宏宇
 * @since 2021-02-03
 */
public interface UserService extends IService<User> {
    public DataVO<DataUserVO> findData(Integer page, Integer limit);
    public DataVO<DataUserVO>  listDate();
}
