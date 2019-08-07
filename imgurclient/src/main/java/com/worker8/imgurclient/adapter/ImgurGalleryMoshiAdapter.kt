package com.worker8.imgurclient.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.worker8.imgurclient.model.ImgurGalleryAlbum
import com.worker8.imgurclient.model.ImgurGalleryImage
import com.worker8.imgurclient.model.ImgurGalleryItemBase
import com.worker8.imgurclient.model.MoshiImgurGallery

class ImgurGalleryMoshiAdapter {

    @ToJson
    internal fun toJson(imgurGalleryItemBase: ImgurGalleryItemBase): MoshiImgurGallery {
        return if (imgurGalleryItemBase is ImgurGalleryAlbum) {
            MoshiImgurGallery(
                cover = imgurGalleryItemBase.cover, // album specific
                cover_height = imgurGalleryItemBase.cover_height, // album specific
                cover_width = imgurGalleryItemBase.cover_width, // album specific
                include_album_ads = imgurGalleryItemBase.include_album_ads, // album specific
                images = imgurGalleryItemBase.images, // album specific
                images_count = imgurGalleryItemBase.images_count, // album specific
                layout = imgurGalleryItemBase.layout, // album specific
                privacy = imgurGalleryItemBase.privacy, // album specific

                animated = null, // image specific
                bandwidth = null, // image specific
                edited = null, // image specific
                gifv = null, // image specific
                has_sound = null, // image specific
                height = null, // image specific
                hls = null, // image specific
                looping = null, // image specific
                mp4 = null, // image specific
                mp4_size = null, // image specific
                width = null, // image specific
                processing = null, // image specific
                size = null, // image specific
                type = null, // image specific

                account_id = imgurGalleryItemBase.account_id,
                account_url = imgurGalleryItemBase.account_url,
                ad_config = imgurGalleryItemBase.ad_config,
                ad_type = imgurGalleryItemBase.ad_type,
                ad_url = imgurGalleryItemBase.ad_url,
                comment_count = imgurGalleryItemBase.comment_count,
                datetime = imgurGalleryItemBase.datetime,
                description = imgurGalleryItemBase.description,
                downs = imgurGalleryItemBase.downs,
                ups = imgurGalleryItemBase.ups,
                views = imgurGalleryItemBase.views,
                favorite = imgurGalleryItemBase.favorite,
                favorite_count = imgurGalleryItemBase.favorite_count,
                id = imgurGalleryItemBase.id,
                in_gallery = imgurGalleryItemBase.in_gallery,
                in_most_viral = imgurGalleryItemBase.in_most_viral,
                is_ad = imgurGalleryItemBase.is_ad,
                is_album = imgurGalleryItemBase.is_album,
                link = imgurGalleryItemBase.link,
                nsfw = imgurGalleryItemBase.nsfw,
                points = imgurGalleryItemBase.points,
                score = imgurGalleryItemBase.score,
                section = imgurGalleryItemBase.section,
                tags = imgurGalleryItemBase.tags,
                title = imgurGalleryItemBase.title,
                topic = imgurGalleryItemBase.topic,
                topic_id = imgurGalleryItemBase.topic_id
            )
        } else if (imgurGalleryItemBase is ImgurGalleryImage) {
            MoshiImgurGallery(
                cover = null, // album specific
                cover_height = null, // album specific
                cover_width = null, // album specific
                include_album_ads = null, // album specific
                images = null, // album specific
                images_count = null, // album specific
                layout = null, // album specific
                privacy = null, // album specific

                animated = imgurGalleryItemBase.animated, // image specific
                bandwidth = imgurGalleryItemBase.bandwidth, // image specific
                edited = imgurGalleryItemBase.edited, // image specific
                gifv = imgurGalleryItemBase.gifv, // image specific
                has_sound = imgurGalleryItemBase.has_sound, // image specific
                height = imgurGalleryItemBase.height, // image specific
                hls = imgurGalleryItemBase.hls, // image specific
                looping = imgurGalleryItemBase.looping, // image specific
                mp4 = imgurGalleryItemBase.mp4, // image specific
                mp4_size = imgurGalleryItemBase.mp4_size, // image specific
                width = imgurGalleryItemBase.width, // image specific
                processing = imgurGalleryItemBase.processing, // image specific
                size = imgurGalleryItemBase.size, // image specific
                type = imgurGalleryItemBase.type, // image specific

                account_id = imgurGalleryItemBase.account_id,
                account_url = imgurGalleryItemBase.account_url,
                ad_config = imgurGalleryItemBase.ad_config,
                ad_type = imgurGalleryItemBase.ad_type,
                ad_url = imgurGalleryItemBase.ad_url,
                comment_count = imgurGalleryItemBase.comment_count,
                datetime = imgurGalleryItemBase.datetime,
                description = imgurGalleryItemBase.description,
                downs = imgurGalleryItemBase.downs,
                ups = imgurGalleryItemBase.ups,
                views = imgurGalleryItemBase.views,
                favorite = imgurGalleryItemBase.favorite,
                favorite_count = imgurGalleryItemBase.favorite_count,
                id = imgurGalleryItemBase.id,
                in_gallery = imgurGalleryItemBase.in_gallery,
                in_most_viral = imgurGalleryItemBase.in_most_viral,
                is_ad = imgurGalleryItemBase.is_ad,
                is_album = imgurGalleryItemBase.is_album,
                link = imgurGalleryItemBase.link,
                nsfw = imgurGalleryItemBase.nsfw,
                points = imgurGalleryItemBase.points,
                score = imgurGalleryItemBase.score,
                section = imgurGalleryItemBase.section,
                tags = imgurGalleryItemBase.tags,
                title = imgurGalleryItemBase.title,
                topic = imgurGalleryItemBase.topic,
                topic_id = imgurGalleryItemBase.topic_id
            )
        } else {
            MoshiImgurGallery(
                cover = null, // album specific
                cover_height = null, // album specific
                cover_width = null, // album specific
                include_album_ads = null, // album specific
                images = null, // album specific
                images_count = null, // album specific
                layout = null, // album specific
                privacy = null, // album specific

                animated = null, // image specific
                bandwidth = null, // image specific
                edited = null, // image specific
                gifv = null, // image specific
                has_sound = null, // image specific
                height = null, // image specific
                hls = null, // image specific
                looping = null, // image specific
                mp4 = null, // image specific
                mp4_size = null, // image specific
                width = null, // image specific
                processing = null, // image specific
                size = null, // image specific
                type = null, // image specific

                account_id = imgurGalleryItemBase.account_id,
                account_url = imgurGalleryItemBase.account_url,
                ad_config = imgurGalleryItemBase.ad_config,
                ad_type = imgurGalleryItemBase.ad_type,
                ad_url = imgurGalleryItemBase.ad_url,
                comment_count = imgurGalleryItemBase.comment_count,
                datetime = imgurGalleryItemBase.datetime,
                description = imgurGalleryItemBase.description,
                downs = imgurGalleryItemBase.downs,
                ups = imgurGalleryItemBase.ups,
                views = imgurGalleryItemBase.views,
                favorite = imgurGalleryItemBase.favorite,
                favorite_count = imgurGalleryItemBase.favorite_count,
                id = imgurGalleryItemBase.id,
                in_gallery = imgurGalleryItemBase.in_gallery,
                in_most_viral = imgurGalleryItemBase.in_most_viral,
                is_ad = imgurGalleryItemBase.is_ad,
                is_album = imgurGalleryItemBase.is_album,
                link = imgurGalleryItemBase.link,
                nsfw = imgurGalleryItemBase.nsfw,
                points = imgurGalleryItemBase.points,
                score = imgurGalleryItemBase.score,
                section = imgurGalleryItemBase.section,
                tags = imgurGalleryItemBase.tags,
                title = imgurGalleryItemBase.title,
                topic = imgurGalleryItemBase.topic,
                topic_id = imgurGalleryItemBase.topic_id
            )
        }
    }

