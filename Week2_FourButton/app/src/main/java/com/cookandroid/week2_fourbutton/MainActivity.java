package com.cookandroid.week2_fourbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //멤버 변수 선언
    Button btnNate, btn911, btnGal, btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //아이콘 설정
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        btnNate = (Button) findViewById(R.id.btnNate);
        btn911 = (Button) findViewById(R.id.btn911);
        btnGal = (Button) findViewById(R.id.btnGal);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        //배경색 - xml보다 우선 순위가 높음
        btnNate.setBackgroundColor(Color.GRAY);
        btn911.setBackgroundColor(Color.GREEN);
        btnGal.setBackgroundColor(Color.RED);
        btnEnd.setBackgroundColor(Color.YELLOW);

        btnNate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"));
                startActivity(mIntent);
            }
        });

        btn911.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/911"));
                startActivity(mIntent);
            }
        });

        btnGal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse
                        ("content://media/internal/images/media"));
                startActivity(mIntent);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });


    }
}