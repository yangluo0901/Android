package com.example.yluo.imageview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener,View.OnClickListener {
    private SeekBar seekBar;
    private SeekBar seekBar2;
    private TextView textView;
    private TextView textView2;
    private ImageView imageView;
    private Matrix matrix;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*define elements */
        seekBar = findViewById(R.id.seekBar);
        seekBar2 = findViewById(R.id.seekBar2);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        /*set up elements*/
        seekBar.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        seekBar.setMax(metrics.heightPixels);
        btn.setOnClickListener(this);
        Log.d("debug","finish elements set up");

    }

    @Override
    public void onClick(View v) {
        NetWorkTask netWorkTask = new NetWorkTask(new AsyncResponse() {
            @Override
            public void processFinish(byte[] imageData) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageData,0,imageData.length);
                imageView.setImageBitmap(bitmap);
                Log.d("debug","just make bitmap");
            }
        });
        netWorkTask.execute();

    }



    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.seekBar)//resize
        {
            int height = progress;
            int width = (int)(progress*0.75);
            textView.setText("Resize: " +progress);
            imageView.setLayoutParams(new ConstraintLayout.LayoutParams(width,height));
        }else
        {
            textView.setText("Rotate: " +progress);
            matrix = new Matrix();
            matrix.setRotate(progress);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pic);
            Bitmap bitmap1 = bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
            imageView.setImageBitmap(bitmap1);


        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
