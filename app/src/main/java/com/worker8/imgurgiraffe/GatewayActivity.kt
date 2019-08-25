package com.worker8.imgurgiraffe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.worker8.imgurgiraffe.common.session.UserSessionPreference

class GatewayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userSession = UserSessionPreference.getUserSession(this)
        val isGuest = UserSessionPreference.isGuest(this)
        Log.d("ddw", "userSession: ${userSession}")
        Log.d("ddw", "isGuest: ${isGuest}")
        if (userSession != null || isGuest) {
            Log.d("ddw","Aaaaaaa")
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Log.d("ddw","Bbbbbbbbbb")
            startActivity(Intent(this, OnboardingActivity::class.java))
        }
        finish()
    }
}
