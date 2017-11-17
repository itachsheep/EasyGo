package com.java.easygo.comm

import android.content.res.Resources

/**
 * Created by SDT14324 on 2017/11/17.
 */
class CommonUtil{
    companion object{
        public fun getResource(): Resources? {
            return App.getInstance()!!.resources
        }
    }
}