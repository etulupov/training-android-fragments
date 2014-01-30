package com.noveo.trainings.fragments.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noveo.trainings.fragments.R;

public class SecondFragment extends Fragment {
    public static SecondFragment newInstance(final Context context) {
        return (SecondFragment) Fragment.instantiate(context, SecondFragment.class.getName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fgt_second, container, false);
    }
}
