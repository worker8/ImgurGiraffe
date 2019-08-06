package com.worker8.imgurclient.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImgurResponse(
    val `data`: List<ImgurGalleryItemBase>,
    val status: Int,
    val success: Boolean
)
