package com.worker8.imgurgiraffe.ui

import android.content.Intent

data class UserSession(
    val accessToken: String,
    val expiresIn: Int,
    val tokenType: String,
    val refreshToken: String,
    val accountUsername: String,
    val accountId: String
) {
    fun userSessionToString(userSession: UserSession): String {
        val sb = StringBuilder()
        userSession.apply {
            sb.append("access_token=${accessToken}")
            sb.append("&expires_in=${expiresIn}")
            sb.append("&token_type=${tokenType}")
            sb.append("&refresh_token=${refreshToken}")
            sb.append("&account_username=${accountUsername}")
            sb.append("&account_id=${accountId}")
        }
        return sb.toString()
    }

    companion object {
        fun fromKeyValueString(keyValueString: String): UserSession {
            val pairs = keyValueString.split("&")
            var accessToken = ""
            var expiresIn = -1
            var tokenType = ""
            var refreshToken = ""
            var accountUsername = ""
            var accountId = ""
            for (pair in pairs) {
                val temp = pair.split("=")
                when (temp.get(0)) {
                    "access_token" -> accessToken = temp.get(1)
                    "expires_in" -> expiresIn = temp.get(1).toInt()
                    "token_type" -> tokenType = temp.get(1)
                    "refresh_token" -> refreshToken = temp.get(1)
                    "account_username" -> accountUsername = temp.get(1)
                    "account_id" -> accountId = temp.get(1)
                }
            }
            return UserSession(
                accessToken = accessToken,
                expiresIn = expiresIn,
                tokenType = tokenType,
                refreshToken = refreshToken,
                accountUsername = accountUsername,
                accountId = accountId
            )
        }

        fun fromIntent(intent: Intent): UserSession {
            val extras = intent.extras
            var accessToken = ""
            var expiresIn = -1
            var tokenType = ""
            var refreshToken = ""
            var accountUsername = ""
            var accountId = ""
            extras?.apply {
                accessToken = getString("access_token", "")
                expiresIn = getInt("expires_in", -1)
                tokenType = getString("token_type", "")
                refreshToken = getString("refresh_token", "")
                accountUsername = getString("account_username", "")
                accountId = getString("account_id", "")
            }

            return UserSession(
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
