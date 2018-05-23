package com.example.yluo.myfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Top_Fragment.TopFragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {// attached fragments to activity, at this time onattach() will be called
        super.onCreate(savedInstanceState);
        Fragment fragment =  new Middle_Fragment();
        FragmentManager fragmentManager =  getFragmentManager();
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,fragment);
        fragmentTransaction.commit(); // to commit transaction!!!!!!!!!!!!!!!
        setContentView(R.layout.activity_main);

    }

    @Override
    public void display(String text1, String text2) {
        Bottom_Fragment bottom_fragment = (Bottom_Fragment)getFragmentManager().findFragmentById(R.id.fragment6);
        bottom_fragment.setText(text1,text2);
    }
}
//ANALYSIS:

//1. create a method inside bottom fragment, setText(text1,text2), to enable mainactivity have access to set text;
//2. when top fragment and bottom fragment attach to the main_activity, onAttach() will call a method display(top_text1, top_text2) inside main_activity. The information of top text would be passed along
//3. In order to call main_activity.display(...), we need a main_activity reference inside top fragment, so we create a topFragmentInterface that mian_activity can implements,and  cast main_activty into topFragmentInterface.