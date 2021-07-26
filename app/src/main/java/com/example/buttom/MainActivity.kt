package com.example.buttom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragmentMethod(HomeFragment())
        bottome_navigation.setOnNavigationItemSelectedListener(items)
    }

    private val items = BottomNavigationView.OnNavigationItemSelectedListener { menuItems ->
        when (menuItems.itemId) {
            R.id.nav_home -> {
                replaceFragmentMethod(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_search -> {
                replaceFragmentMethod(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_favorte -> {
                replaceFragmentMethod(FavoriteFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_person -> {
                replaceFragmentMethod(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun replaceFragmentMethod(fm: Fragment) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame_layout, fm)
        ft.commit()
    }
}