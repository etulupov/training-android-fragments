package com.noveo.trainings.fragments.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.noveo.trainings.fragments.R;

public class TargetFragment extends Fragment implements ConfirmDialogFragment.OnDialogListener {
    public static final int REQUEST_CODE_DIALOG_RESULT = 0;

    public static TargetFragment newInstance(final Context context) {
        return (TargetFragment) Fragment.instantiate(context, TargetFragment.class.getName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fgt_target, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmDialogFragment dialogFragment = ConfirmDialogFragment.newInstance(getActivity());
                dialogFragment.setTargetFragment(TargetFragment.this, REQUEST_CODE_DIALOG_RESULT);
                dialogFragment.show(getChildFragmentManager(), null);
            }
        });
    }


    @Override
    public void confirm() {
        getActivity().finish();
    }

    @Override
    public void dismiss() {
        Toast.makeText(getActivity(), R.string.nothing, Toast.LENGTH_LONG).show();
    }
}
