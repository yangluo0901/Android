package com.example.yluo.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button addButton = (Button) findViewById(R.id.addButton);
        final EditText firstNum =  (EditText) findViewById(R.id.firstNumEditText);
        final EditText secondNum =  (EditText) findViewById(R.id.secondNumEditText);
        final TextView result = (TextView) findViewById(R.id.resultTextView);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num1 = Integer.parseInt(firstNum.getText().toString());
                int num2 = Integer.parseInt(secondNum.getText().toString());
                int sum = num1 + num2;
                result.setText(sum+"");
            }
        });
        addButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                addButton.setText(R.string.Minus);
                int num1 = Integer.parseInt(firstNum.getText().toString());
                int num2 = Integer.parseInt(secondNum.getText().toString());
                int sub =  num1 - num2;
                result.setText(sub +"");
                return false;//return true means that if you hold the button, minus, and listener would stop here
                            // however, if return false, when you leave the button, the onclicklistener will keep taking care of it.
            }
        });

    }
}
