package com.worker8.imgurgiraffe

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_onboarding.*


class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val shake = AnimationUtils.loadAnimation(this, R.anim.shake)
        obLoginGiraffeImage.startAnimation(shake)
        obLoginGiraffeImage.setOnClickListener {
            obLoginGiraffeImage.startAnimation(shake)
        }
        obLoginTV.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
