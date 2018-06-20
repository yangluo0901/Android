package com.example.yangluo.togglebutton;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton;
    private TextView textView;
    private ImageSpan imageSpan;
    private RadioGroup radioGroup;
    private CheckBox cb_horizontal;
    private CheckBox cb_vertical;
    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = findViewById(R.id.toggleButton);
        textView = findViewById(R.id.textView);
        radioGroup = findViewById(R.id.radioGroup);
        cb_horizontal = findViewById(R.id.cb_horizontal);
        cb_vertical = findViewById(R.id.cb_vertical);
        layout = findViewById(R.id.layout);
        Handler handler = new Handler();
        cb_horizontal.setOnCheckedChangeListener(handler);
        cb_vertical.setOnCheckedChangeListener(handler);
        final String text = textView.getText().toString();
        final SpannableString spannableString = new SpannableString(text);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imageSpan = new ImageSpan(getApplicationContext(),R.drawable.cat);
                }
                else
                {
                    imageSpan = new ImageSpan(getApplicationContext(),R.drawable.umbrella);
                }
                spannableString.setSpan(imageSpan,0,text.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.setText(spannableString);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.cat:
                        imageSpan = new ImageSpan(getApplicationContext(),R.drawable.cat);
                        break;
                    case R.id.umbrella:
                        imageSpan = new ImageSpan(getApplicationContext(),R.drawable.umbrella);
                        break;
                }
                spannableString.setSpan(imageSpan,0,text.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.setText(spannableString);
            }
        });
    }
    public class Handler implements CompoundButton.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
            {
                switch(buttonView.getId())
                {
                    case R.id.cb_horizontal:
                        layout.setOrientation(LinearLayout.HORIZONTAL);
                        break;
                    case R.id.cb_vertical:
                        layout.setOrientation(LinearLayout.VERTICAL);
                        break;
                }
            }else
            {
                switch(buttonView.getId())
                {
                    case R.id.cb_horizontal:
                        layout.setOrientation(LinearLayout.VERTICAL);
                        break;
                    case R.id.cb_vertical:
                        layout.setOrientation(LinearLayout.HORIZONTAL);
                        break;
                }
            }


        }
    }
}
