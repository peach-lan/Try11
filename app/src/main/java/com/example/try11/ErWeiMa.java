package com.example.try11;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.Hashtable;

public class ErWeiMa extends AppCompatActivity {

    private boolean STOP=true;
    private EditText text;
    private ImageView imageView;
    private mHandler handler;
    private mThread thread;
    private int count1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        handler=new mHandler();
        thread=new mThread();
        text = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new Click());

        Bitmap bmp = createQRCodeBitmap(text.getText().toString(), 800, 800,"UTF-8","H", "1", Color.BLACK, Color.WHITE);
        imageView.setImageBitmap(bmp);

        STOP = false;
        thread.start();
    }

    private class mHandler extends Handler {
        public void handleMessage(Message msg){
            switch (msg.arg1){
                case 1:{
                    count1++;
                }
            }
        }
    }

    private class mThread extends Thread{
        @Override
        public void run(){
            while(!STOP){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.arg1=1;
                handler.sendMessage(msg);
            }
        }
    }

    public class Click implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String str = count1 + "";
            Bitmap bmp = createQRCodeBitmap(text.getText().toString() + str, 800, 800, "UTF-8", "H", "1", Color.BLACK, Color.WHITE);
            imageView.setImageBitmap(bmp);
        }
    }

    // ?????????????????????
    public Bitmap createQRCodeBitmap(String content, int width, int height,
                                     String character_set, String error_correction_level,
                                     String margin, int color_black, int color_white) {
        // ?????????????????????

        if (TextUtils.isEmpty(content)) {
            return null;
        }
        // ?????????>=0
        if (width < 0 || height < 0) {
            return null;
        }
        try {
            /** 1.??????????????????????????? */
            Hashtable<EncodeHintType, String> hints = new Hashtable<>();
            // ????????????????????????
            if (!TextUtils.isEmpty(character_set)) {
                hints.put(EncodeHintType.CHARACTER_SET, character_set);
            }
            // ???????????????
            if (!TextUtils.isEmpty(error_correction_level)) {
                hints.put(EncodeHintType.ERROR_CORRECTION, error_correction_level);
            }
            // ??????????????????
            if (!TextUtils.isEmpty(margin)) {
                hints.put(EncodeHintType.MARGIN, margin);
            }
            /** 2.????????????????????????QRCodeWriter???encode????????????BitMatrix(?????????)?????? */
            BitMatrix bitMatrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            /** 3.??????????????????,?????????BitMatrix(?????????)????????????????????????????????? */
            int[] pixels = new int[width * height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    //bitMatrix.get(x,y)????????????true??????????????????false???????????????
                    if (bitMatrix.get(x, y)) {
                        pixels[y * width + x] = color_black;//????????????????????????
                    } else {
                        pixels[y * width + x] = color_white;// ????????????????????????
                    }
                }
            }
            /** 4.??????Bitmap??????,????????????????????????Bitmap???????????????????????????,?????????Bitmap?????? */
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
