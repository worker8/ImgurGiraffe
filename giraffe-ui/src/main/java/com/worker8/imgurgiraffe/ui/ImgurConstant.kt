package com.worker8.imgurgiraffe.ui

internal val Callback = "https://imgurgiraffe.com/callback"
internal val OAuthUrl =
    "https://api.imgur.com/oauth2/authorize?client_id=${BuildConfig.IMGUR_API_CLIENT_ID}&client_secret=${BuildConfig.IMGUR_API_CLIENT_SECRET}&grant_type=refresh_token&response_type=token"
