package com.worker8.imgurgiraffe.ui

class ImgurLoginExtrator(val url: String) {

    //https://imgurgiraffe.com/callback#
    // access_token=453d4249eed9c1777d9c36eedfc40eb2f79caba3
    // &expires_in=315360000
    // &token_type=bearer
    // &refresh_token=74b03821828a3cb5afad6f3c8b6e67b546e187a3
    // &account_username=momodao
    // &account_id=112845739
    fun process(): ImgurLoginResponse {
        val startIndex = url.indexOf("#") + 1
        val pairs = url.substring(startIndex, url.length).split("&")
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
