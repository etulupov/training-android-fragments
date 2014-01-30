package com.noveo.trainings.fragments.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

import com.noveo.trainings.fragments.R;


public class ConfirmDialogFragment extends DialogFragment {
    public interface OnDialogListener {
        void confirm();

        void dismiss();
    }


    public static ConfirmDialogFragment newInstance(final Context context) {
        return (ConfirmDialogFragment) Fragment.instantiate(context, ConfirmDialogFragment.class.getName());
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((OnDialogListener) getTargetFragment()).confirm();
                        dismiss();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((OnDialogListener) getTargetFragment()).dismiss();
                        dismiss();
                    }
                })
                .create();
    }
}
