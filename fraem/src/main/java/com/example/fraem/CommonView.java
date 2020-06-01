package com.example.fraem;
/**
 * 作者：Leishen  秦宇
 * 创建于： 2020/5/31 21:06
 * 作者邮箱：1623060075@qq.com
 */

public interface CommonView<V> {
    void OnSuccess(int Whichapi,int LoadType,V...pV);
    void OnFailed(int Whichapi,Throwable pthrowable);
}
