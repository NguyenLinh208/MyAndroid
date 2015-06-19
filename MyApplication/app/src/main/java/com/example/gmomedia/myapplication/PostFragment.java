package com.example.gmomedia.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by usr0200475 on 15/06/19.
 */
public class PostFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_post, container);

        Button b = (Button) v.findViewById(R.id.button_post);

        b.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        TextView tv_sender = (TextView)getActivity().findViewById(R.id.sender);
        TextView tv_message = (TextView)getActivity().findViewById(R.id.message);
        CheckBox cb_active = (CheckBox)getActivity().findViewById(R.id.active);

        Log.d("post", tv_sender.getText().toString());
        Log.d("post", tv_message.getText().toString());
        Log.d("active", Boolean.toString(cb_active.isChecked()));

    }
}
