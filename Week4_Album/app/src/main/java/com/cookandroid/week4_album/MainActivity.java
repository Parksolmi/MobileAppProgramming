package com.cookandroid.week4_album;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //전역 변수 선언
    TextView textView1, textView2;
    Switch switchAgree;
    RadioGroup rGroup1;
    //RadioButton rdoDog, rdoCat, rdoRabbit;
    RadioButton radioArray[] = new RadioButton[3];
    ImageView image;
    Button btnExit, btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //상단 앱바
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("애완동물 사진 보기");

        //변수 연결
        textView1 = (TextView) findViewById(R.id.TextView1);
        switchAgree = (Switch) findViewById(R.id.SwitchAgree);

        textView2 = (TextView) findViewById(R.id.TextView2);
        rGroup1 = (RadioGroup) findViewById(R.id.RGroup);
        //rdoDog = (RadioButton) findViewById(R.id.RdoDog);
        //rdoCat = (RadioButton) findViewById(R.id.RdoCat);
        //rdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);
        radioArray[0] = (RadioButton) findViewById(R.id.RdoDog);
        radioArray[1] = (RadioButton) findViewById(R.id.RdoCat);
        radioArray[2] = (RadioButton) findViewById(R.id.RdoRabbit);

        //btnOk = (Button) findViewById(R.id.BtnOk);
        image = (ImageView) findViewById(R.id.image);

        btnExit = (Button) findViewById(R.id.BtnExit);
        btnReturn = (Button) findViewById(R.id.BtnReturn);


        //클릭 이벤트
        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean ag1) {

                //invisible 풀기
                if(switchAgree.isChecked()==true) {
                    textView2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    image.setVisibility(android.view.View.VISIBLE);
                    btnExit.setVisibility(android.view.View.VISIBLE);
                    btnReturn.setVisibility(android.view.View.VISIBLE);
                }
                else
                {
                    textView2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    image.setVisibility(android.view.View.INVISIBLE);
                    btnExit.setVisibility(android.view.View.INVISIBLE);
                    btnReturn.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        final int pet[] = {R.drawable.dog, R.drawable.cat, R.drawable.rabbit};

        for(int i=0; i<radioArray.length; i++)
        {
            final int index;
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    image.setImageResource(pet[index]);
                }
            });
        }

        btnExit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //다시 invisible로 변환
                textView2.setVisibility(android.view.View.INVISIBLE);
                rGroup1.setVisibility(android.view.View.INVISIBLE);
                image.setVisibility(android.view.View.INVISIBLE);
                btnExit.setVisibility(android.view.View.INVISIBLE);
                btnReturn.setVisibility(android.view.View.INVISIBLE);

                //라디오 그룹 선택지 삭제
                //스위치 버튼 off
                rGroup1.clearCheck();
                switchAgree.setChecked(false);
            }
        });

        /*
        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RdoDog:
                        image.setImageResource(R.drawable.dog);
                        break;
                    case R.id.RdoCat:
                        image.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RdoRabbit:
                        image.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });
        */


    }
}