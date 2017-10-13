package com.pcsalt.example.alertdialogdemo;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_show_dialog).setOnClickListener(view -> showDialog());
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
}
