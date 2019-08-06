package com.worker8.imgurclient.param

enum class ImgurSort {
    viral, top, time, rising;

    companion object {
        fun default() = viral
    }
}
