package com.example.fraem;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：Leishen  秦宇
 * 创建于： 2020/5/31 21:27
 * 作者邮箱：1623060075@qq.com
 */

public class NetWork {
    private static NetWork netWork;
    public NetWork(){

    }
    public static NetWork getInstance() {
        if (netWork == null) {
            synchronized (NetWork.class) {
                    netWork = new NetWork();
            }
        }
        return netWork;
    }
    public<T> ApiService getApiService(T...t) {
        String baseUrl = ServiceConfig.BASE_URL;
        if ( t != null &&t.length != 0) {
            baseUrl = (String) t[0];
        }
     return    new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class);
    }
    public <T> void getRetrofit(Observable<T> observable,CommonPresenter commonPresenter,int Which,int loadType){
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObservable() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        commonPresenter.addDisposeable(d);
                    }
                    @Override
                    public void Success(Object o) {
                        commonPresenter.getData(Which,loadType,o);
                    }

                    @Override
                    public void Failed(Throwable e) {
                    commonPresenter.OnFailed(Which,e);
                    }
                });
    }
}















































