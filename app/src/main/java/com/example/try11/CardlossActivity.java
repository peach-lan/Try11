package com.example.try11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CardlossActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardloss);

        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);
    }
}
