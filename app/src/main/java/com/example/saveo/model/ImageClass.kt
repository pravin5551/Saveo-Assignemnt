package com.example.saveo.model

import com.google.gson.annotations.SerializedName


data class ImageClass(

    @field:SerializedName("original")
    val original: String? = null,

    @field:SerializedName("medium")
    val medium: String? = null
)