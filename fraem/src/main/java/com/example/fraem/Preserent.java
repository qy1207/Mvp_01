package com.example.fraem;

import android.view.View;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * 作者：Leishen  秦宇
 * 创建于： 2020/5/31 21:18
 * 作者邮箱：1623060075@qq.com
 */

public class Preserent<V extends CommonView, M extends CommonModel> implements CommonPresenter {
    private SoftReference<V> mView;
    private SoftReference<M> mModle;
    private final List<Disposable> objects;

    public Preserent(V View, M Modle) {
        mView = new SoftReference<>(View);
        mModle = new SoftReference<>(Modle);
        objects = new ArrayList<>();
    }

    @Override
    public void getData(int Whichapi, Object... pP) {
        if (mModle != null && mModle.get() != null) mModle.get().getData(this, Whichapi, pP);
    }

    @Override
    public void addDisposeable(Disposable disposable) {
        objects.add(disposable);
    }

    @Override
    public void OnSuccess(int Whichapi, int LoadType, Object... pV) {
        if (mView != null && mView.get() != null) mView.get().OnSuccess(Whichapi, LoadType, pV);
    }

    @Override
    public void OnFailed(int Whichapi, Throwable pthrowable) {
        if (mView != null && mView.get() != null) mView.get().OnFailed(Whichapi, pthrowable);
    }

    public void clear() {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i) != null) {
                objects.get(i).dispose();
            }
        }
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        if (mModle != null) {
            mModle.clear();
            mModle = null;
        }
    }
}
