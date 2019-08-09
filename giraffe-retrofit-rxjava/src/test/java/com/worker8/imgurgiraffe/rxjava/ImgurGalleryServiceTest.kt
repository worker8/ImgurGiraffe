package com.worker8.imgurgiraffe.rxjava

import com.worker8.imgurgiraffe.rxjava.factory.ImgurTestFactory
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ImgurGalleryServiceTest {
    lateinit var imgurService: ImgurGalleryService

    @Before
    fun setup() {
        val imgurTestFactory = ImgurTestFactory(
            clientId = BuildConfig.IMGUR_API_CLIENT_ID,
            baseUrl = "https://api.imgur.com/3/"
        )
        val moshi = imgurTestFactory.buildMoshi()
        val retrofit = imgurTestFactory.buildRetrofit(moshi)
        imgurService = retrofit.create(ImgurGalleryService::class.java)
    }

    @Test
    fun galleryImages() {
        val response = imgurService.galleryImages().blockingGet()
        assertEquals(true, response.success)
    }
}
