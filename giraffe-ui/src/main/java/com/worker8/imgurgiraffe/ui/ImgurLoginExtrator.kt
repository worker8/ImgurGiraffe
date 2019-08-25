package com.worker8.imgurgiraffe.ui

class ImgurLoginExtrator {
    companion object {
        //https://imgurgiraffe.com/callback#
        // access_token=453d4249eed9c1777d9c36eedfc40eb2f79caba3
        // &expires_in=315360000
        // &token_type=bearer
        // &refresh_token=74b03821828a3cb5afad6f3c8b6e67b546e187a3
        // &account_username=momodao
        // &account_id=112845739
        fun processUrl(url: String): UserSession {
            val startIndex = url.indexOf("#") + 1
            return UserSession.fromKeyValueString(url.substring(startIndex, url.length))
        }
    }
}
