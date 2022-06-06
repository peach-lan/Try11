package com.example.try11;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private View include1,include2,include3,include4;
    private LinearLayout ll_anchor_left,ll_bill,ll_selectBill,ll_surplus,ll_cardBag,ll_collect,ll_share,ll_cardApplication,ll_cardVerify,ll_help,ll_about;
    private ImageView go,all_home,bill_home,payonline_home,bankcard_home,recharge_home,alterpwd_home,select_remain_home,bill_home2;
    private Button button1,button2,button3,button4,button5,button6,button7;
    private ImageButton btn_bill,btn_netfee,btn_bankcard,btn_cardcharge,btn_changepassword,btn_balancequery,btn_pipelinequery,btn_carduncoupling,btn_cardloss;
    private TextView txt1,txt2;
    private BottomNavigationView navView;
    private int flag;
    private TextView tv_surplus;
    private ImageView screen,pay;
    //-->底部导航栏点击监听事件
    private NavigationBarView.OnItemSelectedListener mOnNavigationItemSelectedListener
            = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //-->底部导航栏菜单可视化设置
            switch (item.getItemId()) {
                case R.id.home:
                    include1.setVisibility(View.VISIBLE);
                    include2.setVisibility(View.INVISIBLE);
                    include3.setVisibility(View.INVISIBLE);
                    include4.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.center:
                    include1.setVisibility(View.INVISIBLE);
                    include2.setVisibility(View.VISIBLE);
                    include3.setVisibility(View.INVISIBLE);
                    include4.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.consult:
                    include1.setVisibility(View.INVISIBLE);
                    include2.setVisibility(View.INVISIBLE);
                    include3.setVisibility(View.VISIBLE);
                    include4.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.personal:
                    include1.setVisibility(View.INVISIBLE);
                    include2.setVisibility(View.INVISIBLE);
                    include3.setVisibility(View.INVISIBLE);
                    include4.setVisibility(View.VISIBLE);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.daohanglan);
        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);
        //-->导航栏
        navView = findViewById(R.id.nav_view);
        include1 = findViewById(R.id.include1);
        include2 = findViewById(R.id.include2);
        include3 = findViewById(R.id.include3);
        include4 = findViewById(R.id.include4);

        //-->首页
        go=(ImageView)findViewById(R.id.go);
        all_home=(ImageView)findViewById(R.id.center);
        bill_home=(ImageView)findViewById(R.id.bill_home);
        payonline_home=(ImageView)findViewById(R.id.payonline_home);
        bankcard_home=(ImageView)findViewById(R.id.bankcard_home);
        recharge_home=(ImageView)findViewById(R.id.recharge_home);
        alterpwd_home=(ImageView)findViewById(R.id.alterpws_home);
        select_remain_home=(ImageView)findViewById(R.id.selectremain_home);
        bill_home2=(ImageView)findViewById(R.id.selectbill_home);
        screen=(ImageView)findViewById(R.id.screen);
        pay = (ImageView)findViewById(R.id.pay);

        go.setOnClickListener(new myClick());
        all_home.setOnClickListener(new myClick());
        bill_home.setOnClickListener(new myClick());
        payonline_home.setOnClickListener(new myClick());
        bankcard_home.setOnClickListener(new myClick());
        recharge_home.setOnClickListener(new myClick());
        alterpwd_home.setOnClickListener(new myClick());
        select_remain_home.setOnClickListener(new myClick());
        bill_home2.setOnClickListener(new myClick());
        screen.setOnClickListener(new myClick());
        pay.setOnClickListener(new myClick());

        //-->应用中心
        btn_bill =(ImageButton) findViewById(R.id.bt_bill);
        btn_netfee=(ImageButton) findViewById(R.id.bt_netfee);
        btn_bankcard=(ImageButton) findViewById(R.id.bt_bankcard);
        btn_cardcharge=(ImageButton) findViewById(R.id.bt_cardcharge);
        btn_changepassword=(ImageButton) findViewById(R.id.bt_changepassword);
        btn_balancequery=(ImageButton) findViewById(R.id.bt_balancequery);
        btn_pipelinequery=(ImageButton) findViewById(R.id.bt_pipelinequery);
        btn_carduncoupling=(ImageButton) findViewById(R.id.bt_carduncoupling);
        btn_cardloss=(ImageButton) findViewById(R.id.bt_cardloss);

        btn_bill.setOnClickListener(new yyClick());
        btn_netfee.setOnClickListener(new yyClick());
        btn_bankcard.setOnClickListener(new yyClick());
        btn_cardcharge.setOnClickListener(new yyClick());
        btn_changepassword.setOnClickListener(new yyClick());
        btn_balancequery.setOnClickListener(new yyClick());
        btn_pipelinequery.setOnClickListener(new yyClick());
        btn_carduncoupling.setOnClickListener(new yyClick());
        btn_cardloss.setOnClickListener(new yyClick());

        //-->咨询界面
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);

        button1.setOnClickListener(new ziClick());
        button2.setOnClickListener(new ziClick());
        button3.setOnClickListener(new ziClick());
        button4.setOnClickListener(new ziClick());
        button5.setOnClickListener(new ziClick());
        button6.setOnClickListener(new ziClick());
        button7.setOnClickListener(new ziClick());

        //-->个人中心
        ll_anchor_left = findViewById(R.id.ll_anchor_left);
        ll_bill = findViewById(R.id.ll_bill);
        ll_selectBill = findViewById(R.id.ll_selectBill);
        ll_surplus = findViewById(R.id.ll_surplus);
        ll_cardBag = findViewById(R.id.ll_cardBag);
        ll_collect = findViewById(R.id.ll_collect);
        ll_share = findViewById(R.id.ll_share);
        ll_cardApplication = findViewById(R.id.ll_cardApplication);
        ll_cardVerify = findViewById(R.id.ll_cardVerify);
        ll_help = findViewById(R.id.ll_help);
        ll_about = findViewById(R.id.ll_about);

        TextView user_name = (TextView) findViewById(R.id.user_name);//用户名
        TextView user_id = (TextView)findViewById(R.id.user_id); //学号
        user_name.setText("用户名："+allApplication.mList.get(0).getName());
        user_id.setText("卡号："+allApplication.mList.get(0).getUserId());

        ll_anchor_left.setOnClickListener(new peClick());
        ll_bill.setOnClickListener(new peClick());
        ll_selectBill.setOnClickListener(new peClick());
        ll_surplus.setOnClickListener(new peClick());
        ll_cardBag.setOnClickListener(new peClick());
        ll_collect.setOnClickListener(new peClick());
        ll_share.setOnClickListener(new peClick());
        ll_cardApplication.setOnClickListener(new peClick());
        ll_cardVerify.setOnClickListener(new peClick());
        ll_help.setOnClickListener(new peClick());
        ll_about.setOnClickListener(new peClick());

        navView.setOnItemSelectedListener(mOnNavigationItemSelectedListener);
        //-->用户余额和网费
        tv_surplus=findViewById(R.id.tv_surplus);
        tv_surplus.setText(allApplication.kList.get(0).getBalance());
    }

    //-->首页监听事件
    class myClick implements View.OnClickListener{
        public void onClick(View v){
            if (v==pay){
                Intent intent=new Intent(MainActivity.this, ErWeiMa.class);
                startActivity(intent);
            }
            if (v==screen){
                Intent intent=new Intent(MainActivity.this, CaptureActivity.class);
                startActivity(intent);
            }
            //服务平台升级公告
            if(v==go){
                Intent intent=new Intent(MainActivity.this,serlver_report_handle.class);
                startActivity(intent);
            }
            //全部
            if(v==all_home){
                include1.setVisibility(View.INVISIBLE);
                include2.setVisibility(View.VISIBLE);
                include3.setVisibility(View.INVISIBLE);
                include4.setVisibility(View.INVISIBLE);
            }
            //账单流水
            if(v==bill_home||v==bill_home2){
                Intent intent=new Intent(MainActivity.this,bill_handle.class);
                startActivity(intent);
            }
            //交网费
            if(v==payonline_home){
                Intent intent=new Intent(MainActivity.this,netfee_handle.class);
                startActivity(intent);
            }
            //绑定银行卡
            if(v==bankcard_home){
                Intent intent=new Intent(MainActivity.this,bankcard_handle.class);
                startActivity(intent);
            }
            //卡片充值
            if(v==recharge_home){
                Intent intent=new Intent(MainActivity.this,cardcharge.class);
                startActivity(intent);
            }
            //修改密码
            if(v==alterpwd_home){
                Intent intent=new Intent(MainActivity.this,recharge_pwd.class);
                startActivity(intent);
            }
            //余额查询
            if(v==select_remain_home){
                Intent intent=new Intent(MainActivity.this,select_remain.class);
                startActivity(intent);
            }
        }
    }

    //-->应用中心界面监听事件
    class yyClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.bt_bill://按钮事件 跳转☞我的账单
                    intent.setClass(MainActivity.this, bill_handle.class);
                    break;
                case R.id.bt_netfee://按钮事件 跳转☞交网费
                    intent.setClass(MainActivity.this, netfee_handle.class);
                    break;
                case R.id.bt_bankcard://按钮事件 跳转☞绑定银行卡
                    intent.setClass(MainActivity.this, bankcard_handle.class);
                    break;
                case R.id.bt_cardcharge://按钮事件 跳转☞卡片充值
                    intent.setClass(MainActivity.this, cardcharge.class);
                    break;
                case R.id.bt_changepassword://按钮事件 跳转☞修改密码
                    intent.setClass(MainActivity.this, recharge_pwd.class);
                    break;
                case R.id.bt_balancequery://按钮事件 跳转☞余额查询
                    intent.setClass(MainActivity.this, select_remain.class);
                    break;
                case R.id.bt_pipelinequery://按钮事件 跳转☞流水查询
                    intent.setClass(MainActivity.this, bill_handle.class);
                    break;
                case R.id.bt_carduncoupling://按钮事件 跳转☞卡片解挂
                    intent.setClass(MainActivity.this, CarduncouplingActivity.class);
                    break;
                case R.id.bt_cardloss://按钮事件 跳转☞卡片挂失
                    intent.setClass(MainActivity.this, CardlossActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

    //-->咨询界面监听事件
    class ziClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.button1:
                    intent.setClass(MainActivity.this, MainActivity.class);
                    break;
                case R.id.button2:
                    intent.setClass(MainActivity.this, NextActivity.class);
                    break;
                case R.id.button3:
                    intent.setClass(MainActivity.this, fourActivity.class);
                    break;
                case R.id.button4:
                    intent.setClass(MainActivity.this, fiveActivity.class);
                    break;
                case R.id.button5:
                    intent.setClass(MainActivity.this, sixActivity.class);
                    break;
                case R.id.button6:
                    intent.setClass(MainActivity.this, sixActivity.class);
                    break;
                case R.id.button7:
                    intent.setClass(MainActivity.this, sixActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

    //-->个人中心界面监听事件
    class peClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch(view.getId()){
                case R.id.ll_anchor_left:
                    intent.setClass(MainActivity.this, UserInfo.class);
                    break;
                case R.id.ll_bill:
                    intent.setClass(MainActivity.this, bill_handle.class);
                    break;
                case R.id.ll_selectBill:
                    intent.setClass(MainActivity.this, bill_handle.class);
                    break;
                case R.id.ll_surplus:
                    intent.setClass(MainActivity.this, select_remain.class);
                    break;
                case R.id.ll_cardBag:
                    intent.setClass(MainActivity.this, CardBag.class);
                    break;
                case R.id.ll_collect:
                    intent.setClass(MainActivity.this, Collect.class);
                    break;
                case R.id.ll_share:
                    intent.setClass(MainActivity.this, Share.class);
                    break;
                case R.id.ll_cardApplication:
                    intent.setClass(MainActivity.this, CardApplication.class);
                    break;
                case R.id.ll_cardVerify:
                    intent.setClass(MainActivity.this, CardVerify.class);
                    break;
                case R.id.ll_help:
                    intent.setClass(MainActivity.this, HelpCenter.class);
                    break;
                case R.id.ll_about:
                    intent.setClass(MainActivity.this, AboutUs.class);
                    break;
            }
            startActivity(intent);
        }
    }
}