package com.dicoding.picodiploma.mynavigationdrawer

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var profileCircleImageView: CircleImageView
    private var profileImageUrl = "https://lh3.googleusercontent.com/-4qy2DfcXBoE/AAAAAAAAAAI/AAAAAAAABi4/rY-jrtntAi4/s640-il/photo.jpg"

    private lateinit var drawer: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Home"

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action") { Toast.makeText(this@MainActivity, "Halo ini action dari snackbar", Toast.LENGTH_SHORT).show() }.show()
        }

        drawer = findViewById(R.id.drawer_layout)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        profileCircleImageView = navigationView.getHeaderView(0).findViewById(R.id.imageView)

        Glide.with(this@MainActivity)
                .load(profileImageUrl)
                .into(profileCircleImageView)

        /*
        Jika savedinstance masih null, maka redirect ke fragment home
        Berguna ketika aplikasi pertama dijalankan untuk mengisi halaman default
        dan berguna juga ketika config changes terjadi, karena fragment akan
        secara otomatis ditambahkan ke dalam activity,
        maka kita tidak perlu replace fragment kembali.
         */
        when (savedInstanceState) {
            null -> {
                val currentFragment = HomeFragment()
                supportFragmentManager.commit {
                    replace(R.id.content_main, currentFragment)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawer.addDrawerListener(toggle)
        toggle.syncState()
    }


    override fun onPause() {
        super.onPause()
        drawer.removeDrawerListener(toggle)
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        when {
            drawer.isDrawerOpen(GravityCompat.START) -> drawer.closeDrawer(GravityCompat.START)
            else -> super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        var fragment: Fragment? = null

        var title = ""

        when (id) {
            R.id.nav_home -> {
                title = "Home"
                fragment = HomeFragment()
            }
            R.id.nav_camera -> {

                /*
            Gunakanlah setarguments untuk mengirimkan data ke fragmet
             */
                title = "Camera"
                fragment = PageFragment()
                fragment.arguments = bundleOf(PageFragment.EXTRAS to title)

            }
            R.id.nav_gallery -> {
                /*
            Gunakanlah setarguments untuk mengirimkan data ke fragmet
             */
                title = "Gallery"
                fragment = PageFragment()
                fragment.arguments = bundleOf(PageFragment.EXTRAS to title)

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }

            /*
            Ganti halaman dengan memanggil fragment replace
             */
        }

        /*
        Ganti halaman dengan memanggil fragment replace
         */

        when {
            fragment != null ->
                supportFragmentManager.commit {
                    replace(R.id.content_main, fragment)
                }
        }

        supportActionBar?.title = title
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
