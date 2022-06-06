package com.example.try11;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class second extends AppCompatActivity {
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image=(ImageView)findViewById(R.id.img2);
        txt=(TextView)findViewById(R.id.txt2);
        image.setOnClickListener(new myClick());

        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);
    }
    class myClick implements View.OnClickListener{
        public void onClick(View v){
            txt.setText("第二个界面");
        }
    }
}
