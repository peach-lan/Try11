package com.example.try11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CarduncouplingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carduncoupling);

        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);
    }
}
