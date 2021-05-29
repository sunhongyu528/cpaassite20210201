package com.sunhongyu.cpaassite20210201.service.impl;

import com.sunhongyu.cpaassite20210201.entity.Blacklist;
import com.sunhongyu.cpaassite20210201.entity.User;
import com.sunhongyu.cpaassite20210201.mapper.BlacklistMapper;
import com.sunhongyu.cpaassite20210201.service.BlacklistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.sunhongyu.cpaassite20210201.utils.BLPageUtils;
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
 * @since 2021-03-10
 */
@Service
public class BlacklistServiceImpl extends ServiceImpl<BlacklistMapper, Blacklist> implements BlacklistService {
    @Autowired
    BlacklistMapper blacklistMapper;


    @Override
    public DataVO<Blacklist> findData(Integer page, Integer limit) {

        DataVO dataVo = new DataVO();
        dataVo.setCode(0);
        dataVo.setMsg("");
        dataVo.setCount(blacklistMapper.selectCount(null));


        List<Blacklist> alluBL =blacklistMapper.selectList(null);
        List<Blacklist> blList = BLPageUtils.pageBySubList(alluBL, limit, page);
        List<Blacklist> blacklistsVoList=new ArrayList<>();
        for(Blacklist blacklist:alluBL){
            Blacklist blacklist1=new Blacklist();
            BeanUtils.copyProperties(blacklist,blacklist1);
           blacklistsVoList.add(blacklist1);
        }


        dataVo.setData(blacklistsVoList);

        return dataVo;
    }
}
