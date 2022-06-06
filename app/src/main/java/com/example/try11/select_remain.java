package com.example.try11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class select_remain  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_balancequery);
        ImageView back=(ImageView)findViewById(R.id.back);
        TextView remain_name = findViewById(R.id.remain_name);
        back.setOnClickListener(new myClick());

        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);
        remain_name.setText(allApplication.kList.get(0).getBalance());
    }
    class myClick implements View.OnClickListener{
        public void onClick(View v){
            Intent intent=new Intent(select_remain.this,MainActivity.class);
            startActivity(intent);
        }
    }
}

