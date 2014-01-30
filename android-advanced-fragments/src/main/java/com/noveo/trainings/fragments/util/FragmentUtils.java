package com.noveo.trainings.fragments.util;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class FragmentUtils {
    private FragmentUtils() {
        throw new UnsupportedOperationException();
    }

    public static void replace(FragmentManager fm, int container, Fragment fragment, String tag) {
        fm.beginTransaction()
                .replace(container, fragment, tag)
                .commit();
    }

    public static void replaceWithBackStack(FragmentManager fm, int container,
                                            Fragment fragment, String tag) {
        fm.beginTransaction()
                .replace(container, fragment, tag)
                .addToBackStack(tag)
                .commit();
    }

    public static void clearBackStack(FragmentManager fm) {
        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
            fm.popBackStack();
        }
    }

    public static void closeFragment(FragmentManager fm) {
        fm.popBackStack();
    }
}
