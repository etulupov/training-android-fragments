package com.noveo.trainings.fragments.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.noveo.trainings.fragments.R;
import com.noveo.trainings.fragments.fragment.FirstFragment;
import com.noveo.trainings.fragments.fragment.NestedFragment;
import com.noveo.trainings.fragments.fragment.SecondFragment;
import com.noveo.trainings.fragments.fragment.ThirdFragment;

public class TabActivity extends ActionBarActivity {
    private static final String TAB_INDEX = "tab_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab()
                .setText(R.string.tab_title_first)
                .setTabListener(new TabListener(
                        this, FirstFragment.class)));

        actionBar.addTab(actionBar.newTab()
                .setText(R.string.tab_title_second)
                .setTabListener(new TabListener(
                        this, SecondFragment.class)));

        actionBar.addTab(actionBar.newTab()
                .setText(R.string.tab_title_third)
                .setTabListener(new TabListener(
                        this, ThirdFragment.class)));

        actionBar.addTab(actionBar.newTab()
                .setText(R.string.tab_title_nested)
                .setTabListener(new TabListener(
                        this, NestedFragment.class)));

        if (savedInstanceState != null) {
            actionBar.setSelectedNavigationItem(savedInstanceState.getInt(TAB_INDEX, 0));
        }
    }

    @Override
    @SuppressLint("NewApi")
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (Build.VERSION.SDK_INT >= 11) {
            outState.putInt(TAB_INDEX, getActionBar().getSelectedNavigationIndex());
        }
    }


    public static class TabListener implements ActionBar.TabListener {
        private final Context context;

        private final Class<? extends Fragment> clazz;

        private Fragment fragment;

        public TabListener(Context context, Class<? extends Fragment> clazz) {
            this.context = context;
            this.clazz = clazz;
        }

        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            if (fragment == null) {
                fragment = Fragment.instantiate(context, clazz.getName());
                ft.add(android.R.id.content, fragment);
            } else {
                ft.attach(fragment);
            }
        }

        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            if (fragment != null) {
                ft.detach(fragment);
            }
        }

        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    }
}
