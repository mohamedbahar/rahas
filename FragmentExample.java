package com.viwepager.mohamedbahars.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mohamedbahars on 27-09-2016.
 */
public class FragmentExample extends Fragment {

   View rootview;
    TextView textView1,textView2,textView3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.framgentone,container,false);

        textView1 = (TextView) rootview.findViewById(R.id.textview1);
        textView2 = (TextView) rootview.findViewById(R.id.textview2);
        textView3 = (TextView) rootview.findViewById(R.id.textview3);

        textView1.setText(getArguments().getString("msg1"));
        textView2.setText(getArguments().getString("msg2"));
        textView3.setText(getArguments().getString("msg3"));



        return rootview  ;
    }

    public static FragmentExample newInstance(String text1,String text2,String text3) {

        FragmentExample f = new FragmentExample();
        Bundle b = new Bundle();
        b.putString("msg1", text1);
        b.putString("msg2", text2);
        b.putString("msg3", text3);

        f.setArguments(b);

        return f;
    }
}
