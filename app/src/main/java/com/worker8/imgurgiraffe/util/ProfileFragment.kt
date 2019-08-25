package com.worker8.imgurgiraffe.util

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.worker8.imgurgiraffe.GatewayActivity
import com.worker8.imgurgiraffe.R
import com.worker8.imgurgiraffe.common.session.UserSessionPreference
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        view.apply {
            profileSignOutButton.setOnClickListener {
                this@ProfileFragment.activity?.let {
                    if (UserSessionPreference.clearUserSession(it)) {
                        startActivity(Intent(it, GatewayActivity::class.java))
                        it.finishAffinity()
                    }
                }
            }
        }
        return view
    }
}
