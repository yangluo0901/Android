package com.example.yluo.textview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Spannable_String extends Activity{
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spannablestring);
        textView = findViewById(R.id.textView);
        String text = "Please click me";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new CustomClickableSpan(),13,15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    private class CustomClickableSpan extends ClickableSpan
    {
        @Override
        public void onClick(View widget) {

            Toast.makeText(getApplicationContext(),"text has been clicked ...",Toast.LENGTH_SHORT).show();
            textView.setHighlightColor(Color.TRANSPARENT);
        }

        @Override
        public void updateDrawState(TextPaint ds)
        {
            ds.setColor(Color.RED);
        }
    }
}
