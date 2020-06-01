package com.example.fraem;

import com.example.data.InfoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * 作者：Leishen  秦宇
 * 创建于： 2020/5/31 20:58
 * 作者邮箱：1623060075@qq.com
 */

public interface ApiService {
    //http://www.wanandroid.com/project/list/1/json?cid=294
    //http://static.owspace.com/?c=api&a=getList&page_id=0
        @GET(".")
    Observable<InfoBean>egtInfoBean(@QueryMap Map<String,String>map,@Query("page_id")int id);
}
