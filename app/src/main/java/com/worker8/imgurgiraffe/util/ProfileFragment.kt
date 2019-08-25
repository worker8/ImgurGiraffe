package com.worker8.imgurgiraffe.util

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.worker8.imgurgiraffe.GatewayActivity
import com.worker8.imgurgiraffe.OnboardingActivity
import com.worker8.imgurgiraffe.R
import com.worker8.imgurgiraffe.common.session.UserSessionPreference
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        view.apply {
            this@ProfileFragment.activity?.let { _activity ->
                val userSession = UserSessionPreference.getUserSession(_activity)
                if (userSession != null) {
                    profileSignOutButton.visibility = View.VISIBLE
                    profileSignOutButton.setOnClickListener {
                        if (UserSessionPreference.clearUserSession(_activity)) {
                            startActivity(Intent(_activity, GatewayActivity::class.java))
                            _activity.finishAffinity()
                        }
                    }
                } else if (UserSessionPreference.isGuest(_activity)) {
                    profileSignInButton.visibility = View.VISIBLE
                    profileSignInButton.setOnClickListener {
                        startActivity(Intent(_activity, OnboardingActivity::class.java))
                    }
                }
            }
            profileSignOutButton.setOnClickListener {

            }
        }
        return view
    }
}
