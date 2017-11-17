package com.java.easygo.comm

import android.app.Application

/**
 * Created by SDT14324 on 2017/11/17.
 */
class App : Application(){
    companion object {
        private var app: App? = null

        public fun getInstance(): App? {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this

    }
}