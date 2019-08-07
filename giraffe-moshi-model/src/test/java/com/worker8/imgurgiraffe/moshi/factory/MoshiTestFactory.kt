package com.worker8.imgurgiraffe.retrofit.factory

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.worker8.imgurgiraffe.moshi.adapter.ImgurGalleryMoshiAdapter
import com.worker8.imgurgiraffe.moshi.model.ImgurGalleryItemBase
import com.worker8.imgurgiraffe.moshi.model.ImgurResponse

class MoshiTestFactory() {
    fun buildMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(ImgurGalleryMoshiAdapter())
            .build()
    }
}
