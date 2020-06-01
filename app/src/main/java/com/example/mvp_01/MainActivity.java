package com.example.mvp_01;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.data.InfoBean;
import com.example.fraem.ApiConfig;
import com.example.fraem.CommonModel;
import com.example.mvp_01.adapter.TestAdapter;
import com.example.mvp_01.base.BaseMvpActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.fraem.LoadTyeConfig;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity {

    @BindView(R.id.recyc)
    RecyclerView recyc;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private TestAdapter testAdapter;
    private int page = 0;
    private List<InfoBean.DatasBean> datas;
    private HashMap<String, String> hashMap;

    @Override
    protected void initData() {
        hashMap = new HashMap();
        hashMap.put("c", "api");
        hashMap.put("a", "getList");
        preserent.getData(ApiConfig.Test, LoadTyeConfig.MORE, hashMap, page);
        preserent.getData(ApiConfig.Test,LoadTyeConfig.NONE,hashMap, page);
    }

    @Override
    protected void initView() {

        //  datas = new ArrayList<>();

        initRecycLatout(recyc, smart, new DataListener() {
            @Override
            public void State(int type) {
                switch (type) {
                    case LoadTyeConfig.MORE:
                      preserent.getData(ApiConfig.Test, LoadTyeConfig.NONE, hashMap, page);
                        break;
                    case LoadTyeConfig.REFRESH:
                       preserent.getData(ApiConfig.Test, LoadTyeConfig.REFRESH, hashMap, page);
                        break;
                }
            }
        });
        datas = new InfoBean().getDatas();
        testAdapter = new TestAdapter(this.datas, this);
        recyc.setAdapter(testAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected CommonModel initModel() {
        return new Model();
    }

    @Override
    protected void netSuccess(int Whichapi, int LoadType, Object[] pV) {
        switch (Whichapi) {
            case ApiConfig.Test:
                if (LoadType == LoadTyeConfig.MORE) {
                    smart.finishLoadMore();
                } else if (LoadType == LoadTyeConfig.REFRESH) {
                    smart.finishRefresh();
                }
                // datas = ((InfoBean) pV[0]).getDatas();
               List<InfoBean.DatasBean> beans = ((InfoBean) pV[0]).getDatas();
                this.datas.addAll(beans);
                testAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    protected void onFail(int Whichapi, Throwable pthrowable) {

    }


}
