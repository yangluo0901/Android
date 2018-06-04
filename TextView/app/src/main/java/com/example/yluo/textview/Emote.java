package com.example.yluo.textview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.SpannableString;

public class Emote extends Activity {
    private EditText emote;
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emote);
        button = findViewById(R.id.button);
        emote = findViewById(R.id.emote);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString span = new SpannableString("emote");
                Bitmap img = BitmapFactory.decodeResource(getResources(),R.drawable.image5);
                ImageSpan imageSpan =  new ImageSpan(getApplicationContext(),img);
                span.setSpan(imageSpan,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                emote.append(span);
            }
        });
    }
}
