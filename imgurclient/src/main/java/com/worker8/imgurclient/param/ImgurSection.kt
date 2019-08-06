package com.worker8.imgurclient.param

enum class ImgurSection {
    hot, top, user;

    companion object {
        fun default() = hot
    }
}
