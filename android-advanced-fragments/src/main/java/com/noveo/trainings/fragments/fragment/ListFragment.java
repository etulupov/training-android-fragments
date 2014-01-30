package com.noveo.trainings.fragments.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends android.support.v4.app.ListFragment {
    private static final String LIST_INDEX = "index";
    private static final String LIST_TOP = "top";

    public static ListFragment newInstance(final Context context) {
        return (ListFragment) Fragment.instantiate(context, ListFragment.class.getName());
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> items = new ArrayList<String>();

        for (int i = 0; i < 100; i++) {
            items.add(Integer.toString(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                items);
        setListAdapter(adapter);

        if (savedInstanceState != null) {
            getListView().setSelectionFromTop(savedInstanceState.getInt(LIST_INDEX),
                    savedInstanceState.getInt(LIST_TOP));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        int index = getListView().getFirstVisiblePosition();
        View v = getListView().getChildAt(0);
        int top = (v == null) ? 0 : v.getTop();

        outState.putInt(LIST_INDEX, index);
        outState.putInt(LIST_TOP, top);
    }
}
