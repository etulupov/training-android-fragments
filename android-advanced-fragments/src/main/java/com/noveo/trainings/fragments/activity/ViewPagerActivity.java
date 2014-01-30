package com.noveo.trainings.fragments.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.noveo.trainings.fragments.R;
import com.noveo.trainings.fragments.adapter.PagerAdapter;
import com.noveo.trainings.fragments.fragment.FirstFragment;
import com.noveo.trainings.fragments.fragment.NestedFragment;
import com.noveo.trainings.fragments.fragment.SecondFragment;
import com.noveo.trainings.fragments.fragment.ThirdFragment;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.Arrays;

public class ViewPagerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);


        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),
                Arrays.asList(FirstFragment.newInstance(this),
                        SecondFragment.newInstance(this),
                        ThirdFragment.newInstance(this),
                        NestedFragment.newInstance(this)
                ));
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
    }


}
