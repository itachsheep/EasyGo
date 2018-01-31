package com.java.easygo.util;

import android.util.Log;

/**
 * Created by SDT14324 on 2018/1/31.
 */

public class LogUtils {
    private static String TAG = "EasyGo";
    public static void i(String tag,String mes){
        Log.i(TAG,tag+"."+mes);
    }
}
