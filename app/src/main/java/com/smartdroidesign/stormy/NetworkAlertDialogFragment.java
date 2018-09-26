package com.smartdroidesign.stormy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;

public class NetworkAlertDialogFragment extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(R.string.error_network)
                .setMessage(R.string.error_network_unavailable)
                .setPositiveButton(R.string.error_button_ok_text, null);

        return builder.create();
    }
}
