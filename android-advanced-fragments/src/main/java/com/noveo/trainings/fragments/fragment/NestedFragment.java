package com.noveo.trainings.fragments.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noveo.trainings.fragments.R;
import com.noveo.trainings.fragments.util.FragmentUtils;

public class NestedFragment extends Fragment {
    public static NestedFragment newInstance(final Context context) {
        return (NestedFragment) Fragment.instantiate(context, NestedFragment.class.getName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fgt_nested, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState == null) {
            FragmentUtils.replace(getChildFragmentManager(),
                    R.id.container_1,
                    FirstFragment.newInstance(getActivity()),
                    null);
            FragmentUtils.replace(getChildFragmentManager(),
                    R.id.container_2,
                    SecondFragment.newInstance(getActivity()),
                    null);
        }
    }
}
