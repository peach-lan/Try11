package com.example.try11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.OptionalDataException;

public class HelpCenter extends Activity {


    public static final int REQUEST_CALL_PERMISSION = 10111; //拨号请求码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);

        //将Activity添加到全局变量中
        myApplication.getInstance().addActivity(this);
        Button bohao = (Button)this.findViewById(R.id.buhao);
        bohao.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent();
                        intent.setAction(Intent.ACTION_DIAL);   //android.intent.action.DIAL
                        intent.setData(Uri.parse("tel:19142597424"));
                        startActivity(intent);


                    }
                }
        );
    }
}
