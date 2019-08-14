package com.worker8.imgurgiraffe.retrofit

import com.worker8.imgurgiraffe.retrofit.factory.ImgurTestFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ImgurGalleryServiceTest {
    lateinit var imgurService: ImgurGalleryService
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
        val imgurTestFactory = ImgurTestFactory(
            clientId = BuildConfig.IMGUR_API_CLIENT_ID,
            baseUrl = "https://api.imgur.com/3/"
        )
        val moshi = imgurTestFactory.buildMoshi()
        val retrofit = imgurTestFactory.buildRetrofit(moshi)
        imgurService = retrofit.create(ImgurGalleryService::class.java)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun testCoroutine() {
        runBlocking {
            launch(Dispatchers.Main) {
                // Will be launched in the mainThreadSurrogate dispatcher
                val response = imgurService.galleryImages()
                assertEquals(true, response.success)
            }
        }
    }
}