    @FromJson
    internal fun toImgurGalleryItemBase(moshiImgurGallery: MoshiImgurGallery): ImgurGalleryItemBase {
        return if (moshiImgurGallery.is_album) {
            ImgurGalleryAlbum(
                cover = moshiImgurGallery.cover!!, // album specific
                cover_height = moshiImgurGallery.cover_height!!, // album specific
                cover_width = moshiImgurGallery.cover_width!!, // album specific
                include_album_ads = moshiImgurGallery.include_album_ads!!, // album specific
                images = moshiImgurGallery.images!!, // album specific
                images_count = moshiImgurGallery.images_count!!, // album specific
                layout = moshiImgurGallery.layout!!, // album specific
                privacy = moshiImgurGallery.privacy!!, // album specific
                account_id = moshiImgurGallery.account_id!!,
                account_url = moshiImgurGallery.account_url!!,
                ad_config = moshiImgurGallery.ad_config,
                ad_type = moshiImgurGallery.ad_type,
                ad_url = moshiImgurGallery.ad_url,
                comment_count = moshiImgurGallery.comment_count,
                datetime = moshiImgurGallery.datetime,
                description = moshiImgurGallery.description,
                downs = moshiImgurGallery.downs,
                ups = moshiImgurGallery.ups,
                views = moshiImgurGallery.views,
                favorite = moshiImgurGallery.favorite,
                favorite_count = moshiImgurGallery.favorite_count,
                id = moshiImgurGallery.id,
                in_gallery = moshiImgurGallery.in_gallery,
                in_most_viral = moshiImgurGallery.in_most_viral,
                is_ad = moshiImgurGallery.is_ad,
                is_album = moshiImgurGallery.is_album,
                link = moshiImgurGallery.link,
                nsfw = moshiImgurGallery.nsfw,
                points = moshiImgurGallery.points,
                score = moshiImgurGallery.score,
                section = moshiImgurGallery.section!!,
                tags = moshiImgurGallery.tags,
                title = moshiImgurGallery.title,
                topic = moshiImgurGallery.topic,
                topic_id = moshiImgurGallery.topic_id
            )
        } else {
            ImgurGalleryImage(
                animated = moshiImgurGallery.animated!!, // image specific
                bandwidth = moshiImgurGallery.bandwidth!!, // image specific
                edited = moshiImgurGallery.edited!!, // image specific
                gifv = moshiImgurGallery.gifv, // image specific
                has_sound = moshiImgurGallery.has_sound!!, // image specific
                height = moshiImgurGallery.height!!, // image specific
                hls = moshiImgurGallery.hls, // image specific
                looping = moshiImgurGallery.looping, // image specific
                mp4 = moshiImgurGallery.mp4, // image specific
                mp4_size = moshiImgurGallery.mp4_size, // image specific
                width = moshiImgurGallery.width!!, // image specific
                processing = moshiImgurGallery.processing, // image specific
                size = moshiImgurGallery.size!!, // image specific
                type = moshiImgurGallery.type!!, // image specific
                account_id = moshiImgurGallery.account_id,
                account_url = moshiImgurGallery.account_url,
                ad_config = moshiImgurGallery.ad_config,
                ad_type = moshiImgurGallery.ad_type,
                ad_url = moshiImgurGallery.ad_url,
                comment_count = moshiImgurGallery.comment_count,
                datetime = moshiImgurGallery.datetime,
                description = moshiImgurGallery.description,
                downs = moshiImgurGallery.downs,
                ups = moshiImgurGallery.ups,
                views = moshiImgurGallery.views,
                favorite = moshiImgurGallery.favorite,
                favorite_count = moshiImgurGallery.favorite_count,
                id = moshiImgurGallery.id,
                in_gallery = moshiImgurGallery.in_gallery,
                in_most_viral = moshiImgurGallery.in_most_viral,
                is_ad = moshiImgurGallery.is_ad,
                is_album = moshiImgurGallery.is_album,
                link = moshiImgurGallery.link,
                nsfw = moshiImgurGallery.nsfw,
                points = moshiImgurGallery.points,
                score = moshiImgurGallery.score,
                section = moshiImgurGallery.section,
                tags = moshiImgurGallery.tags,
                title = moshiImgurGallery.title,
                topic = moshiImgurGallery.topic,
                topic_id = moshiImgurGallery.topic_id
            )
        }
    }

}


