package com.worker8.imgurgiraffe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.worker8.imgurgiraffe.ui.ImgurLoginResponse
import com.worker8.imgurgiraffe.ui.OAuthLoginActivity
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
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            //TODO: Handle RESULT_CANCEL case
            Log.d("ddw", "response from OnboardingActivity, data: ${data}")
            data?.let {
                val response = ImgurLoginResponse.fromIntent(it)
                Log.d("ddw", "response from OnboardingActivity: ${response}")
            }
        }

    }
}
