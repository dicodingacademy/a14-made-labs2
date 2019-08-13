package com.dicoding.picodiploma.mybottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragment: Fragment

        when (item.itemId) {
            R.id.navigation_home -> {

                fragment = HomeFragment()
                supportFragmentManager.commit {
                    replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                fragment = DashboardFragment()
                supportFragmentManager.commit {
                    replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                fragment = NotificationsFragment()
                supportFragmentManager.commit {
                    replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            navigation.selectedItemId = R.id.navigation_home
        }
    }

}
