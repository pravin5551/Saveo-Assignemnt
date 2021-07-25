package com.example.saveo.model

import com.google.gson.annotations.SerializedName


data class LinksClass(

	@field:SerializedName("self")
	val self: SelfClass? = null,

	@field:SerializedName("previousepisode")
	val previousepisode: PreviousepisodeClass? = null
)