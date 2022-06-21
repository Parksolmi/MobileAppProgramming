package com.cookandroid.termproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Frag1Calendar extends Fragment {

    private View view;

    CalendarView calendar;

    EditText diaryTxt;
    TextView diaryEmptyTxt;
    ImageView icon;

    Button reviseBtn;
    Button deleteBtn;

    String filename;
    String iconTxt;

    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1_calendar, container, false);

        diaryTxt = (EditText) view.findViewById(R.id.diaryTxt);
        diaryEmptyTxt = (TextView) view.findViewById(R.id.diaryEmptyTxt);
        icon = view.findViewById(R.id.calendarIcon);
        reviseBtn = (Button) view.findViewById(R.id.reviseBtn);
        deleteBtn = (Button) view.findViewById(R.id.deleteBtn);

        calendar = (CalendarView) view.findViewById(R.id.calendarView);

        //처음 실행 시 설정할 내용
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
        long timeInMillis = calendar.getDate();
        Date timeInDate = new Date(timeInMillis);
        String timeInFormat = sdf.format(timeInDate);

        filename = timeInFormat + ".txt";

        String path = "/data/data/com.cookandroid.termproject/files/" + filename;

        try {
            File file = new File(path);

            if(file.exists())
            {
                FileInputStream fis = getActivity().openFileInput(filename);
                DataInputStream dis = new DataInputStream(fis);

                String strTxt = dis.readUTF();
                iconTxt = dis.readUTF();

                fis.close();
                dis.close();

                if(iconTxt.equals("iconangry"))
                {
                    icon.setImageResource(R.drawable.iconangry);
                }
                else if(iconTxt.equals("iconcrazy"))
                {
                    icon.setImageResource(R.drawable.iconcrazy);
                }
                else if(iconTxt.equals("iconcrying"))
                {
                    icon.setImageResource(R.drawable.iconcrying);
                }
                else if(iconTxt.equals("iconhappy"))
                {
                    icon.setImageResource(R.drawable.iconhappy);
                }
                else if(iconTxt.equals("iconkiss"))
                {
                    icon.setImageResource(R.drawable.iconkiss);
                }
                else if(iconTxt.equals("iconlaughing"))
                {
                    icon.setImageResource(R.drawable.iconlaughing);
                }
                else if(iconTxt.equals("iconlike"))
                {
                    icon.setImageResource(R.drawable.iconlike);
                }
                else if(iconTxt.equals("iconsick"))
                {
                    icon.setImageResource(R.drawable.iconsick);
                }

                diaryTxt.setVisibility(view.VISIBLE);
                diaryEmptyTxt.setVisibility(view.INVISIBLE);

                icon.setVisibility(view.VISIBLE);

                diaryTxt.setText((new String(strTxt)).trim());
                reviseBtn.setEnabled(true);
                deleteBtn.setEnabled(true);

            }
            else
            {
                diaryTxt.setVisibility(view.INVISIBLE);
                diaryEmptyTxt.setVisibility(view.VISIBLE);
                icon.setVisibility(view.INVISIBLE);
                reviseBtn.setEnabled(false);
                deleteBtn.setEnabled(false);

            }


        }catch(IOException e) {

        }


        //날짜가 바뀌면 수정 될 내용
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                month += 1;
                filename = year + "-" + month + "-" + dayOfMonth + ".txt";

                try{

                    String path = "/data/data/com.cookandroid.termproject/files/" + filename;
                    File file = new File(path);

                    if(file.exists())
                    {
                        FileInputStream fis = getActivity().openFileInput(filename);
                        DataInputStream dis = new DataInputStream(fis);

                        String strTxt = dis.readUTF();
                        iconTxt = dis.readUTF();

                        fis.close();
                        dis.close();

                        if(iconTxt.equals("iconangry"))
                        {
                            icon.setImageResource(R.drawable.iconangry);
                        }
                        else if(iconTxt.equals("iconcrazy"))
                        {
                            icon.setImageResource(R.drawable.iconcrazy);
                        }
                        else if(iconTxt.equals("iconcrying"))
                        {
                            icon.setImageResource(R.drawable.iconcrying);
                        }
                        else if(iconTxt.equals("iconhappy"))
                        {
                            icon.setImageResource(R.drawable.iconhappy);
                        }
                        else if(iconTxt.equals("iconkiss"))
                        {
                            icon.setImageResource(R.drawable.iconkiss);
                        }
                        else if(iconTxt.equals("iconlaughing"))
                        {
                            icon.setImageResource(R.drawable.iconlaughing);
                        }
                        else if(iconTxt.equals("iconlike"))
                        {
                            icon.setImageResource(R.drawable.iconlike);
                        }
                        else if(iconTxt.equals("iconsick"))
                        {
                            icon.setImageResource(R.drawable.iconsick);
                        }

                        diaryTxt.setVisibility(view.VISIBLE);
                        diaryEmptyTxt.setVisibility(view.INVISIBLE);
                        icon.setVisibility(view.VISIBLE);

                        diaryTxt.setText((new String(strTxt)).trim());
                        reviseBtn.setEnabled(true);
                        deleteBtn.setEnabled(true);
                    }
                    else
                    {
                        diaryTxt.setVisibility(view.INVISIBLE);
                        diaryEmptyTxt.setVisibility(view.VISIBLE);
                        icon.setVisibility(view.INVISIBLE);

                        reviseBtn.setEnabled(false);
                        deleteBtn.setEnabled(false);
                    }

                }catch(IOException e) {

                }
            }
        });



        //수정하기 버튼 이벤트
        reviseBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    FileOutputStream fos = getActivity().openFileOutput(filename, Context.MODE_PRIVATE);
                    DataOutputStream dos = new DataOutputStream(fos);
                    String strTxt = diaryTxt.getText().toString();
                    dos.writeUTF(strTxt);
                    dos.writeUTF(iconTxt);

                    fos.close();
                    dos.close();

                    Toast.makeText(getActivity(), "수정되었습니다", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {

                }

            }
        });

        //삭제하기 버튼 이벤트
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                dlg.setTitle("일기 삭제");
                dlg.setMessage("정말로 일기를 삭제하시겠습니까?");
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {

                        String path = "/data/data/com.cookandroid.termproject/files/" + filename;
                        File file = new File(path);

                        file.delete();

                        diaryTxt.setVisibility(view.INVISIBLE);
                        diaryEmptyTxt.setVisibility(view.VISIBLE);
                        icon.setVisibility(view.INVISIBLE);
                        reviseBtn.setEnabled(false);
                        deleteBtn.setEnabled(false);

                        //토스트 메시지
                        Toast.makeText(getActivity(),"삭제되었습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlg.show();
            }
        });

        return view;
    }

}
