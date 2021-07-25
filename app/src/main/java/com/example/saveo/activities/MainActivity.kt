package com.example.saveo.activities
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.saveo.R
import com.example.saveo.fragment.LandingFragment


class MainActivity : AppCompatActivity() {
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()
    }

    private fun addFragment() {
        val baseFragment = LandingFragment()
        /*
           This is the method used to send FragmentListener from Activity to LandingFragment
        */
        supportFragmentManager.beginTransaction()
            .add(R.id.flconatiner, baseFragment, "baseFragment").addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        val fragment = fragmentManager.findFragmentById(R.id.flconatiner)
        if (fragment != null) {
            fragmentManager.beginTransaction().remove(fragment).commit()
        } else {
            super.onBackPressed()
        }

    }
}