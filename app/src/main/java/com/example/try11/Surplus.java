package com.example.try11;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

public class Surplus extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surplus_layout);

        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);
    }
}