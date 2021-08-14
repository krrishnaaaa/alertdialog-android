package com.pcsalt.example.alertdialogdemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pcsalt.example.alertdialogdemo.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnShowDialog.setOnClickListener { showDialog() }
            btnRateDialog.setOnClickListener { rateDialog() }
            btnDialogWithIcon.setOnClickListener { displayDialogWithIcon() }
            btnMultiselect.setOnClickListener { displayMultiSelectDialog() }
            btnSingleSelection.setOnClickListener { displaySingleSelectionDialog() }
        }
    }

    /*
    display information dialog
     */
    private fun showDialog() {
        val dialogBuilder = AlertDialog.Builder(this).apply {
            setTitle("Info")
            setMessage("Some informative message for the user.")
            setPositiveButton("Done") { dialog, _ -> dialog.dismiss() }
        }
        dialogBuilder.create().show()
    }

    /*
    display rate dialog
     */
    private fun rateDialog() {
        val dialogBuilder = AlertDialog.Builder(this).apply {
            setTitle("Rate Us")
            setMessage(
                """
                    If you liked it, please rate it.
                    If you do not like it rate it.
                    It will help us grow.
                """.trimIndent()
            )
            setPositiveButton(
                "Rate"
            ) { dialog, _ ->
                // take user to the page to rate
                // and dismiss the dialog
                dialog.dismiss()
            }
            setNegativeButton(
                "Leave it"
            ) { dialog, _ ->
                // set a flag in system, that user do not want to rate
                // and dismiss the dialog
                dialog.dismiss()
            }
            setNeutralButton("May be, later") { dialog, _ -> dialog.dismiss() }
        }
        dialogBuilder.create().show()
    }

    /*
    display dialog with icons
     */
    private fun displayDialogWithIcon() {
        val dialogBuilder = AlertDialog.Builder(this).apply {
            setTitle("Info")
            setIcon(R.mipmap.ic_launcher_round)
            setMessage("You know, you could have provided some valuable message here!")
            setPositiveButton("Got it") { dialog, _ -> dialog.dismiss() }
        }
        dialogBuilder.create().show()
    }

    /*
    display dialog to select multiple options
     */
    private val checkedItems = BooleanArray(7)
    private var colors: Array<String> = emptyArray()
    private val selectedColors: MutableList<String> = ArrayList()

    private fun displayMultiSelectDialog() {
        colors = resources.getStringArray(R.array.rainbow_colors)
        val dialogBuilder = AlertDialog.Builder(this).apply {
            setTitle("Select primary colors")
            setMultiChoiceItems(
                colors, checkedItems
            ) { _, which, isSelected ->
                if (isSelected) {
                    selectedColors.add(colors[which])
                } else {
                    selectedColors.remove(colors[which])
                }
            }
            setPositiveButton("Done") { _, _ -> showToast(selectedColors.toString()) }
        }
        dialogBuilder.create().show()
    }

    /*
    display dialog to select single option
     */
    private var checkedItem = -1
    private var androidVersions: Array<String> = emptyArray()

    private fun displaySingleSelectionDialog() {
        androidVersions = resources.getStringArray(R.array.android_versions)
        val dialogBuilder = AlertDialog.Builder(this).apply {
            setTitle("Which version you are using?")
            setSingleChoiceItems(androidVersions, checkedItem) { _, which ->
                checkedItem = which
            }
            setPositiveButton("Done") { _, _ ->
                showToast("You selected ${androidVersions[checkedItem]}")
            }
        }
        dialogBuilder.create().show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
        Log.d("TAG", "message: $message")
    }

}