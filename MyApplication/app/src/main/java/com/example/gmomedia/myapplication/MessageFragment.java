package com.example.gmomedia.myapplication;

import android.app.ListFragment;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by usr0200475 on 15/06/19.
 */
public class MessageFragment extends ListFragment{
    ArrayAdapter<Spanned> adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] contentString = {"<b>Title1</b><br>Content1",
                                  "<b>Title2</b><br>Content2",
                                  "<b>Title3</b><br>Content3"};

        ArrayList list = new ArrayList<>();
        for (int i = 0; i < contentString.length; i++) {
            list.add(Html.fromHtml(contentString[i]));
        }
        adapter = new ArrayAdapter<>(getActivity(), R.layout.message_item, R.id.text1, list);
        setListAdapter(adapter);
        getListView().setDividerHeight(5);
    }

    public void reload(){
        String msg = "New content";
        adapter.add(Html.fromHtml(msg));
    }
}
