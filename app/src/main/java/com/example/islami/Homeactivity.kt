package com.example.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islami.home_fragments.AhadethFragment
import com.example.islami.home_fragments.QuranFragment
import com.example.islami.home_fragments.RadioFragment
import com.example.islami.home_fragments.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.example.islami.home_fragments.QuranFragment as QuranFragment1

class Homeactivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNav = findViewById(R.id.bottomNavigationView)
        shawFragment(QuranFragment())
        bottomNav.setOnItemSelectedListener { menuItem->
            if (menuItem.itemId == R.id.icQuran) {
                shawFragment(QuranFragment())

            } else if (menuItem.itemId == R.id.icAhadeth) {
                shawFragment(AhadethFragment())

            } else if (menuItem.itemId == R.id.icSebha) {
                shawFragment(SebhaFragment())

            } else {
                shawFragment(RadioFragment())

            }
            return@setOnItemSelectedListener true
        }
    }

    private fun shawFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}