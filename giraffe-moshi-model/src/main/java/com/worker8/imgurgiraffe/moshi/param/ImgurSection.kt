package com.worker8.imgurgiraffe.moshi.param

enum class ImgurSection {
    hot, top, user;

    companion object {
        fun default() = hot
    }
}
