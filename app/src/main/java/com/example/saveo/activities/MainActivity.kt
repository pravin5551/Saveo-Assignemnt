package com.example.saveo.activities

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.saveo.R
import com.example.saveo.fragment.LandingFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        launchfragment()
    }

    private fun launchfragment() {
        val landingFragment = LandingFragment()
        /*
           This is the method used to send FragmentListener from Activity to LandingFragment
        */

        supportFragmentManager.beginTransaction().add(R.id.flContainer, landingFragment, "FragmentA")
            .commit()

    }
}