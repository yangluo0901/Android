package com.example.yluo.textview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    private TextView tv_text1;
    private TextView tv_text2;
    private TextView tv_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_text1 = findViewById(R.id.tv_text1);
        tv_text2 = findViewById(R.id.tv_text2);
        tv_img = findViewById(R.id.tv_img);
        String text1 = "<a href='http://www.google.com'><font color='Blue'>GOOGLE </font> </a>";
        String text2 = "http://www.yahoo.com";
        String text3 = "<img src='green_filter'>";
        tv_text1.setText(Html.fromHtml(text1));
        tv_text1.setMovementMethod(new LinkMovementMethod());
        tv_text2.setText(text2);//inside xml.file, tv_text2 has been already configured by adding "android:autoLink="all"", no need to convert string into HTML and
        // set movement method
        ImgGetter imgGetter = new ImgGetter();

        Spanned span = Html.fromHtml(text3,imgGetter,null);
        tv_img.setText(span);

    }
    private class ImgGetter implements Html.ImageGetter
    {
        @Override
        public Drawable getDrawable(String source) {
            Drawable drawable = getResources().getDrawable(getImgID(source));
            Log.d("img","inside getDrawable()");
            drawable.setBounds(-20,260,400,610);
            return drawable;
        }
        public int getImgID(String imgName)
        {
            try {
                Field field =  R.drawable.class.getField(imgName);
                int id = Integer.parseInt(field.get(null).toString());
                Log.d("img","img id is "+id);
                return id;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
    }
}
