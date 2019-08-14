package com.worker8.imgurgiraffe.moshi

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.worker8.imgurgiraffe.moshi.model.*
import com.worker8.imgurgiraffe.retrofit.factory.MoshiTestFactory

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import java.io.BufferedReader

class ImgurGalleryMoshiTest {
    lateinit var moshi: Moshi

    val galleryJson: String by lazy {
        val inputStream = javaClass.classLoader.getResourceAsStream("gallery.json")
        inputStream.bufferedReader().use(BufferedReader::readText)
    }

    @Before
    fun setup() {
        moshi = MoshiTestFactory().buildMoshi()
    }

    @Test
    fun testDeserializeGalleryImageType() {
        val types =
            Types.newParameterizedType(ImgurResponse::class.java, ImgurGalleryItemBase::class.java)

        val jsonAdapter = moshi.adapter<ImgurResponse<ImgurGalleryItemBase>>(types)
        val imgurResponse = jsonAdapter.fromJson(galleryJson)

        assertNotNull(imgurResponse)
        imgurResponse?.apply {
            assertEquals(true, success)
            assertEquals(200, status)
            assertEquals(true, imgurResponse.data.get(0) is ImgurGalleryImage)
            val image = imgurResponse.data.get(0) as ImgurGalleryImage
            image.apply {
                assertEquals("uTndhkK", id)
                assertEquals("Windows are far too clean.", title)
                assertEquals(null, description)
                assertEquals("image/gif", type)
                assertEquals(1564975836, datetime)
                assertEquals(true, animated)
                assertEquals(728, width)
                assertEquals(1578, height)
                assertEquals(38782519, size)
                assertEquals(249840, views)
                assertEquals(9689424546960, bandwidth)
                assertEquals(false, favorite)
                assertEquals(false, nsfw)
                assertEquals("facepalm", section)
                assertEquals("OctopussSevenTwo", account_url)
                assertEquals(23603129, account_id)
                assertEquals(false, is_ad)
                assertEquals(true, in_most_viral)
                assertEquals(false, has_sound)
                val tag = tags.get(0)

                tag.apply {
                    assertEquals("funny", name)
                    assertEquals("funny", display_name)
                    assertEquals(2911242, followers)
                    assertEquals(12, total_items)
                    assertEquals(false, following)
                    assertEquals(false, is_whitelisted)
                    assertEquals("9r1qCDq", background_hash)
                    assertEquals("tUX1dpv", thumbnail_hash)
                    assertEquals("633875", accent)

                    assertEquals(false, background_is_animated)
                    assertEquals(false, thumbnail_is_animated)
                    assertEquals(false, is_promoted)
                    assertEquals("LOLs, ROFLs, LMAOs", description)
                    assertEquals(null, logo_hash)
                    assertEquals(null, logo_destination_url)
                }
                val tag1 = tags.get(1)
                assertEquals(null, tag1.accent)
                assertEquals(0, ad_type)
                assertEquals("", ad_url)
                assertEquals(0, edited)
                assertEquals(true, in_gallery)
                assertEquals("No Topic", topic)
                assertEquals(29, topic_id)
                assertEquals("http://i.imgur.com/uTndhkKh.gif", link)
                assertEquals("https://i.imgur.com/uTndhkK.mp4", mp4)
                assertEquals("https://i.imgur.com/uTndhkK.gifv", gifv)
                assertEquals("https://i.imgur.com/uTndhkK.m3u8", hls)
                assertEquals(3526261, mp4_size)
                assertEquals(true, looping)
                assertEquals("completed", processing?.status)
                assertEquals(150, comment_count)
                assertEquals(764, favorite_count)
                assertEquals(1857, ups)
                assertEquals(34, downs)
                assertEquals(1823, points)
                assertEquals(1947, score)
                assertEquals(false, is_album)
            }
        }
    }

    @Test
    fun testDeserializeGalleryAlbumType() {
        val types =
            Types.newParameterizedType(ImgurResponse::class.java, ImgurGalleryItemBase::class.java)

        val jsonAdapter = moshi.adapter<ImgurResponse<ImgurGalleryItemBase>>(types)
        val imgurResponse = jsonAdapter.fromJson(galleryJson)
        assertNotNull(imgurResponse)
        imgurResponse?.apply {
            assertEquals(true, success)
            assertEquals(200, status)
            assertEquals(true, imgurResponse.data.get(1) is ImgurGalleryAlbum)
            val imgurAlbum = imgurResponse.data.get(1) as ImgurGalleryAlbum
            imgurAlbum.apply {
                assertEquals("Te3kfzo", id)
                assertEquals("Thank you for your sacrifice", title)
                assertEquals(null, description)
                assertEquals(1564972001, datetime)
                assertEquals("DdmdyUo", cover)
                assertEquals(769, cover_width)
                assertEquals(983, cover_height)
                assertEquals("Bannedito", account_url)
                assertEquals(77629027, account_id)
                assertEquals("hidden", privacy)
                assertEquals("blog", layout)
                assertEquals(54556, views)
                assertEquals("https://imgur.com/a/Te3kfzo", link)
                assertEquals(3224, ups)
                assertEquals(74, downs)
                assertEquals(3150, points)
                assertEquals(3177, score)
                assertEquals(true, is_album)
                assertEquals(false, favorite)
                assertEquals(false, nsfw)
                assertEquals("", section)
                assertEquals(238, comment_count)
                assertEquals(165, favorite_count)
                assertEquals("No Topic", topic)
                assertEquals(29, topic_id)
                assertEquals(1, images_count)
                assertEquals(true, in_gallery)
                assertEquals(false, is_ad)
                assertEquals(arrayListOf<ImgurTag>(), tags)
                assertEquals(0, ad_type)
                assertEquals("", ad_url)
                assertEquals(true, in_most_viral)
                assertEquals(false, include_album_ads)
                images.get(0).apply {
                    assertEquals("DdmdyUo", id)
                    assertEquals(null, title)
                    assertEquals(null, description)
                    assertEquals(1564971977, datetime)
                    assertEquals("image/jpeg", type)
                    assertEquals(false, animated)
                    assertEquals(769, width)
                    assertEquals(983, height)
                    assertEquals(119316, size)
                    assertEquals(57093, views)
                    assertEquals(6812108388, bandwidth)
                    assertEquals(false, favorite)
                    assertEquals(null, nsfw)
                    assertEquals(null, section)
                    assertEquals(null, account_url)
                    assertEquals(null, account_id)
                    assertEquals(false, is_ad)
                    assertEquals(false, in_most_viral)
                    assertEquals(false, has_sound)
                    assertEquals(arrayListOf<ImgurTag>(), tags)
                    assertEquals(0, ad_type)
                    assertEquals("", ad_url)
                    assertEquals(0, edited)
                    assertEquals(false, in_gallery)
                    assertEquals("https://i.imgur.com/DdmdyUo.jpg",link)
                    assertEquals(null,comment_count)
                    assertEquals(null,favorite_count)
                    assertEquals(null,ups)
                    assertEquals(null,downs)
                    assertEquals(null,points)
                    assertEquals(null,score)
                }
            }
        }
    }
}
