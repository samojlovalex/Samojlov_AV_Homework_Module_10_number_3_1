package com.example.samojlov_av_homework_module_10_number_3_1

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samojlov_av_homework_module_10_number_3_1.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbarMain: androidx.appcompat.widget.Toolbar
    private lateinit var editTextET: EditText
    private lateinit var textVieWTV: TextView
    private lateinit var saveDataBT: Button
    private lateinit var deleteDataBT: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()

        setSupportActionBar(toolbarMain)
        title = getString(R.string.toolbar_title)
        toolbarMain.setLogo(R.drawable.toolbar_icon)

        saveDataBT.setOnClickListener(this)
        deleteDataBT.setOnClickListener(this)

    }

    private fun init() {
        toolbarMain = binding.toolbarMain
        editTextET = binding.editTextET
        textVieWTV = binding.textVieWTV
        saveDataBT = binding.saveDataBT
        deleteDataBT = binding.deleteDataBT
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("SetTextI18n", "ShowToast")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMenuMain -> {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.toast_exit),
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("StringFormatInvalid", "SetTextI18n")
    override fun onClick(view: View?) {

        var edit = editTextET.text.toString()
        var save = textVieWTV.text.toString()


        when (view?.id) {
            R.id.saveDataBT -> {
                save = edit
                editTextET.text.clear()
            }

            R.id.deleteDataBT -> {
                Snackbar.make(view, getString(R.string.confirmDeletion), Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.deleteData)) {
                        textVieWTV.text = ""
                        Snackbar.make(
                            view,
                            getString(R.string.dataHasBeenDeleted),
                            Snackbar.LENGTH_LONG
                        ).show()
                    }.show()
            }
        }
        textVieWTV.text = save

    }

}