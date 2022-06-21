package com.cookandroid.termproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1Calendar frag1;
    private Frag2Today frag2;
    private Frag3Record frag3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("한 줄의 기록");

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        //바텀 네비게이션
        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_calendar:
                        setFrag(0);
                        break;
                    case R.id.action_today:
                        setFrag(1);
                        break;
                    case R.id.action_record:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });

        frag1 = new Frag1Calendar();
        frag2 = new Frag2Today();
        frag3 = new Frag3Record();
        setFrag(1);

    }

    private void setFrag(int n)
    {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.Main_Frame, frag1);
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.Main_Frame, frag2);
                ft.commit();
                break;

            case 2:
                ft.replace(R.id.Main_Frame, frag3);
                ft.commit();
                break;
        }
    }
}