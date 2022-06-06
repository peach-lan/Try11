package com.example.try11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class serlver_report_handle extends Activity {
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.server_report);
        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new myclick());

        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);
    }
    class myclick implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if (v==back){
                Intent intent=new Intent(serlver_report_handle.this,MainActivity.class);
                startActivity(intent);
            }
        }
    }
}

