package com.example.vlsilverkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.vlsilverkotlin.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Timber.i("onCreate Called")

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.title = "My App"
        drawerLayout = binding.drawerLayout
        val nav = this.findNavController(R.id.myFragment)
        NavigationUI.setupWithNavController(binding.menuDrawer, nav)
        NavigationUI.setupActionBarWithNavController(this, nav, drawerLayout)
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        Timber.i("onSaveInstanceState Called")
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Timber.i("onStart Called")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Timber.i("onResume Called")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Timber.i("onPause Called")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Timber.i("onStop Called")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Timber.i("onDestroy Called")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Timber.i("onRestart Called")
//    }

    override fun onSupportNavigateUp(): Boolean {
        val nav = this.findNavController(R.id.myFragment)
        return NavigationUI.navigateUp(nav, drawerLayout)
    }
}