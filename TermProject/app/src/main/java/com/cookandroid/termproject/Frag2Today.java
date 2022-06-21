package com.cookandroid.termproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Frag2Today extends Fragment{

    private View view;

    ImageButton questionBtn;
    TextView questionTxt;
    TextView questionBtnTxt;

    ImageView iconToday;
    ImageButton laughBtn, angryBtn, crazyBtn, cryingBtn, happyBtn, kissBtn, likeBtn, sickBtn;

    String filename;
    EditText diary;
    Button saveBtn;

    //초기화
    String strIcon = "iconlaughing";

    ArrayList<String> fileList = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2_today, container, false);

        //질문보기
        questionBtn = (ImageButton) view.findViewById(R.id.questionShowBtn);
        questionBtnTxt = (TextView) view.findViewById(R.id.questionShowBtnTxt);
        questionTxt = (TextView) view.findViewById(R.id.questionTxt);

        //아이콘
        iconToday = (ImageView) view.findViewById(R.id.todayIcon);
        laughBtn = (ImageButton) view.findViewById(R.id.icon_laughing);
        angryBtn = (ImageButton) view.findViewById(R.id.icon_angry);
        crazyBtn = (ImageButton) view.findViewById(R.id.icon_crazy);
        cryingBtn = (ImageButton) view.findViewById(R.id.icon_crying);
        happyBtn = (ImageButton) view.findViewById(R.id.icon_happy);
        kissBtn = (ImageButton) view.findViewById(R.id.icon_kiss);
        likeBtn = (ImageButton) view.findViewById(R.id.icon_like);
        sickBtn = (ImageButton) view.findViewById(R.id.icon_sick);

        //일기 저장
        saveBtn = (Button) view.findViewById(R.id.saveBtn);
        diary = (EditText) view.findViewById(R.id.editTxt);


        //오늘의 질문 버튼
        questionBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(questionTxt.getVisibility()==View.VISIBLE)
                {
                    questionTxt.setVisibility(View.INVISIBLE);
                    questionBtnTxt.setText("질문 보기");
                }
                else
                {
                    questionTxt.setVisibility(View.VISIBLE);
                    questionBtnTxt.setText("질문 숨기기");
                }
            }
        });

        //아이콘 버튼
        laughBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                iconToday.setImageResource(R.drawable.iconlaughing);
                strIcon = "iconlaughing";
            }
        });

        angryBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                iconToday.setImageResource(R.drawable.iconangry);
                strIcon = "iconangry";
            }
        });

        crazyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                iconToday.setImageResource(R.drawable.iconcrazy);
                strIcon = "iconcrazy";
            }
        });

        cryingBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                iconToday.setImageResource(R.drawable.iconcrying);
                strIcon = "iconcrying";
            }
        });

        happyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                iconToday.setImageResource(R.drawable.iconhappy);
                strIcon = "iconhappy";
            }
        });

        kissBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                iconToday.setImageResource(R.drawable.iconkiss);
                strIcon = "iconkiss";
            }
        });

        likeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                iconToday.setImageResource(R.drawable.iconlike);
                strIcon = "iconlike";
            }
        });

        sickBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                iconToday.setImageResource(R.drawable.iconsick);
                strIcon = "iconsick";
            }
        });

        //오늘 일기 저장
        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                long now = System.currentTimeMillis();
                Date date = new Date(now);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                //cal.add(Calendar.DATE, -1);

                filename = sdf.format(cal.getTime()) + ".txt";

                String path = "/data/data/com.cookandroid.termproject/files/" + filename;
                File file = new File(path);

                try {
                    if(diary.getText().toString().equals(""))
                    {
                        Toast.makeText(getActivity(),"일기를 작성해주세요.", Toast.LENGTH_SHORT).show();
                    }
                    else if(file.exists())
                    {
                        Toast.makeText(getActivity(),"오늘 일기를 이미 작성했습니다.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        FileOutputStream fos = getActivity().openFileOutput(filename, Context.MODE_PRIVATE);
                        DataOutputStream dos = new DataOutputStream(fos);
                        String strTxt = diary.getText().toString();
                        dos.writeUTF(strTxt);
                        dos.writeUTF(strIcon);

                        fos.close();
                        dos.close();

                        diary.setText("");

                        Toast.makeText(getActivity(),"저장되었습니다", Toast.LENGTH_SHORT).show();

                        fileList.add(filename);
                    }

                } catch (IOException e) {

                }
            }
        });

        return view;
    }

}