package com.cookandroid.week9_viewfilter;
/*
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

        TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong);
        tabHost.addTab(tabSpecSong);

        TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST")
                .setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tabArtist);
        tabHost.addTab(tabSpecArtist);

        TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(2);
    }
}

 */
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabSpec tabSpec1 = tabHost.newTabSpec("TAG1").setIndicator("강아지");
        tabSpec1.setContent(R.id.imageView1);
        tabHost.addTab(tabSpec1);

        TabSpec tabSpec2 = tabHost.newTabSpec("TAG2").setIndicator("고양이");
        tabSpec2.setContent(R.id.imageView2);
        tabHost.addTab(tabSpec2);

        TabSpec tabSpec3 = tabHost.newTabSpec("TAG3").setIndicator("토끼");
        tabSpec3.setContent(R.id.imageView3);
        tabHost.addTab(tabSpec3);

        TabSpec tabSpec4 = tabHost.newTabSpec("TAG4").setIndicator("말");
        tabSpec4.setContent(R.id.imageView4);
        tabHost.addTab(tabSpec4);

        tabHost.setCurrentTab(0);

    }


}
