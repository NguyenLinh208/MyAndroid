package com.example.gmomedia.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_reload) {
            MessageFragment fragment = (MessageFragment)getFragmentManager().findFragmentById(R.id.fragmentView);
            fragment.reload();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
