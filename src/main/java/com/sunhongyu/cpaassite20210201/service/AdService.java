package com.sunhongyu.cpaassite20210201.service;


import com.sunhongyu.cpaassite20210201.vo.DataADPersonVO;
import com.sunhongyu.cpaassite20210201.vo.DataVO;

public interface AdService {

    public DataVO<DataADPersonVO> findlist();

    public DataVO<DataADPersonVO> pageFindlist(Integer page, Integer limit);

}
