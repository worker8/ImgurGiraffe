package com.worker8.imgurgiraffe

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_deeplink.*

class DeepLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deeplink)
        intent?.extras?.let {
            Log.d("ddw", "received_url = ${it.getString("received_url")}")
            deeplinkTV.text = it.getString("received_url")
            //  https://imgurgiraffe.com/callback#
            //  access_token=d4c8f4403afc04b15991f9d1990e7ab7211ffc57
            //  &expires_in=315360000
            //  &token_type=bearer
            //  &refresh_token=6b7a343f98fc1948bcc3b0512444cdcc0be22336
            //  &account_username=momodao
            //  &account_id=112845739
        }
    }
}
