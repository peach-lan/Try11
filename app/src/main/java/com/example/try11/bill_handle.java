package com.example.try11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bill_handle extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_bill);
        ImageView back=(ImageView)findViewById(R.id.back);
        //ListView txt = findViewById(R.id.history_lv);
        back.setOnClickListener(new myClick());
        //txt.setText("");
        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);

    }

    class myClick implements View.OnClickListener{
        public void onClick (View v) {
            Intent intent = new Intent(bill_handle.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
