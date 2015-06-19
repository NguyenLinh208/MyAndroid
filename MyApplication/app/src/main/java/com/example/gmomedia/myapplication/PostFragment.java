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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by usr0200475 on 15/06/19.
 */
public class PostFragment extends Fragment implements View.OnClickListener, Response.ErrorListener, Response.Listener<String>{

    RequestQueue queue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_post, container);

        Button b = (Button) v.findViewById(R.id.button_post);

        b.setOnClickListener(this);

        queue = Volley.newRequestQueue(getActivity());

        return v;
    }

    @Override
    public void onClick(View v) {
        TextView tv_sender = (TextView) getActivity().findViewById(R.id.sender);
        TextView tv_message = (TextView) getActivity().findViewById(R.id.message);
        CheckBox cb_active = (CheckBox) getActivity().findViewById(R.id.active);

        final String sender = tv_sender.getText().toString();
        final String message = tv_message.getText().toString();
        final boolean activate = cb_active.isChecked();

        if(sender.length() == 0){
            Toast.makeText(getActivity(), "名前が入力されていません", Toast.LENGTH_LONG).show();
            return;
        }
        if(message.length()==0){
            Toast.makeText(getActivity(), "メッセージが入力されていません", Toast.LENGTH_LONG).show();
            return;
        }

        String url = "http://157.7.122.113/posts/add";

        StringRequest req = new StringRequest(Request.Method.POST, url, this, this){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String,String>hm = new HashMap<>();
                hm.put("data[Post][thread_id]","1");
                hm.put("data[Post][name]", sender);
                hm.put("data[Post][post]",message);
                hm.put("data[Post][active]",(activate)?"1":"0");

                return hm;
            }
        };
        queue.add(req);
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e("volley", volleyError.getMessage());
        volleyError.printStackTrace();
        getActivity().finish();
    }

    @Override
    public void onResponse(String s) {
        Log.d("volley", "Response : " + s);
        getActivity().finish();
    }

    @Override
    public void onPause() {
        super.onPause();
        queue.stop();
    }

    @Override
    public void onResume() {
        super.onResume();
        queue.start();
    }
}
