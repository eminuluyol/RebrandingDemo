package com.taurus.prerebrandingdemo

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentContainer = R.id.fragment_container
        supportFragmentManager
            .beginTransaction()
            .replace(fragmentContainer, MaterialComponentsShowcaseFragment())
            .commit()
    }
}
