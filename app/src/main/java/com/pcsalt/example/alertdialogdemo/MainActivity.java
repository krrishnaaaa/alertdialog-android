package com.pcsalt.example.alertdialogdemo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_show_dialog).setOnClickListener(view -> displaySingleSelectionDialog());
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

    /*
    display dialog to select multiple options
     */
    private boolean[] checkedItems = new boolean[7];
    private String[] colors;
    private List<String> selectedColors = new ArrayList<>();

    private void displayMultiSelectDialog() {
        colors = getResources().getStringArray(R.array.rainbow_colors);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Select primary colors");
        dialogBuilder.setMultiChoiceItems(colors, checkedItems,
                (dialogInterface, which, isSelected) -> {
                    if (isSelected) {
                        selectedColors.add(colors[which]);
                    } else {
                        selectedColors.remove(colors[which]);
                    }
                }
        );
        dialogBuilder.setPositiveButton("Done", (dialog, which) -> showSelectedColors());
        dialogBuilder.create().show();
    }

    private void showSelectedColors() {
        // do whatever you want to do with the user choice(s)
        Toast.makeText(this, selectedColors.toString(), Toast.LENGTH_SHORT).show();
    }

    /*
    display dialog to select single option
     */
    private int checkedItem = -1;
    private String[] androidVersions;

    private void displaySingleSelectionDialog() {
        androidVersions = getResources().getStringArray(R.array.android_versions);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Which version you are using?");
        dialogBuilder.setSingleChoiceItems(androidVersions, checkedItem,
                (dialogInterface, which) -> {
                    checkedItem = which;
                });
        dialogBuilder.setPositiveButton("Done", (dialog, which) -> showSelectedVersion());
        dialogBuilder.create().show();
    }

    private void showSelectedVersion() {
        Toast.makeText(this, "You selected: " + androidVersions[checkedItem], Toast.LENGTH_SHORT).show();
    }
}
