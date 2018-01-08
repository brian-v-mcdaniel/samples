package com.planbsoft.modernisticui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


/**
 * Created by Brian McDaniel on 11/12/2015.
 */

public class MoreInfoDialogFragment extends DialogFragment {
    static private final String MESSAGE_TEXT =
            "Inspired by\nabstract modern design.\nClick below to learn more.";
    static private final String NEG_TEXT = "Not Now";
    static private final String POS_TEXT = "Visit MOMA";
    static private final String URL = "http://www.moma.org";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder =  new AlertDialog.Builder(getActivity(), R.style.bluepopup);

        builder
                .setMessage(MESSAGE_TEXT)

                        // User cannot dismiss dialog by hitting back button
                .setCancelable(false)

                        // Set up neg Button
                .setNegativeButton(NEG_TEXT,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                // don't do anything
                            }
                        })

                        // Set up pos Button
                .setPositiveButton(POS_TEXT,
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    final DialogInterface dialog, int id) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                                startActivity(browserIntent);
                            }
                        });
        return builder.create();
    }
}
