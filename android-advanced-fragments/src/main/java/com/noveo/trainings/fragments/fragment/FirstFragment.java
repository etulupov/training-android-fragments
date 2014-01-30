package com.noveo.trainings.fragments.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noveo.trainings.fragments.R;

public class FirstFragment extends Fragment {
    public static FirstFragment newInstance(final Context context) {
        return (FirstFragment) Fragment.instantiate(context, FirstFragment.class.getName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fgt_first, container, false);
    }
}
