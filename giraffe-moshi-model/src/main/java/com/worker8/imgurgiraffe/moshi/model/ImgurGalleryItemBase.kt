package com.worker8.imgurgiraffe.moshi.model

data class ImgurGalleryAlbum(
    val cover: String, // album specific
    val cover_height: Int, // album specific
    val cover_width: Int, // album specific
    val include_album_ads: Boolean, // album specific
    val images: List<ImgurGalleryImage>, // album specific
    val images_count: Int, // album specific
    val layout: String, // album specific
    val privacy: String, // album specific

    override val account_id: Int,
    override val account_url: String,
    override val ad_config: ImgurAdConfig,
    override val ad_type: Int,
    override val ad_url: String,
    override val comment_count: Int?,
    override val datetime: Int,
    override val description: String?,
    override val downs: Int?,
    override val ups: Int?,
    override val views: Int,
    override val favorite: Boolean,
    override val favorite_count: Int?,
    override val id: String,
    override val in_gallery: Boolean,
    override val in_most_viral: Boolean,
    override val is_ad: Boolean,
    override val is_album: Boolean,
    override val link: String,
    override val nsfw: Boolean?,
    override val points: Int?,
    override val score: Int?,
    override val section: String,
    override val tags: List<ImgurTag>,
    override val title: String,
    override val topic: String,
    override val topic_id: Int
) : ImgurGalleryItemBase()

data class ImgurGalleryImage(
    val animated: Boolean, // image specific
    val bandwidth: Long, // image specific
    val edited: Int, // image specific
    val gifv: String?, // image specific
    val has_sound: Boolean, // image specific
    val height: Int, // image specific
    val hls: String?, // image specific
    val looping: Boolean? = null, // image specific
    val mp4: String?, // image specific
    val mp4_size: Int?, // image specific
    val width: Int, // image specific
    val processing: ImgurProcessing?, // image specific - seems to be only available if 'animated'
    val size: Int, // image specific
    val type: String, // image specific

    override val account_id: Int?,
    override val account_url: String?,
    override val ad_config: ImgurAdConfig,
    override val ad_type: Int,
    override val ad_url: String,
    override val comment_count: Int?,
    override val datetime: Int,
    override val description: String?,
    override val downs: Int?,
    override val ups: Int?,
    override val views: Int,
    override val favorite: Boolean,
    override val favorite_count: Int?,
    override val id: String,
    override val in_gallery: Boolean,
    override val in_most_viral: Boolean,
    override val is_ad: Boolean,
    override val is_album: Boolean,
    override val link: String,
    override val nsfw: Boolean?,
    override val section: String?,
    override val points: Int?,
    override val score: Int?,
    override val tags: List<ImgurTag>,
    override val title: String,
    override val topic: String,
    override val topic_id: Int
) : ImgurGalleryItemBase()

internal data class MoshiImgurGallery(
    // album only
    val cover: String?, // album specific
    val cover_height: Int?, // album specific
    val cover_width: Int?, // album specific
    val include_album_ads: Boolean?, // album specific
    val images: List<ImgurGalleryImage>?, // album specific
    val images_count: Int?, // album specific
    val layout: String?, // album specific
    val privacy: String?, // album specific
    // image only
    val animated: Boolean?, // image specific
    val bandwidth: Long?, // image specific
    val edited: Int?, // image specific
    val gifv: String?, // image specific
    val has_sound: Boolean?, // image specific
    val height: Int?, // image specific
    val hls: String?, // image specific
    val looping: Boolean?, // image specific
    val mp4: String?, // image specific
    val mp4_size: Int?, // image specific
    val width: Int?, // image specific
    val processing: ImgurProcessing?, // image specific
    val size: Int?, // image specific
    val type: String?, // image specific
    override val account_id: Int?,
    override val account_url: String?,
    override val ad_config: ImgurAdConfig,
    override val ad_type: Int,
    override val ad_url: String,
    override val comment_count: Int?,
    override val datetime: Int,
    override val description: String?,
    override val downs: Int?,
    override val ups: Int?,
    override val views: Int,
    override val favorite: Boolean,
    override val favorite_count: Int?,
    override val id: String,
    override val in_gallery: Boolean,
    override val in_most_viral: Boolean,
    override val is_ad: Boolean,
    override val is_album: Boolean,
    override val link: String,
    override val nsfw: Boolean?,
    override val points: Int?,
    override val score: Int?,
    override val section: String?,
    override val tags: List<ImgurTag>,
    override val title: String,
    override val topic: String,
    override val topic_id: Int
) : ImgurGalleryItemBase(
)

sealed class ImgurGalleryItemBase {
    abstract val account_id: Int?
    abstract val account_url: String?
    abstract val ad_config: ImgurAdConfig
    abstract val ad_type: Int
    abstract val ad_url: String
    abstract val comment_count: Int?
    abstract val datetime: Int
    abstract val description: String?
    abstract val downs: Int?
    abstract val ups: Int?
    abstract val views: Int
    abstract val favorite: Boolean
    abstract val favorite_count: Int?
    abstract val id: String
    abstract val in_gallery: Boolean
    abstract val in_most_viral: Boolean
    abstract val is_ad: Boolean
    abstract val is_album: Boolean
    abstract val link: String
    abstract val nsfw: Boolean?
    abstract val points: Int?
    abstract val score: Int?
    abstract val section: String?
    abstract val tags: List<ImgurTag>
    abstract val title: String
    abstract val topic: String
    abstract val topic_id: Int
}

