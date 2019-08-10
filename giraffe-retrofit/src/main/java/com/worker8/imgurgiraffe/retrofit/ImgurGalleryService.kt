package com.worker8.imgurgiraffe.retrofit
import com.worker8.imgurgiraffe.moshi.model.ImgurGalleryItemBase
import com.worker8.imgurgiraffe.moshi.model.ImgurResponse
import com.worker8.imgurgiraffe.moshi.param.ImgurSection
import com.worker8.imgurgiraffe.moshi.param.ImgurSort
import com.worker8.imgurgiraffe.moshi.param.ImgurWindow

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ImgurGalleryService {
    @GET("gallery/{section}/{sort}/{window}/{page}")
    fun galleryImages(
        @Path("section")
        section: ImgurSection = ImgurSection.default(),
        @Path("sort")
        sort: ImgurSort = ImgurSort.default(),
        @Path("window")
        window: ImgurWindow = ImgurWindow.default(),
        @Path("page")
        page: Int = 0
    ): Call<ImgurResponse<ImgurGalleryItemBase>>

    @GET("gallery/{section}/{sort}/{window}/{page}")
    suspend fun galleryImages2(
        @Path("section")
        section: ImgurSection = ImgurSection.default(),
        @Path("sort")
        sort: ImgurSort = ImgurSort.default(),
        @Path("window")
        window: ImgurWindow = ImgurWindow.default(),
        @Path("page")
        page: Int = 0
    ): ImgurResponse<ImgurGalleryItemBase>
}
