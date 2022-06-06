package com.example.try11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Login extends Activity {
    RadioButton r1,r2;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // 关联用户名、密码和登录、注册按钮
        EditText userName = (EditText) this.findViewById(R.id.UserNameEdit);
        EditText passWord = (EditText) this.findViewById(R.id.PassWordEdit);
        Button loginButton = (Button) this.findViewById(R.id.LoginButton);
        Button signUpButton = (Button) this.findViewById(R.id.SignUpButton);
        r1 = (RadioButton)findViewById(R.id.radioButton1);
        r2 = (RadioButton)findViewById(R.id.radioButton2);
        //-->将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);


        // 登录按钮监听器
        loginButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ExecutorService es = Executors.newFixedThreadPool(2) ;//基本信息
                        ExecutorService esuser = Executors.newFixedThreadPool(2) ;//用户基本信息
                        String strUserName = userName.getText().toString().trim();
                        String strPassWord = passWord.getText().toString().trim();
                        if(strUserName.equals("")||strPassWord.equals(""))
                        {
                            Toast.makeText(Login.this, "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
                        }
                        if (r1.isChecked()) {
                            id = "0";
                            WorkThread wd = new WorkThread(id,strUserName, strPassWord);
                            Future<String> ft = es.submit(wd);//基本信息

                            try {
                                if (ft.get().equals("faile")) {
                                    Toast.makeText(Login.this, "密码输入错误！", Toast.LENGTH_SHORT).show();
                                } else if (ft.get().equals("null")) {
                                    Toast.makeText(Login.this, "用户不存在！", Toast.LENGTH_SHORT).show();
                                } else if(ft.get().equals("未获取到网页内容!")){
                                    Toast.makeText(Login.this, "无网络！", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    //-->获取用户基本信息
                                    String[] all = ft.get().split(",");
                                    allInformation allma = new allInformation();
                                    allma.setUserId(all[0]);
                                    allma.setCardId(all[1]);
                                    allma.setName(all[2]);
                                    allApplication.addAllInformation(allma);
                                    //-->获取用户全部信息并保存
                                    WorkThreadUser wduser = new WorkThreadUser(all[1]);
                                    Future<String> ftuser = esuser.submit(wduser);
                                    String[] alluser = ftuser.get().split(",");
                                    allUserInformation alluma = new allUserInformation();
                                    alluma.setUserId(alluser[0]);
                                    alluma.setCardId(alluser[1]);
                                    alluma.setName(alluser[2]);
                                    alluma.setAge(alluser[3]);
                                    alluma.setPhone(alluser[4]);
                                    allApplication.addAllUserInformation(alluma);
                                    //-->获取用户卡的全部信息并保存
                                    WorkThreadCard wdcard = new WorkThreadCard(all[1]);
                                    Future<String> ftcard = esuser.submit(wdcard);
                                    String[] allcard = ftcard.get().split(",");
                                    allCardInformation allcma = new allCardInformation();
                                    allcma.setBalance(allcard[0]);
                                    allcma.setNet_charges(allcard[1]);
                                    allApplication.addAllCardInformation(allcma);
                                    Toast.makeText(Login.this, "登录成功！", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login.this, MainActivity.class);

                                    startActivity(intent);
                                }
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (r2.isChecked()) {
                            id = "1";
                            WorkThread wd = new WorkThread(id,strUserName, strPassWord);
                            Future<String> ft = es.submit(wd);//基本信息

                            try {
                               if (ft.get().equals("faile")) {
                                    Toast.makeText(Login.this, "密码输入错误！", Toast.LENGTH_SHORT).show();
                                } else if (ft.get().equals("null")) {
                                    Toast.makeText(Login.this, "用户不存在！", Toast.LENGTH_SHORT).show();
                                } else if(ft.get().equals("未获取到网页内容!")){
                                    Toast.makeText(Login.this, "无网络！", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(Login.this, "登录成功！", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login.this, admin.class);
                                    startActivity(intent);
                                }
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }


                        //Toast.makeText(Login.this, ""+result+"", Toast.LENGTH_SHORT).show();
                        // 判断如果用户名是123456 密码是123456就是登录成功
                        /*if (strUserName.equals("123456") && strPassWord.equals("123456")) {
                            Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "请输入正确的用户名或密码！", Toast.LENGTH_SHORT).show();
                        }*/

                    }

                }
        );
        // 注册按钮监听器
        signUpButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Login.this, Register.class);
                        startActivity(intent);
                    }
                }
        );
        RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup1);
        //第一种获得单选按钮值的方法
        //为radioGroup设置一个监听器:setOnCheckedChanged()
        radgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "你选了" + radbtn.getText(), Toast.LENGTH_LONG).show();
            }
        });


    }
    //-->基本信息
    private  class WorkThread  implements Callable<String>
    {
        String id,txt_1,txt_2;
        public WorkThread(String id,String txt_1,String txt_2){
            this.id = id;
            this.txt_1 = txt_1;
            this.txt_2 = txt_2;
        }
        @Override
        public  String call()
        {

            //使用SubmintResult，向servlet发送数据
            SubmintResult sr = new SubmintResult();
            String result = sr.requestInfo("http://150.158.26.45:8080/Test01/Login?id="+id+"&username="+txt_1+"&password="+txt_2+"");	//读取此网页，然后将网页内容读取下来

            return result;
        }
    }
    //-->用户基本信息
    private  class WorkThreadUser  implements Callable<String>
    {
        String txt_1;
        public WorkThreadUser(String card_id){
            this.txt_1 = card_id;
        }
        @Override
        public  String call()
        {

            //使用SubmintResult，向servlet发送数据
            SubmintResult sr = new SubmintResult();
            String result = sr.requestInfo("http://150.158.26.45:8080/Test01/Select?id=1&card_id="+txt_1+"");
            return result;
        }
    }

    //-->卡基本信息
    private  class WorkThreadCard  implements Callable<String>
    {
        String txt_1;
        public WorkThreadCard(String card_id){
            this.txt_1 = card_id;
        }
        @Override
        public  String call()
        {

            //使用SubmintResult，向servlet发送数据
            SubmintResult sr = new SubmintResult();
            String result = sr.requestInfo("http://150.158.26.45:8080/Test01/Select?id=0&card_id="+txt_1+"");
            return result;
        }
    }
}