package com.example.yluo.myfragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Top_Fragment extends Fragment {
    private EditText top_text1;
    private EditText top_text2;
    TopFragmentInterface topFragmentInterface ;

    public interface TopFragmentInterface
    {
        public void display(String text1, String text2);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        topFragmentInterface = (TopFragmentInterface)getActivity();// getActivity() returns the Activity that this fragment is associated with
                                                                    //get the main_activity reference by casting it to topFragmentInterface
                                                                    // so that when btn click,we can use topFragmentInterface.dispaly()
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment,container,false);
//        return super.onCreateView(inflater, container, savedInstanceState);
        Button btn =  view.findViewById(R.id.button);
        top_text1 =  view.findViewById(R.id.top_text1);
        top_text2 =  view.findViewById(R.id.top_text2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ttext1 =  top_text1.getText().toString();
                String ttext2 =  top_text2.getText().toString();
                //once btn clicked, send ttext1 and ttext2 to main activity
                topFragmentInterface.display(ttext1,ttext2);

            }
        });
        return view;
    }
}
