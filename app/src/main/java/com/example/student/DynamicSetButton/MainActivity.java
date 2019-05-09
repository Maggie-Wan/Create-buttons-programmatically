package com.example.student.DynamicSetButton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int i;
        super.onCreate(savedInstanceState);
        //先把setContentView(R.layout.activity_main)刪除
        LinearLayout ll=new LinearLayout(MainActivity.this);
        for (i=1;i<=3;i++){ //用for做三個一樣的按鈕
            //先設定layout的width,height,weight
            LinearLayout.LayoutParams para= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,1);
            //其他屬性的設定可以如下
            //para.gravity = Gravity.CENTER;
            //para.bottomMargin=20;
            Button btn=new Button(MainActivity.this);
            btn.setText("hello");
            //把設定好的layout設定給btn
            btn.setLayoutParams(para);
            final String str=String.valueOf(i);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
                }
            });
            ll.addView(btn);//在linearlayout下加一個btn，因為btn也是view
        }
        //如果不用linearlayout，而是直接setContentView(btn);那就會有一個跟版面完全一樣大小的button
        setContentView(ll); //可以直接設定linearlayout，因為linearlayout也是view
    }

}


