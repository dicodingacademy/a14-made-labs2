package com.dicoding.picodiploma.mylocalization

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvHello: TextView
    private lateinit var tvPlural: TextView
    private lateinit var tvXliff: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvHello = findViewById(R.id.tv_hello)
        tvPlural = findViewById(R.id.tv_plural)
        tvXliff = findViewById(R.id.tv_xliff)

        val pokeCount = 3
        val hello = resources.getString(R.string.hello_world, "Narenda Wicaksono", pokeCount, "Yoza Aprilio")

        tvHello.text = hello

        val songCount = 5
        val pluralText = resources.getQuantityString(R.plurals.numberOfSongsAvailable, songCount, songCount)
        tvPlural.text = pluralText

        tvXliff.text = resources.getString(R.string.app_homeurl)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }

}
