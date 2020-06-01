package com.example.mvp_01;

import com.example.fraem.ApiConfig;
import com.example.fraem.CommonModel;
import com.example.fraem.CommonPresenter;
import com.example.fraem.NetWork;

import java.util.Map;

/**
 * 作者：Leishen  秦宇
 * 创建于： 2020/5/31 21:24
 * 作者邮箱：1623060075@qq.com
 */

public class Model implements CommonModel {
    NetWork netWork=NetWork.getInstance();
    @Override
    public void getData(CommonPresenter commonPresenter, int Whichapi, Object[] m) {
        if (ApiConfig.Test==1){
            final  int o= (int) m[0];
            Map o1= (Map) m[1];
            int o2= (int) m[2];
            netWork.getRetrofit(netWork.getApiService().egtInfoBean(o1,o2),commonPresenter,Whichapi,o);
        }


    }
}
