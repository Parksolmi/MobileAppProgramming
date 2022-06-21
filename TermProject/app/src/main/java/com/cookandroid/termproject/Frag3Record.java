package com.cookandroid.termproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Frag3Record extends Fragment {

    private View view;

    DatePicker dp;
    TextView questionTxt;
    TextView diaryTxt;
    ImageView icon;

    String filename;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3_record, container, false);

        dp = (DatePicker) view.findViewById(R.id.datePicker1);
        questionTxt = view.findViewById(R.id.questionTxt);
        diaryTxt = view.findViewById(R.id.diaryTxt);
        icon = view.findViewById(R.id.icon);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                filename = year + "-" + (monthOfYear+1) + "-" + dayOfMonth + ".txt";

                String path = "/data/data/com.cookandroid.termproject/files/" + filename;
                File file = new File(path);

                readDiary(file, filename);
            }
        });

        return view;
    }

    void readDiary(File file, String fileName) {

        if (file.exists()) {
            FileInputStream fis;
            try {
                fis = getActivity().openFileInput(fileName);
                DataInputStream dis = new DataInputStream(fis);

                diaryTxt.setText(dis.readUTF());
                String iconTxt = dis.readUTF();

                fis.close();
                dis.close();

                if (iconTxt.equals("iconangry")) {
                    icon.setImageResource(R.drawable.iconangry);
                } else if (iconTxt.equals("iconcrazy")) {
                    icon.setImageResource(R.drawable.iconcrazy);
                } else if (iconTxt.equals("iconcrying")) {
                    icon.setImageResource(R.drawable.iconcrying);
                } else if (iconTxt.equals("iconhappy")) {
                    icon.setImageResource(R.drawable.iconhappy);
                } else if (iconTxt.equals("iconkiss")) {
                    icon.setImageResource(R.drawable.iconkiss);
                } else if (iconTxt.equals("iconlaughing")) {
                    icon.setImageResource(R.drawable.iconlaughing);
                } else if (iconTxt.equals("iconlike")) {
                    icon.setImageResource(R.drawable.iconlike);
                } else if (iconTxt.equals("iconsick")) {
                    icon.setImageResource(R.drawable.iconsick);
                }

                icon.setVisibility(view.VISIBLE);

            } catch (IOException e) {
            }
        } else {
            diaryTxt.setText("기록된 일기가 없습니다.");
            icon.setVisibility(view.INVISIBLE);
        }
    }

}
