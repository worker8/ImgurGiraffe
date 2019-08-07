package com.worker8.imgurgiraffe.moshi.model

data class ImgurTag(
    val accent: String,
    val background_hash: String,
    val background_is_animated: Boolean,
    val description: String,
    val description_annotations: ImgurDescriptionAnnotations,
    val display_name: String,
    val followers: Int,
    val following: Boolean,
    val is_promoted: Boolean,
    val is_whitelisted: Boolean,
    val logo_destination_url: Any,
    val logo_hash: Any,
    val name: String,
    val thumbnail_hash: Any,
    val thumbnail_is_animated: Boolean,
    val total_items: Int
)
