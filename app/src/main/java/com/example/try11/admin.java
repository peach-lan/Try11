package com.example.try11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class admin extends AppCompatActivity {
    private Button button1,button2,button3;
    private TextView text_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        text_2=findViewById(R.id.text_2);
        button1.setOnClickListener(new users());
        button1.setOnClickListener(new cards());
        button1.setOnClickListener(new consume());
        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);

    }
    //-->查询用户信息
    class users implements View.OnClickListener{
        public void onClick(View v){

        }
    }
    //-->查询卡信息
    class cards implements View.OnClickListener{
        public void onClick(View v){

        }
    }
    //-->查询消费记录
    class consume implements View.OnClickListener{
        public void onClick(View v){

        }
    }

}
