package com.worker8.imgurclient

import com.squareup.moshi.Moshi
import com.worker8.imgurclient.factory.ImgurTestFactory
import com.worker8.imgurclient.model.ImgurGalleryService
import com.worker8.imgurclient.model.ImgurResponse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import java.io.BufferedReader

class GalleryDeserializationTest {
    lateinit var imgurService: ImgurGalleryService
    lateinit var moshi: Moshi

    val galleryJson: String by lazy {
        val inputStream = javaClass.classLoader.getResourceAsStream("gallery.json")
        inputStream.bufferedReader().use(BufferedReader::readText)
    }

    @Before
    fun setup() {
        val imgurTestFactory = ImgurTestFactory(
            clientId = BuildConfig.IMGUR_API_CLIENT_ID,
            baseUrl = "https://api.imgur.com/3/"
        )
        val retrofit = imgurTestFactory.buildRetrofit()
        imgurService = retrofit.create(ImgurGalleryService::class.java)
        moshi = imgurTestFactory.buildMoshi()
    }

    @Test
    fun testFirstCall() {
        val response = imgurService.galleryImages().execute()
        assertEquals(true, response.isSuccessful)
        System.out.println(galleryJson)
    }

    @Test
    fun testDeserialize() {
        val jsonAdapter = moshi.adapter<ImgurResponse>(ImgurResponse::class.java)
        val imgurResponse = jsonAdapter.fromJson(galleryJson)

        assertNotNull(imgurResponse)
        imgurResponse?.apply {
            assertEquals(true, success)
            assertEquals(200, status)
        }

        imgurResponse?.data?.get(0)?.apply {
            assertEquals("uTndhkK", id)
            assertEquals("Windows are far too clean.", title)
            assertEquals(null, description)
        }
    }
}
