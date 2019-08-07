package com.worker8.imgurgiraffe.moshi

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.worker8.imgurgiraffe.moshi.model.ImgurGalleryItemBase
import com.worker8.imgurgiraffe.moshi.model.ImgurResponse
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
    fun testDeserialize() {
        val types =
            Types.newParameterizedType(ImgurResponse::class.java, ImgurGalleryItemBase::class.java)

        val jsonAdapter = moshi.adapter<ImgurResponse<ImgurGalleryItemBase>>(types)
        val imgurResponse = jsonAdapter.fromJson(galleryJson)

        assertNotNull(imgurResponse)
        imgurResponse?.apply {
            assertEquals(true, success)
            assertEquals(200, status)
        }

//        imgurResponse?.data?.get(0)?.apply {
//            assertEquals("uTndhkK", id)
//            assertEquals("Windows are far too clean.", title)
//            assertEquals(null, description)
//        }
    }
}
