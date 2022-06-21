package com.cookandroid.week7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {

    //전역 변수 선언
    Chronometer chrono;
    RadioButton rdoCal, rdoTime;
    DatePicker dPicker;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //검색 실습
//        String[] items = {"CSI-뉴욕", "CSI-라스베가스", "CSI-마이애미", "Friends", "Fringe", "Lost" };
//
//        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, items);
//        auto.setAdapter(adapter);
//
//        MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView)
//                findViewById(R.id.multiAutoCompleteTextView1);
//        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
//        multi.setTokenizer(token);
//        multi.setAdapter(adapter);

        //프로젝트
        setTitle("시간 예약");

        //크로노미터
        chrono = (Chronometer) findViewById(R.id.chronometer1);

        //라디오 버튼 2개
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        //FrameLayout의 2개 위젯
        dPicker = (DatePicker) findViewById(R.id.datePicker1);
        tPicker = (TimePicker) findViewById(R.id.timePicker1);

        //텍스트 뷰 중에서 연,월,일,시,분 숫자
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMinute);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        //처음에는 2개를 안보이도록 설정
        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.VISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
            }
        });

        // 크로노미터를 클릭하면..타이머 시작
        chrono.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });

        // 크로노미터를 롱클릭하면..타이머 중지
        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(dPicker.getYear()));
                tvMonth.setText(Integer.toString(1 + dPicker.getMonth()));
                tvDay.setText(Integer.toString(dPicker.getDayOfMonth()));

                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));

                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
                return false;

            }
        });

        //캘린더뷰에서 설정한 년,월,일 변수에 대입
        calView.setOnDataChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month +1;
                selectDay = dayOfMonth;
            }
        }
    }
}