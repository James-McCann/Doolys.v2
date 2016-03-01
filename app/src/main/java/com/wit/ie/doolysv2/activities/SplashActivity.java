package com.wit.ie.doolysv2.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.wit.ie.doolysv2.R;



public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                nextActivity();
                finish();
            }
        }, 3000);
        //http://stackoverflow.com/questions/20765484/andengine-handler-postdelayed-doesnt-work

    }


    //simple method to invoke Login activity
    public void nextActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
