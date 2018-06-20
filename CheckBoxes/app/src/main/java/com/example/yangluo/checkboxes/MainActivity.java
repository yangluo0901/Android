package com.example.yangluo.checkboxes;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private List<CheckBox> cb_list = new ArrayList<CheckBox>();;
    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        layout = findViewById(R.id.layout);
        String [] str = {"Lee sin", "Ahri", "Caitlyn","Teemo"};
        for(String string : str)
        {
            CheckBox checkbox = (CheckBox)View.inflate(this,R.layout.checkbox,null);
            checkbox.setText(string);
            cb_list.add(checkbox);
            layout.addView(checkbox);
        }
        btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                String string= " ";
                for(CheckBox checkBox : cb_list)
                {
                    if(checkBox.isChecked())
                    {
                        string += checkBox.getText().toString()+"\n";
                    }
                }
                Toast.makeText(getApplicationContext(),string,Toast.LENGTH_LONG).show();
            }
        });
    }
}
