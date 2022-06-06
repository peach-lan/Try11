package com.example.try11;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class bankcard_handle extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_bankcard);
        ImageView back=(ImageView)findViewById(R.id.back);

        back.setOnClickListener(new myClick());

        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);
    }
    class myClick implements View.OnClickListener{
        public void onClick(View v){
            Intent intent=new Intent(bankcard_handle.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
