package com.dicoding.picodiploma.learnespresso

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var tvResultView: TextView

    companion object {
        var EXTRA_INPUT = "extra_input"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.title = "Activity Second"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tvResultView = findViewById(R.id.tv_result_view)
        val input = intent.getStringExtra(EXTRA_INPUT)
        tvResultView.text = input
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when {
            item.itemId == android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
