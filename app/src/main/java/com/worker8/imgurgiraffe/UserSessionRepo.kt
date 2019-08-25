package com.worker8.imgurgiraffe

import android.content.Context
import com.worker8.imgurgiraffe.common.session.UserSessionPreference
import com.worker8.imgurgiraffe.ui.UserSession

class UserSessionRepo(val context: Context) {
    fun saveUserSession(userSession: UserSession) {
        UserSessionPreference.saveUserSession(context, userSession)
    }

    fun getUserSession() =
        UserSessionPreference.getUserSession(context)

}
