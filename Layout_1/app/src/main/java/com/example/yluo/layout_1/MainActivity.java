package com.example.yluo.layout_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //define a layout
        RelativeLayout relative_layout =  new RelativeLayout(this);
        //define layout paramenters
        RelativeLayout.LayoutParams relative_layoutpara =  new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );
        ////////////////////////define a button////////////////////////////
        Button btn = new Button(this);
        btn.setId(R.id.btn);
        btn.setText("LOG IN");
        //define button's layout params
        RelativeLayout.LayoutParams button_layoutpara =  new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT //WRAP_CONTENT, MATCH_PARENT  are contants from View.LayoutParams
        );
        // add more rules to button_layoutpara
        button_layoutpara.addRule(RelativeLayout.CENTER_IN_PARENT);
        btn.setLayoutParams(button_layoutpara);
        // add button to relative_layout
        relative_layout.addView(btn); // or can do : relative_layout.addView(btn,button_layoutpara)
        // set relative_layout as content view with the relative_layoutpara
        /////////////////////////////define a edittext///////////////////////
        EditText username =  new EditText(this);
        username.setId(R.id.username);
        username.setHint("Username");
        username.setGravity(Gravity.CENTER_HORIZONTAL);
        RelativeLayout.LayoutParams username_layoutpara =  new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        username_layoutpara.addRule(RelativeLayout.ABOVE,btn.getId());
        username_layoutpara.addRule(RelativeLayout.CENTER_HORIZONTAL);
        username_layoutpara.setMargins(0,0,0,50);
        username.setLayoutParams(username_layoutpara);
        username.getLayoutParams().width=300;
        System.out.println("I am here" + username.getLayoutParams().width );
        System.out.println("i am here .............." );
        relative_layout.addView(username);
        ////////////////////////define email////////////////////////////
        EditText email = new EditText(this);
        email.setId(R.id.email);
        email.setHint("E-mail");
        email.setGravity(Gravity.CENTER_HORIZONTAL);
        email.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        RelativeLayout.LayoutParams email_layoutpara =  new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        email_layoutpara.addRule(RelativeLayout.ABOVE,username.getId());
        email_layoutpara.addRule(RelativeLayout.CENTER_HORIZONTAL);
        email_layoutpara.setMargins(0,0,0,50);
        email.setLayoutParams(email_layoutpara);
        email.setWidth(300);
        relative_layout.addView(email);
        setContentView(relative_layout,relative_layoutpara);
    }
}
