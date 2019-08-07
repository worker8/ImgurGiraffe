package com.worker8.imgurgiraffe.moshi.param

enum class ImgurWindow {
    day, week, month, year, all;

    companion object {
        fun default() = day
    }
}
