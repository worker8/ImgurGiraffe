package com.worker8.imgurclient.model

import com.worker8.imgurclient.model.ImgurResponse
import com.worker8.imgurclient.param.ImgurSection
import com.worker8.imgurclient.param.ImgurSort
import com.worker8.imgurclient.param.ImgurWindow
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
}
