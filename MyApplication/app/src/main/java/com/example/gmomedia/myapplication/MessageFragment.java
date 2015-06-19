package com.example.gmomedia.myapplication;

import android.app.ListFragment;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by usr0200475 on 15/06/19.
 */
public class MessageFragment extends ListFragment implements Response.Listener<JSONObject>, Response.ErrorListener{
    ArrayAdapter<Spanned> adapter;
    RequestQueue queue = null;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        String[] contentString = {"<b>Title1</b><br>Content1",
//                                  "<b>Title2</b><br>Content2",
//                                  "<b>Title3</b><br>Content3"};
//
//        ArrayList list = new ArrayList<>();
//        for (int i = 0; i < contentString.length; i++) {
//            list.add(Html.fromHtml(contentString[i]));
//        }

        queue = Volley.newRequestQueue(getActivity());
        ArrayList<Spanned> list = new ArrayList<>();
        adapter = new ArrayAdapter<>(getActivity(), R.layout.message_item, R.id.text1, list);
        setListAdapter(adapter);
        getListView().setDividerHeight(5);
        reload();
    }

    public void reload(){
        String url = "http://157.7.122.113/posts/index.json";
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,url,this,this);
        queue.add(req);
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {

        Log.d("Volley", volleyError.getMessage());
        volleyError.printStackTrace();

    }

    @Override
    public void onResponse(JSONObject jsonObject) {

        ArrayList<Spanned> l = new ArrayList<>();

        try {

            JSONArray posts = jsonObject.getJSONArray("posts");

            for (int i = 0; i < posts.length(); i++) {

                JSONObject post = posts.getJSONObject(i).getJSONObject("Post");
                String s = "<font color=\"#cc3333\"><b>" + post.getString("name") + "</b></font><br/>" + post.getString("post");
                l.add(Html.fromHtml(s));

            }

            adapter.clear();
            adapter.addAll(l);

        } catch (JSONException e) {
            Log.e("volley", e.getMessage());
            e.printStackTrace();
        }

    }
}
