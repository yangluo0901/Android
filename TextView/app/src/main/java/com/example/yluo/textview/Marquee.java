package com.example.yluo.textview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Marquee extends Activity {
    private MyTextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marquee);
        textView = (MyTextView)findViewById(R.id.textView);
        textView.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_HOVER_ENTER)
                {
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    Toast.makeText(getApplicationContext(),"hovered",Toast.LENGTH_SHORT);
                }
                else
                {
                    textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    Toast.makeText(getApplicationContext(),"NOT hovered",Toast.LENGTH_SHORT);
                }
                return false;
            }
        });
    }
}
