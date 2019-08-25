package com.worker8.imgurgiraffe.common.session

import android.content.Context
import com.worker8.imgurgiraffe.ui.UserSession
import com.worker8.imgurgiraffe.util.defaultPrefs
import com.worker8.imgurgiraffe.util.get
import com.worker8.imgurgiraffe.util.save

class UserSessionPreference {
    companion object {
        const val UserSessionKey = "UserSessionKey"
        const val GuestSessionKey = "GuestSessionKey"
        fun saveUserSession(context: Context, userSession: UserSession) =
            context.defaultPrefs().save(UserSessionKey, userSession.toString())

        fun getUserSession(context: Context): UserSession? {
            val userSessionString = context.defaultPrefs().get(UserSessionKey, "")
            if (userSessionString.isEmpty()) {
                return null
            } else {
                return UserSession.fromKeyValueString(userSessionString)
            }
        }

        fun clearUserSession(context: Context): Boolean {
            return context.defaultPrefs().edit().remove(UserSessionKey).commit()
        }

        fun saveGuest(context: Context) {
            context.defaultPrefs().save(GuestSessionKey, true)
        }

        fun clearGuest(context: Context) {
            context.defaultPrefs().save(GuestSessionKey, false)
        }

        fun isGuest(context: Context): Boolean {
            return context.defaultPrefs().get(GuestSessionKey, false)
        }
    }
}


