package com.java.easygo.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.java.easygo.R
import com.java.easygo.comm.ImageurlUtil
import com.java.easygo.databinding.ActivityTransitionBinding
import java.util.*

/**
 * Created by SDT14324 on 2017/11/17.
 */
class TransitionActivity : AppCompatActivity() {


    private var mbinding: ActivityTransitionBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_transition)

        showDefaultPic()

        showNetPic()
    }

    private fun showNetPic(){
        Handler().postDelayed()
    }

    private fun showDefaultPic() {
        var num = Random().nextInt(ImageurlUtil.TRANSITION_URLS.size)
        mbinding?.ivDefault?.setImageDrawable(resources?.getDrawable(R.drawable.img_transition_default))
        Glide.with(this)
                .load(ImageurlUtil.TRANSITION_URLS[num])
                .placeholder(R.drawable.img_transition_default)
                .error(R.drawable.img_transition_default)
                .into(mbinding?.ivPic)
    }
}