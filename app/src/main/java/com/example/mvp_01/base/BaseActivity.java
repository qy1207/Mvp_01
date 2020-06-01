package com.example.mvp_01.base;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fraem.LoadTyeConfig;
import com.example.mvp_01.DataListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

/**
 * 作者：Leishen  秦宇
 * 创建于： 2020/5/31 21:55
 * 作者邮箱：1623060075@qq.com
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void initRecycLatout(RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, DataListener dataListener){
        if (recyclerView!=null)recyclerView.setLayoutManager(new LinearLayoutManager(this));
            if (smartRefreshLayout!=null&&dataListener!=null){
                smartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
                    @Override
                    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                        dataListener.State(LoadTyeConfig.MORE);
                    }

                    @Override
                    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                        dataListener.State(LoadTyeConfig.REFRESH);
                    }
                });
            }
    }
//    public void showLog(String msg){
//        Log.i("tag", "showLog: "+msg);
//
//    }
}
