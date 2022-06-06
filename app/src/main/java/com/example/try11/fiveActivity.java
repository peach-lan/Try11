package com.example.try11;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class fiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这个是获取布局文件的，这里是你下一个页面的布局文件
        setContentView(R.layout.activity_five);

        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);
    }
}
