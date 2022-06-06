package com.example.try11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Register extends Activity {
    // 调用Actvity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);//关联activity_register.xml
        // 关联用户名、密码、年龄，学号，电话号码
        EditText userName = (EditText) this.findViewById(R.id.UserNameEdit);
        EditText passWord = (EditText) this.findViewById(R.id.PassWordEdit);
        EditText age = (EditText) this.findViewById(R.id.ageEdit);
        EditText stunum = (EditText) this.findViewById(R.id.stuNumEdit);
        EditText phone = (EditText) this.findViewById(R.id.phoneEdit);

        Button signUpButton = (Button) this.findViewById(R.id.SignUpButton);
        Button backLoginButton = (Button) this.findViewById(R.id.BackLoginButton);

        // 注册按钮监听器
        signUpButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //-->获取输入的信息
                        String strUserName = userName.getText().toString().trim();
                        String strPassWord = passWord.getText().toString().trim();
                        String strage = age.getText().toString().trim();
                        String strstunum = stunum.getText().toString().trim();
                        String strPhone = phone.getText().toString().trim();

                        //-->注册格式粗检
                        if (strUserName.equals("")||strPassWord.equals("")||strage.equals("")||strstunum.equals("")||strPhone.equals("")){
                            Toast.makeText(Register.this, "输入内容不能为空！", Toast.LENGTH_SHORT).show();
                        }
                        else if (strUserName.length() > 10) {
                            Toast.makeText(Register.this, "用户名长度必须小于10！", Toast.LENGTH_SHORT).show();
                        } else if (strUserName.length() < 3) {
                            Toast.makeText(Register.this, "用户名长度必须大于3！", Toast.LENGTH_SHORT).show();
                        } else if (strPassWord.length() > 16) {
                            Toast.makeText(Register.this, "密码长度必须小于16！", Toast.LENGTH_SHORT).show();
                        } else if (strPassWord.length() < 6) {
                            Toast.makeText(Register.this, "密码长度必须大于6！", Toast.LENGTH_SHORT).show();
                        } else if (strPhone.length() != 11) {
                            Toast.makeText(Register.this, "电话号码必须是11位！", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            ExecutorService es = Executors.newFixedThreadPool(2) ;
                            WorkThread wd1 = new WorkThread(strUserName,strPassWord,strage,strstunum,strPhone);
                            Future<String> ft = es.submit(wd1);
                            try {
                                //-->判断是否注册成功
                                if (ft.get().equals("0")){
                                    Toast.makeText(Register.this, "学号已经存在！", Toast.LENGTH_SHORT).show();
                                }
                                else if (ft.get().equals("1")){
                                    System.out.println(ft.get());
                                    Toast.makeText(Register.this, "注册成功！", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Register.this, Login.class);
                                    startActivity(intent);
                                }
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );



        // 注册按钮监听器
        backLoginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Register.this, Login.class);
                        startActivity(intent);
                    }
                }
        );


    }
    //工作线程
    private  class WorkThread  implements Callable<String>
    {
        String txt_1,txt_2,txt_3,txt_4,txt_5;
        public WorkThread(String txt_1,String txt_2,String txt_3,String txt_4,String txt_5){
            this.txt_1 = txt_1;
            this.txt_2 = txt_2;
            this.txt_3 = txt_3;
            this.txt_4 = txt_4;
            this.txt_5 = txt_5;

        }
        @Override
        public  String call()
        {

            //使用SubmintResult，向servlet发送数据
            SubmintResult sr = new SubmintResult();
            String result = sr.requestInfo("http://150.158.26.45:8080/Test01/Registered?student_name="+txt_1+"&user_pwd="+txt_2+"&age="+txt_3+"&student_id="+txt_4+"&phone_num="+txt_5+"");	//读取此网页，然后将网页内容读取下来
            //System.out.println(result);
            return result;
        }
    }
}