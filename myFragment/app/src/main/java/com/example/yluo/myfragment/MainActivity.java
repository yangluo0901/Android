package com.example.yluo.myfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment fragment =  new Middle_Fragment();
        FragmentManager fragmentManager =  getFragmentManager();
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,fragment);
        setContentView(R.layout.activity_main);
        Button btn =  findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText top_text1 =  findViewById(R.id.top_text1);
                EditText top_text2 =  findViewById(R.id.top_text2);
                EditText bottom_text1 =  findViewById(R.id.bottom_text1);
                EditText bottom_text2 =  findViewById(R.id.bottom_text2);
                String ttext1 =  top_text1.getText().toString();
                String ttext2 =  top_text2.getText().toString();
                bottom_text1.setText(ttext1);
                bottom_text2.setText(ttext2);
            }
        });
    }
}
