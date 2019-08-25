package com.worker8.imgurgiraffe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.worker8.imgurgiraffe.util.ProfileFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val profileFragment = ProfileFragment()
        fragmentTransaction.add(R.id.mainContainer, profileFragment)
        fragmentTransaction.commit()
    }
}

// GatewayActivity (no view) ---> not signed in ---> onboarding page ---> MainActivity
//                           ---> signed in / Guest    -----------------> MainActivity
