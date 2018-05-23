package com.example.yluo.layout;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Layout_frame extends Activity implements View.OnClickListener{
    private ImageView img_playIcon;
    private Button btn_play;
    private Button btn_pause;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayout);
        img_playIcon = findViewById(R.id.img_playIcon);
        btn_play =  findViewById(R.id.btn_play);
        btn_pause =  findViewById(R.id.btn_pause);
        btn_play.setOnClickListener(this);
        btn_pause.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.btn_play)
        {
            img_playIcon.setVisibility(View.INVISIBLE);
        }
        else if(v.getId() == R.id.btn_pause)
        {
            img_playIcon.setVisibility(View.VISIBLE);
        }
    }
}
