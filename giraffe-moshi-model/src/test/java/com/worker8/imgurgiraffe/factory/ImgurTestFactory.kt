package com.worker8.imgurgiraffe.factory

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.worker8.imgurgiraffe.adapter.ImgurGalleryMoshiAdapter
import com.worker8.imgurgiraffe.model.ImgurGalleryItemBase
import com.worker8.imgurgiraffe.model.ImgurResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Add Authorization Header
 */
class ImgurTestFactory(
    val clientId: String,
    val baseUrl: String = "https://api.imgur.com/3/"
) {

    fun buildOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain
                .request()
                .newBuilder()
                .apply { addHeader("Authorization", "Client-Id ${clientId}") }
                .build()
            chain.proceed(request)
        }.build()
    }

    fun buildRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(buildOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    fun buildMoshi(): Moshi {
        val types =
            Types.newParameterizedType(ImgurResponse::class.java, ImgurGalleryItemBase::class.java)
        return Moshi
            .Builder()
            .add(ImgurGalleryMoshiAdapter())
            //.add(DynamicAdapterFactory())
            .build()
    }
}
