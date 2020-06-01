package com.example.fraem;

/**
 * 作者：Leishen  秦宇
 * 创建于： 2020/5/31 21:35
 * 作者邮箱：1623060075@qq.com
 */

public class ServiceConfig {
    private static final int SERVICE_TYPE = 1;
    public static String BASE_URL = "";

    static {
        switch (SERVICE_TYPE) {
            case 1:
                BASE_URL="http://www.wanandroid.com/";
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

}
