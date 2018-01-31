package com.java.easygo.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.java.easygo.R;
import com.java.easygo.comm.ImageurlUtils;
import com.java.easygo.databinding.ActivityTransitionBinding;

import java.util.Random;

/**
 * Created by SDT14324 on 2017/12/7.
 */

public class TransitionActivity extends AppCompatActivity {
    private ActivityTransitionBinding mbinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_transition);

        showDefaultPic();
        showNetPic();
        goToMain();
    }



    private void goToMain(){
        new Handler().postDelayed(() -> { startMain();}, 3500);
    }

    private void startMain(){
        Intent intent = new Intent(TransitionActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showNetPic(){
        new Handler().postDelayed(() -> {hideDefultPic();}, 1500);
    }
    private void hideDefultPic(){
        mbinding.ivDefault.setVisibility(View.GONE);
    }

    private void showDefaultPic() {
        int num = new Random().nextInt(ImageurlUtils.TRANSITION_URLS.length);
        mbinding.ivDefault.setImageDrawable(getResources().getDrawable(R.drawable.img_transition_default));
        Glide.with(this)
                .load(ImageurlUtils.TRANSITION_URLS[num])
                .placeholder(R.drawable.img_transition_default)
                .error(R.drawable.img_transition_default)
                .into(mbinding.ivPic);
    }
}
