package com.worker8.imgurgiraffe.moshi.param

enum class ImgurSort {
    viral, top, time, rising;

    companion object {
        fun default() = viral
    }
}
