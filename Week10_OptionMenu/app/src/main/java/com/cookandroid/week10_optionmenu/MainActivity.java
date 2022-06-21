package com.cookandroid.week10_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(" 배경색 바꾸기 ");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
    }

    //클래스 -> OverrideMethods  V
    //인터페이스 -> ImplementMethods
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        /*
        //inflater -> 없다가 나타났다가 사라지는 이벤트를 발생시킴(풍선처럼)
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);

        return true;

         */

        menu.add(0, 1, 0, "배경색 (빨강)"); //add(그룹ID, 항목ID, 순번, 제목)
        menu.add(0, 2, 0, "배경색 (초록)");
        menu.add(0, 3, 0, "배경색 (파랑)" );

        SubMenu sMenu = menu.addSubMenu(" 버튼 변경 >> "); //서브 메뉴
        sMenu.add(0, 4, 0, "버튼 45도 회전"); //서브 메뉴 항목 추가
        sMenu.add(0, 5, 0, "버튼 2배 확대");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        /*
        switch(item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                button1.setRotation(45);
                return true;
            case R.id.subSize:
                baseLayout.setScaleX(2);
                return true;
            case R.id.subReset:
                button1.setRotation(0);
                baseLayout.setScaleX(1);
                return true;
        }
        return false;

         */

        switch (item.getItemId()) { //add()메서드의 항목ID로 판단
            case 1:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case 2:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                button1.setRotation(45);
                return true;
            case 5:
                button1.setScaleX(2);
                return true;
        }
        return false;

    }
}