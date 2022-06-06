package com.example.try11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AboutUs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);
    }
}
