package com.noveo.trainings.fragments.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.noveo.trainings.fragments.R;
import com.noveo.trainings.fragments.fragment.FirstFragment;
import com.noveo.trainings.fragments.fragment.MenuFragment;
import com.noveo.trainings.fragments.fragment.NestedFragment;
import com.noveo.trainings.fragments.fragment.SecondFragment;
import com.noveo.trainings.fragments.fragment.ThirdFragment;
import com.noveo.trainings.fragments.util.FragmentUtils;

public class DetailsActivity extends FragmentActivity {

    private MenuFragment menuFragment;
    private static final String TAG_MENU = "menu";
    private static final String TAG_DETAILS = "details";
    private static final String SELECTED_ITEM = "selected_item";
    private static final int NOTHING_SELECTED = -1;
    private int selectedItem = NOTHING_SELECTED;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (savedInstanceState == null) {
            menuFragment = MenuFragment.newInstance(this);

            FragmentUtils.replace(getSupportFragmentManager(),
                    R.id.container, menuFragment, TAG_MENU
            );

        } else {
            menuFragment = (MenuFragment) getSupportFragmentManager().findFragmentByTag(TAG_MENU);
            selectedItem = savedInstanceState.getInt(SELECTED_ITEM);
        }
        if (menuFragment != null) {
            menuFragment.setOnItemClickListener(new MenuFragment.OnItemClickListener() {
                @Override
                public void onItemClick(int postition) {
                    selectedItem = postition;
                    if (isLandscapeMode()) {
                        Fragment fragment = getFragment(postition);
                        FragmentUtils.replace(getSupportFragmentManager(),
                                R.id.details_container, fragment, TAG_DETAILS
                        );
                    } else {
                        Fragment fragment = getFragment(postition);
                        FragmentUtils.replaceWithBackStack(getSupportFragmentManager(),
                                R.id.container, fragment, TAG_DETAILS
                        );
                    }
                }
            });
        }

        if (isLandscapeMode()) {
            if (selectedItem != NOTHING_SELECTED) {
                FragmentUtils.clearBackStack(getSupportFragmentManager());
                FragmentUtils.replace(getSupportFragmentManager(),
                        R.id.container, menuFragment, TAG_MENU
                );
                Fragment fragment = getFragment(selectedItem);
                FragmentUtils.replace(getSupportFragmentManager(),
                        R.id.details_container, fragment, TAG_DETAILS
                );
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_ITEM, selectedItem);
    }

    private Fragment getFragment(int postition) {
        switch (postition) {
            case 0:
                return FirstFragment.newInstance(this);
            case 1:
                return SecondFragment.newInstance(this);
            case 2:
                return ThirdFragment.newInstance(this);
            case 3:
                return NestedFragment.newInstance(this);
        }
        return null;
    }

    private boolean isLandscapeMode() {
        return (findViewById(R.id.details_container) != null);
    }


}
