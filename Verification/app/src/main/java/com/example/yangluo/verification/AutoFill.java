package com.example.yangluo.verification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class AutoFill extends AppCompatActivity{
    private AutoCompleteTextView autoText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autofill);
        autoText = findViewById(R.id.autoText);
        String [] objects = {"Saint Louis", "Santa Clarita","San Jose"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.autocompletetext,objects);
        autoText.setAdapter(adapter);
    }
}
