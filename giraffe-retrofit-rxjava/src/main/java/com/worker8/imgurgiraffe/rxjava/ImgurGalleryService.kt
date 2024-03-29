package com.worker8.imgurgiraffe.rxjava
import com.worker8.imgurgiraffe.moshi.model.ImgurGalleryItemBase
import com.worker8.imgurgiraffe.moshi.model.ImgurResponse
import com.worker8.imgurgiraffe.moshi.param.ImgurSection
import com.worker8.imgurgiraffe.moshi.param.ImgurSort
import com.worker8.imgurgiraffe.moshi.param.ImgurWindow
import io.reactivex.Single

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
    ): Single<ImgurResponse<ImgurGalleryItemBase>>
}
