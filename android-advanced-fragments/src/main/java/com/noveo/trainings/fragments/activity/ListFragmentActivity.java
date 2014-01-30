package com.noveo.trainings.fragments.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.noveo.trainings.fragments.R;

public class ListFragmentActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fragment);
    }
}
