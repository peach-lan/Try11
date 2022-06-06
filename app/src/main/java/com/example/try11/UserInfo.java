package com.example.try11;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.Calendar;

public class UserInfo extends Activity {

    private AlertDialog dlg;
    private TextView tv_user;
    private ImageView btn_user;

    private AlertDialog dlg_num;
    private TextView tv_num;
    private ImageView btn_num;

    private AlertDialog dlg_phone;
    private TextView tv_phone;
    private ImageView btn_phone;

    private AlertDialog dlg_label;
    private TextView tv_label;
    private ImageView btn_label;

    private ImageButton btn_help;
    private ImageButton btn_about;
    private Button btn_exit,btn_de;


    private AlertDialog dlg_sex;
    private TextView tv_sex;
    private ImageView btn_sex;
    private int flag=0;
    private int choice=0;

    private TextView tv_birth;
    private ImageView btn_birth;
    private DatePickerDialog dlg_birth;

    private  TextView tv_lable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);

        tv_user=findViewById(R.id.tv_user);
        btn_user=findViewById(R.id.btn_user);
        tv_num=findViewById(R.id.tv_num);
        btn_num=findViewById(R.id.btn_num);
        tv_phone=findViewById(R.id.tv_phone);
        btn_phone=findViewById(R.id.btn_phone);
        tv_label=findViewById(R.id.tv_lable);
        btn_label=findViewById(R.id.btn_lable);
        tv_sex=findViewById(R.id.tv_sex);
        btn_sex=findViewById(R.id.btn_sex);
        tv_birth=findViewById(R.id.tv_birth);
        btn_birth=findViewById(R.id.btn_birth);
        btn_help=findViewById(R.id.btn_help);
        btn_about=findViewById(R.id.btn_about);
        btn_exit=findViewById(R.id.btn_exit);
        btn_de=findViewById(R.id.btn_de);
        tv_lable=findViewById(R.id.tv_lable);

        UserInfo.Listener listener=new UserInfo.Listener();
        btn_user.setOnClickListener(listener);
        btn_num.setOnClickListener(listener);
        btn_phone.setOnClickListener(listener);
        btn_label.setOnClickListener(listener);
        btn_sex.setOnClickListener(listener);
        btn_birth.setOnClickListener(listener);
//        btn_help.setOnClickListener(new Listener());
//        btn_about.setOnClickListener(new Listener());
        btn_exit.setOnClickListener(new Listener());
        btn_de.setOnClickListener(new Listener());
        //-->将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);

        //-->显示用户信息
        tv_user.setText(allApplication.mList.get(0).getName());
        tv_phone.setText(allApplication.aList.get(0).getphone());
        tv_num.setText(allApplication.aList.get(0).getUserId());
        tv_lable.setText(allApplication.aList.get(0).getCardId());
    }
    class Listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_user:
                    View dlgview = LayoutInflater.from(UserInfo.this).inflate(R.layout.dialog_layout,null);
                    EditText etname=dlgview.findViewById(R.id.etname);
                    Button btnok=dlgview.findViewById(R.id.btnok);
                    btnok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tv_user.setText(etname.getText().toString());
                            dlg.dismiss();
                        }
                    });
                    dlg= new AlertDialog.Builder(UserInfo.this)
                            .setView(dlgview)
                            .create();
                    dlg.show();
                    break;
                case R.id.btn_num:
                    View dlgview_num = LayoutInflater.from(UserInfo.this).inflate(R.layout.dialog_layout,null);
                    EditText etname_num=dlgview_num.findViewById(R.id.etname);
                    Button btnok_num=dlgview_num.findViewById(R.id.btnok);
                    btnok_num.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tv_num.setText(etname_num.getText().toString());
                            dlg_num.dismiss();
                        }
                    });
                    dlg_num= new AlertDialog.Builder(UserInfo.this)
                            .setView(dlgview_num)
                            .create();
                    dlg_num.show();
                    break;

                case R.id.btn_phone:
                    View dlgview_phone = LayoutInflater.from(UserInfo.this).inflate(R.layout.dialog_layout,null);
                    EditText etname_phone=dlgview_phone.findViewById(R.id.etname);
                    Button btnok_phone=dlgview_phone.findViewById(R.id.btnok);
                    btnok_phone.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tv_phone.setText(etname_phone.getText().toString());
                            dlg_phone.dismiss();
                        }
                    });
                    dlg_phone= new AlertDialog.Builder(UserInfo.this)
                            .setView(dlgview_phone)
                            .create();
                    dlg_phone.show();
                    break;
                case R.id.btn_lable:
                    View dlgview_lable = LayoutInflater.from(UserInfo.this).inflate(R.layout.dialog_layout,null);
                    EditText etname_lable=dlgview_lable.findViewById(R.id.etname);
                    Button btnok_lable=dlgview_lable.findViewById(R.id.btnok);
                    btnok_lable.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tv_label.setText(etname_lable.getText().toString());
                            dlg_label.dismiss();
                        }
                    });
                    dlg_label = new AlertDialog.Builder(UserInfo.this)
                            .setView(dlgview_lable)
                            .create();
                    dlg_label.show();
                    break;

                case R.id.btn_sex:
                    String sex[]={"女","男"};
                    //flag=0;
                    choice=0;
                    dlg_sex=new AlertDialog.Builder(UserInfo.this)
                            .setTitle("请选择性别")
//                        .setMessage("this is a dialog")
                            //数组选项0：默认项的数组下标
                            .setSingleChoiceItems(sex, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Log.i("test",i+"");
                                    flag=1;
                                    choice=i;
                                }
                            })
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if(flag==0){
                                        tv_sex.setText(sex[0]);
                                    }else{
                                        tv_sex.setText(sex[choice]);
                                    }
                                }
                            })
                            .create();
                    dlg_sex.show();
                    break;

                case R.id.btn_birth:
                    Calendar cal=Calendar.getInstance();
                    int year=cal.get(Calendar.YEAR);
                    int month=cal.get(Calendar.MONTH);
                    int day=cal.get(Calendar.DAY_OF_MONTH);
                    dlg_birth=new DatePickerDialog(UserInfo.this, new DatePickerDialog.OnDateSetListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            tv_birth.setText(i+"-"+(i1+1)+"-"+i2);
                        }
                    },year,month,day);
                    dlg_birth.show();
                    break;
                case R.id.btn_exit:
                    myApplication.getInstance().exit();
                case R.id.btn_de:
                    String name = allApplication.mList.get(0).getName();
                    String student_id = allApplication.mList.get(0).getUserId();
                    String card_id = allApplication.mList.get(0).getCardId();
                    SubmintResult sr = new SubmintResult();
                    String result = sr.requestInfo("http://150.158.26.45:8080/Test01/Delete?student_name="+name+"&student_id="+student_id+"&card_id="+card_id+"");
                    if (result.equals("1")){
                        Intent intent=new Intent(UserInfo.this,Login.class);
                        startActivity(intent);
                    }
            }
        }
    }
}
