package com.example.yangluo.verification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText et_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =  findViewById(R.id.button);
        et_number = findViewById(R.id.et_number);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CharSequence text =  et_number.getText();
                if (TextUtils.isEmpty(text))
                {
                    et_number.requestFocus();
                    et_number.setError(" Cannot be empty");
                }
            }
        });
    }
}
