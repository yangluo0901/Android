package com.example.yluo.textview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_text1;
    private TextView tv_text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_text1 = findViewById(R.id.tv_text1);
        tv_text2 = findViewById(R.id.tv_text2);
        String text1 = "<a href='http://www.google.com'><font color='Blue'>GOOGLE </font> </a>";
        String text2 = "http://www.yahoo.com";
        tv_text1.setText(Html.fromHtml(text1));
        tv_text1.setMovementMethod(new LinkMovementMethod());
        tv_text2.setText(text2);//inside xml.file, tv_text2 has been already configured by adding "android:autoLink="all"", no need to convert string into HTML and
        // set movement method
    }
}
