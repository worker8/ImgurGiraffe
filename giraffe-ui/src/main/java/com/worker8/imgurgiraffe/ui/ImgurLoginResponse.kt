package com.worker8.imgurgiraffe.ui

import android.content.Intent

data class ImgurLoginResponse(
    val accessToken: String,
    val expiresIn: Int,
    val tokenType: String,
    val refreshToken: String,
    val accountUsername: String,
    val accountId: String
) {
    companion object {
        fun fromIntent(intent: Intent): ImgurLoginResponse {
            val extras = intent.extras
            var accessToken = ""
            var expiresIn = -1
            var tokenType = ""
            var refreshToken = ""
            var accountUsername = ""
            var accountId = ""
            extras?.apply {
                accessToken = getString("access_token")
                expiresIn = getInt("expires_in")
                tokenType = getString("token_type")
                refreshToken = getString("refresh_token")
                accountUsername = getString("account_username")
                accountId = getString("account_id")
            }

            return ImgurLoginResponse(
                accessToken = accessToken,
                expiresIn = expiresIn,
                tokenType = tokenType,
                refreshToken = refreshToken,
                accountUsername = accountUsername,
                accountId = accountId
            )
        }
    }
}
