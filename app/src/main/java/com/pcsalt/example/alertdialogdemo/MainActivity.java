package com.pcsalt.example.alertdialogdemo;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_show_dialog).setOnClickListener(view -> displayDialogWithIcon());
    }

    /*
    display information dialog
     */
    private void showDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Info");
        dialogBuilder.setMessage("Some informative message for the user.");
        dialogBuilder.setPositiveButton("Done", (dialog, which) -> dialog.dismiss());
        dialogBuilder.create().show();
    }

    /*
    display rate dialog
     */
    private void rateDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Rate Us");
        dialogBuilder.setMessage("If you liked it, please rate it." +
                " If you do not like it rate it." +
                " It will help us grow.");
        dialogBuilder.setPositiveButton("Rate", (dialog, which) -> {
            // take user to the page to rate
            // and dismiss the dialog
            dialog.dismiss();
        });

        dialogBuilder.setNegativeButton("Leave it", (dialog, which) -> {
            // set a flag in system, that user do not want to rate
            // and dismiss the dialog
            dialog.dismiss();
        });

        dialogBuilder.setNeutralButton("May be, later", (dialog, which) -> dialog.dismiss());

        dialogBuilder.create().show();

    }

    /*
    display dialog with icons
     */
    private void displayDialogWithIcon() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Info");
        dialogBuilder.setIcon(R.mipmap.ic_launcher_round);
        dialogBuilder.setMessage("You know, you could have provided some valuable message here!");
        dialogBuilder.setPositiveButton("Got it", (dialog, which) -> dialog.dismiss());
        dialogBuilder.create().show();
    }
}
