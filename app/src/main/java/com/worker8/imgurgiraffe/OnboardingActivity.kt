package com.worker8.imgurgiraffe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.worker8.imgurgiraffe.common.session.UserSessionPreference
import com.worker8.imgurgiraffe.ui.OAuthLoginActivity
import com.worker8.imgurgiraffe.ui.UserSession
import com.worker8.imgurgiraffe.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_onboarding.*


class OnboardingActivity : AppCompatActivity() {
    val REQUEST_CODE = 9421
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val shake = AnimationUtils.loadAnimation(this, R.anim.shake)
        obLoginGiraffeImage.startAnimation(shake)
        obLoginGiraffeImage.setOnClickListener {
            obLoginGiraffeImage.startAnimation(shake)
        }
        obLoginTV.setOnClickListener {
            startActivityForResult(Intent(this, OAuthLoginActivity::class.java), REQUEST_CODE)
        }
        obGuestTV.setOnClickListener {
            UserSessionPreference.saveGuest(this)
            navigateToMain()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            //TODO: Handle RESULT_CANCEL case
            Log.d("ddw", "response from OnboardingActivity, data: ${data}")
            data?.let {
                val userSession = UserSession.fromIntent(it)
                UserSessionPreference.clearGuest(this@OnboardingActivity)
                UserSessionPreference.saveUserSession(this@OnboardingActivity, userSession)
                navigateToMain()
            }
        }

    }

    fun navigateToMain() {
        startActivity(Intent(this@OnboardingActivity, MainActivity::class.java))
        finish()
    }
}
