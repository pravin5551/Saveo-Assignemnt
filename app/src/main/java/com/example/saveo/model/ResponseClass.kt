package com.example.saveo.model


import com.google.gson.annotations.SerializedName

data class ResponseClass(

    @field:SerializedName("score")
    val score: Any? = null,

    @field:SerializedName("show")
    val show: ShowClass? = null
)