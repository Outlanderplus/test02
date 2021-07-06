package com.example.test02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Vector;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SuperWiFi rss_scan = null;
    Vector<String> RSSList = null;
    private String testlist = null;
    public static int testID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText ipText = findViewById(R.id.ipText);
        final Button changactivity = (Button) findViewById(R.id.button1);
        final Button cleanlist = findViewById(R.id.button2);
        rss_scan = new SuperWiFi(this);
        testlist = "";
        testID = 0;
        changactivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testID = testID + 1;
                rss_scan.ScanRss();
                while (rss_scan.isscan()) {

                }
                RSSList = rss_scan.getRSSlist();
                final EditText ipText = findViewById(R.id.ipText);
                testlist = testlist + "testID:" + testID + "\n" + RSSList.toString() + "\n";
                ipText.setText(testlist);//Display the result in the textlist

            }
        });
        cleanlist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testlist = "";
                ipText.setText(testlist);
                testID = 0;
            }
        });

    }
}