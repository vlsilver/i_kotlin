package com.example.vlsilverkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.vlsilverkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        drawerLayout = binding.drawerLayout
        val nav = this.findNavController(R.id.myFragment)
        NavigationUI.setupWithNavController(binding.menuDrawer,nav)
        NavigationUI.setupActionBarWithNavController(this,nav,drawerLayout)
        supportActionBar?.title ="My App"
    }

    override fun onSupportNavigateUp(): Boolean {
        val nav = this.findNavController(R.id.myFragment)
        return NavigationUI.navigateUp(nav,drawerLayout)
    }

}