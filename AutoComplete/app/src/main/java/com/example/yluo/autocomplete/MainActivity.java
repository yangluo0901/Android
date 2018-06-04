package com.example.yluo.autocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView = findViewById(R.id.autoTextView);
        String [] autoString = {"Saint Louis","San Diego", "Santa Monica","Louisiana"};
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,R.layout.autotextview,autoString);
        autoCompleteTextView.setAdapter(adapter);
    }
}
