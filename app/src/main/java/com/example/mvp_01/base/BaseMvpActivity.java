package com.example.mvp_01.base;

import android.os.Bundle;
import android.text.TextUtils;

import com.example.fraem.CommonModel;
import com.example.fraem.CommonView;
import com.example.fraem.Preserent;
import com.example.mvp_01.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseMvpActivity<M extends CommonModel> extends BaseActivity implements CommonView {
    M model;
    public Preserent preserent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
       ButterKnife.bind(this);
        model = initModel();
        preserent = new Preserent(this, model);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayout();

    protected abstract M initModel();

    protected abstract void netSuccess(int Whichapi, int LoadType, Object[] pV);
    protected abstract void onFail(int Whichapi, Throwable pthrowable);


    @Override
    public void OnSuccess(int Whichapi, int LoadType, Object[] pV) {
        netSuccess(Whichapi, LoadType, pV);
    }

    @Override
    public void OnFailed(int Whichapi, Throwable pthrowable) {
      //  showLog(Whichapi+"error-content"+pthrowable!=null|| TextUtils.isEmpty(pthrowable.getMessage())?"不明错误类型":pthrowable.getMessage());
        onFail(Whichapi, pthrowable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        preserent.clear();
    }
}
