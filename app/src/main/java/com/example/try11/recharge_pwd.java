package com.example.try11;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class recharge_pwd extends AppCompatActivity {
    public EditText oldPwd,newPwd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_re_change_pass);

        ImageView back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new myClick());
        Button bt_2_sure = findViewById(R.id.bt_2_sure);
        oldPwd = findViewById(R.id.OldPwd);
        newPwd = findViewById(R.id.NewPwd);
        bt_2_sure.setOnClickListener(new recharge_pwd.Listener());

        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);
    }

    class Listener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            String OldPwd = oldPwd.getText().toString().trim();
            String NewPwd = newPwd.getText().toString().trim();
            //-->检测
            if (OldPwd.equals("")||NewPwd.equals("")){
                Toast.makeText(recharge_pwd.this, "输入内容不能为空！", Toast.LENGTH_SHORT).show();
            }else if (NewPwd.length() > 16) {
                Toast.makeText(recharge_pwd.this, "密码长度必须小于16！", Toast.LENGTH_SHORT).show();
            }else if (NewPwd.length() < 6) {
                Toast.makeText(recharge_pwd.this, "密码长度必须大于6！", Toast.LENGTH_SHORT).show();
            }else {
                ExecutorService es = Executors.newFixedThreadPool(2) ;//基本信息
                WorkThread wd = new WorkThread(allApplication.mList.get(0).getUserId(),OldPwd,NewPwd);
                Future<String> ft = es.submit(wd);//基本信息
                try {
                    if (ft.get().equals("1")){
                        Intent intent=new Intent(recharge_pwd.this,Login.class);
                        startActivity(intent);
                    }
                    else if (ft.get().equals("0")){
                        Toast.makeText(recharge_pwd.this, "请输入正确的旧密码！", Toast.LENGTH_SHORT).show();
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class myClick implements View.OnClickListener{
        public void onClick(View v){
            Intent intent=new Intent(recharge_pwd.this,MainActivity.class);
            startActivity(intent);
        }
    }
    //-->密码信息
    private  class WorkThread  implements Callable<String>
    {
        String student_id,txt_1,txt_2;
        public WorkThread(String student_id,String txt_1,String txt_2){
            this.student_id = student_id;
            this.txt_1 = txt_1;
            this.txt_2 = txt_2;

        }
        @Override
        public  String call()
        {

            //使用SubmintResult，向servlet发送数据
            SubmintResult sr = new SubmintResult();
            String result = sr.requestInfo("http://150.158.26.45:8080/Test01/UpdatePwd?student_id="+student_id+"&old_pwd="+txt_1+"&new_pwd="+txt_2+"");	//读取此网页，然后将网页内容读取下来
            return result;
        }
    }
}


