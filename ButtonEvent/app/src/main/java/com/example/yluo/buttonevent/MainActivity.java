package com.example.yluo.buttonevent;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_1;
    private Button star;
    private Button picText;
    private int value = 1; // 1 enlarge, -1 shrink
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_1 = findViewById(R.id.btn_1);
        star = findViewById(R.id.star);
        picText =  findViewById(R.id.picText);
        String text = "apicture and textb";
        SpannableString spannableString = new SpannableString(text);
        ImageSpan imageSpanLeft =  new ImageSpan(getApplicationContext(), BitmapFactory.decodeResource(getResources(),R.drawable.image_left));
        ImageSpan imageSpanRight =  new ImageSpan(getApplicationContext(), BitmapFactory.decodeResource(getResources(),R.drawable.image_right));
        spannableString.setSpan(imageSpanLeft,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(imageSpanRight,text.length()-1,text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        picText.setText(spannableString);
        Handler handler = new Handler();
        btn_1.setOnClickListener(handler);
        star.setOnClickListener(handler);
        star.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    star.setBackgroundResource(R.drawable.button2);
                }else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    star.setBackgroundResource(R.drawable.button1);
                }
                return true; //since it returns true, it wont pass the event to other listener, in this case onclick. The start would not change the size.
            }
        });
        star.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    star.setBackgroundColor(Color.RED);

                }else
                {
                    star.setBackgroundColor(Color.GRAY);
                }
            }
        });
    }
    private class Handler implements View.OnClickListener
    {
        private int windowWidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        @Override
        public void onClick(View v)
        {
            Log.d("debug","buttn is clicked");
            Button btn = (Button)v;
            Log.d("debug","the button width before clikcing is "+Integer.toString(btn.getWidth()));
                Log.d("debug","value is "+value);
                Log.d("debug","window width is " + windowWidth);
                if (value == 1 && btn.getWidth() >= windowWidth)
                {
                    value = -1;
                    Log.d("debug",Integer.toString(value) +"  inside if statement");
                }else if (value == -1 && btn.getWidth()<=200)
                {
                    value = 1;
                    Log.d("debug",Integer.toString(value));
                }
                btn.setLayoutParams(new ConstraintLayout.LayoutParams((int)(btn.getWidth()*(1+value*0.1)), (int)(btn.getHeight()*(1+value*0.1))));
                Log.d("debug","button width after click  " +btn.getWidth());
        }
    }
}
