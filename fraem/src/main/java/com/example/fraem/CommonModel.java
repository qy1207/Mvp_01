package com.example.fraem;
/**
 * 作者：Leishen  秦宇
 * 创建于： 2020/5/31 21:16
 * 作者邮箱：1623060075@qq.com
 */

public interface CommonModel<M> {
    void getData(CommonPresenter commonPresenter,int Whichapi,M...m);
}
