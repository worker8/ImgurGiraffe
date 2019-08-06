package com.worker8.imgurclient.model

data class ImgurAdConfig(
    val highRiskFlags: List<String>,
    val safeFlags: List<String>,
    val showsAds: Boolean,
    val unsafeFlags: List<String>
)
