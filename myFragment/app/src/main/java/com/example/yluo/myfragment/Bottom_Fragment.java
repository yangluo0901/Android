package com.example.yluo.myfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class Bottom_Fragment extends Fragment {
    private EditText bottom_text1;
    private EditText bottom_text2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_fragment,container,false);
//        return super.onCreateView(inflater, container, savedInstanceState);
        bottom_text1 =  view.findViewById(R.id.bottom_text1);
        bottom_text2 =  view.findViewById(R.id.bottom_text2);
        return view;
    }
    public void setText(String str1, String str2)
    {
        bottom_text1.setText(str1);
        bottom_text2.setText(str2);
    }
}
