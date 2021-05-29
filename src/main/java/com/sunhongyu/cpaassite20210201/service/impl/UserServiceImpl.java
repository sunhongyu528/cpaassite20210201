package com.sunhongyu.cpaassite20210201.service.impl;

import com.sunhongyu.cpaassite20210201.entity.User;
import com.sunhongyu.cpaassite20210201.mapper.UserMapper;
import com.sunhongyu.cpaassite20210201.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunhongyu.cpaassite20210201.utils.UserPageUtils;
import com.sunhongyu.cpaassite20210201.vo.DataUserVO;
import com.sunhongyu.cpaassite20210201.vo.DataVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 孙宏宇
 * @since 2021-02-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public DataVO<DataUserVO> findData(Integer page, Integer limit) {
        DataVO dataVo = new DataVO();
        dataVo.setCode(0);
        dataVo.setMsg("");
        dataVo.setCount(userMapper.selectCount(null));
        List<User> allusers = userMapper.selectList(null);
        List<User> userList = UserPageUtils.pageBySubList(allusers, limit, page);
        List<DataUserVO> userVoList=new ArrayList<>();
        for (User user:userList){
            DataUserVO userVo=new DataUserVO();
            BeanUtils.copyProperties(user,userVo);
            userVoList.add(userVo);

        }

        dataVo.setData(userVoList);

        return dataVo;
    }

    @Override
    public DataVO<DataUserVO> listDate() {
        DataVO dataVo = new DataVO();
        dataVo.setCode(0);
        dataVo.setMsg("");
        dataVo.setCount(userMapper.selectCount(null));
        List<User> allusers = userMapper.selectList(null);

        List<DataUserVO> userVoList=new ArrayList<>();
        for (User user:allusers){
            DataUserVO userVo=new DataUserVO();
            BeanUtils.copyProperties(user,userVo);
            userVoList.add(userVo);
        }
        dataVo.setData(userVoList);
        return dataVo;
    }


}
