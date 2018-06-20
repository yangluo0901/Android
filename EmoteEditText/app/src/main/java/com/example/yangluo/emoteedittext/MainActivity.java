package com.example.yangluo.emoteedittext;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =  findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString span = new SpannableString("a");
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.emote);
                bitmap = bitmap.createScaledBitmap(bitmap,(int)(bitmap.getWidth()*0.1),(int)(bitmap.getHeight()*0.1),true);
                ImageSpan imageSpan = new ImageSpan(getApplicationContext(), bitmap);
                span.setSpan(imageSpan,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                editText.append(span);
            }
        });
    }
}
