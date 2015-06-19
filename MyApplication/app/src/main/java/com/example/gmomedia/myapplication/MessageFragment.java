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

//        String[] listItems = {"Frag1","Frag2","Frag3" };
//        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_expandable_list_item_1, listItems);
//        setListAdapter(adapter);
        String[] contentString = {"<b>Title1</b><br>Content1",
                      "<b>Title2</b><br>Content2",
                      "<b>Titlte3</b><br>Content3"};

        ArrayList list = new ArrayList<>();
        for (int i = 0; i < contentString.length; i++) {
            list.add(Html.fromHtml(contentString[i]));
        }
        ArrayAdapter<Spanned> adapter = new ArrayAdapter<>(getActivity(), R.layout.message_item, R.id.text1, list);
        setListAdapter(adapter);
        getListView().setDivider(null);
    }

    public void reload(){
        String msg = "RELOADING";
        adapter.add(Html.fromHtml(msg));
    }
}
