package com.example.yluo.imageview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

class NetWorkTask extends AsyncTask<String, Void, byte[]> {
    public AsyncResponse delegate =null;
    public NetWorkTask(AsyncResponse asyncResponse)
    {
        delegate = asyncResponse;
    }
    protected byte[] doInBackground(String... urls) {
        Log.d("debug","inside onclick method");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            URL url = new URL("http://img0.bdstatic.com/img/image/shouye/dengni37.jpg");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setDoInput(true);//default is true
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            Log.d("debug","check if response == 200");
            if (httpURLConnection.getResponseCode() == 200)// get response, or 404 not found, 401 unauthorized
            {

            InputStream inputStream = httpURLConnection.getInputStream();
            Log.d("debug","I am here");
            byte[] data = new byte[1024];
            while(inputStream.read(data) != -1)
            {
                byteArrayOutputStream.write(data,0,data.length);
            }
            Log.d("debug","finish byteArrayOutputSteam write");
            byte[] imageData = byteArrayOutputStream.toByteArray();
            return imageData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(byte[] imageData) {
        delegate.processFinish(imageData);
    }
}