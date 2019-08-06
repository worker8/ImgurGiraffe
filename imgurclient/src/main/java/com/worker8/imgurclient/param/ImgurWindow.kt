package com.worker8.imgurclient.param

enum class ImgurWindow {
    day, week, month, year, all;

    companion object {
        fun default() = day
    }
}
