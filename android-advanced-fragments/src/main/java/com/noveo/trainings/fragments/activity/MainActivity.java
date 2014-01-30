package com.noveo.trainings.fragments.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.noveo.trainings.fragments.R;

public class MainActivity extends ListActivity {

    private static final Class[] CLASSES = {TabActivity.class,
            ViewPagerActivity.class, DetailsActivity.class,
            ListFragmentActivity.class,
            DialogActivity.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] titles = {getString(R.string.title_activity_tab),
                getString(R.string.title_activity_viewpager),
                getString(R.string.title_activity_details),
                getString(R.string.title_activity_list_fragment),
                getString(R.string.title_activity_dialog)};

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles));
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(this, CLASSES[position]);
        startActivity(intent);
    }
}
