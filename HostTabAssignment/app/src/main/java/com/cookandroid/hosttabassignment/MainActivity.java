package com.cookandroid.hosttabassignment;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabSpec tabSpec1 = tabHost.newTabSpec(" TAG1 ").setIndicator(" 진로 ");
        tabSpec1.setContent(R.id.linearLayoutTab1);
        tabHost.addTab(tabSpec1);

        TabSpec tabSpec2 = tabHost.newTabSpec("TAG2").setIndicator("강아지");
        tabSpec2.setContent(R.id.linearLayoutTab2);
        tabHost.addTab(tabSpec2);

        TabSpec tabSpec3 = tabHost.newTabSpec("TAG3").setIndicator("운동");
        tabSpec3.setContent(R.id.linearLayoutTab3);
        tabHost.addTab(tabSpec3);

        TabSpec tabSpec4 = tabHost.newTabSpec("TAG4").setIndicator("음악듣기");
        tabSpec4.setContent(R.id.linearLayoutTab4);
        tabHost.addTab(tabSpec4);

        tabHost.setCurrentTab(0);
    }
}
