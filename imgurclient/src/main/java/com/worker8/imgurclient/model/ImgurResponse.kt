package com.worker8.imgurclient.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImgurResponse<T>(
    val `data`: List<T>,
    val status: Int,
    val success: Boolean
)
