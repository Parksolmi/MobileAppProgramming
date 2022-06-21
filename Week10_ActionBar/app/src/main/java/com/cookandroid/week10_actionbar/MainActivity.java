package com.cookandroid.week10_actionbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
//인터페이스 -> 의무적으로 구현해야 하는 메소드들을 하나 이상 가지고 있기 때문에 에러 발생
//이 경우에는 3개의 메소드를 구현해야함

    ActionBar.Tab tabSong, tabArtist, tabAlbum;
    MyTabFragment myFrags[] = new MyTabFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabSong = bar.newTab();
        tabSong.setText("음악별");
        tabSong.setTabListener(this);
        bar.addTab(tabSong);

        tabArtist = bar.newTab();
        tabArtist.setText("가수별");
        tabArtist.setTabListener(this);
        bar.addTab(tabArtist);

        tabAlbum = bar.newTab();
        tabAlbum.setText("앨범별");
        tabAlbum.setTabListener(this);
        bar.addTab(tabAlbum);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        MyTabFragment myTabFrag = null;

        if(myFrags[tab.getPosition()] == null) {

            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle();
            //putString(키, 값);
            data.putString("tabName", tab.getText().toString());

            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTabFrag;
        } else
            myTabFrag = myFrags[tab.getPosition()];

        ft.replace(android.R.id.content, myTabFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }


    public static class MyTabFragment extends Fragment{

        String tabName;

        //Code > OverrideMethods

        
        //Tab이 클릭되었을 때
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");

        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );

            LinearLayout baseLayout = new LinearLayout(super.getActivity());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);
            if (tabName == "음악별") //탭 별로 배경색 변경
                baseLayout.setBackgroundColor(Color.RED);
            if (tabName == "가수별")
                baseLayout.setBackgroundColor(Color.GREEN);
            if (tabName == "앨범별")
                baseLayout.setBackgroundColor(Color.BLUE);


            return baseLayout;



        }
    }


}