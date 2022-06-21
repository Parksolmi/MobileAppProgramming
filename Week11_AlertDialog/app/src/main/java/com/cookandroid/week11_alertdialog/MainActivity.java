package com.cookandroid.week11_alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[]{"Q(10)", "R(11)", "S(12)"};
                final boolean[] checkArray = new boolean[]{true, false, false};

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);
                //dlg.setPositiveButton("확인", null);
                dlg.setMultiChoiceItems(versionArray, checkArray,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                button1.setText(versionArray[which]);
                            }
                        });
                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });
    }
}