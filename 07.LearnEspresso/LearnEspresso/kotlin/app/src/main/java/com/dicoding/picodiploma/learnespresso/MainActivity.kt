package com.dicoding.picodiploma.learnespresso

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtText: EditText
    private lateinit var btnChangeText: Button
    private lateinit var btnSwitchActivity: Button
    private lateinit var tvPrintedText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Learn Espresso"


        edtText = findViewById(R.id.edt_text)
        btnChangeText = findViewById(R.id.btn_change_text)
        btnSwitchActivity = findViewById(R.id.btn_swicth_activity)
        tvPrintedText = findViewById(R.id.tv_printed_text)

        btnChangeText.setOnClickListener(this)
        btnSwitchActivity.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_change_text -> {
                val lalalaText = "Lalala"
                edtText.setText(lalalaText)
                val input = edtText.text.toString().trim { it <= ' ' }
                tvPrintedText.text = input
            }

            R.id.btn_swicth_activity -> {
                val text = edtText.text.toString().trim { it <= ' ' }
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(SecondActivity.EXTRA_INPUT, text)
                startActivity(intent)
            }
        }
    }
}
