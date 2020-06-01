package com.example.fraem;

import io.reactivex.disposables.Disposable;

/**
 * 作者：Leishen  秦宇
 * 创建于： 2020/5/31 21:12
 * 作者邮箱：1623060075@qq.com
 */

public interface CommonPresenter<P>extends CommonView {
    void getData(int Whichapi,P... pP);
    void addDisposeable(Disposable disposable);
}
