package com.example.saveo.model

import com.google.gson.annotations.SerializedName


data class ExternalsClass(

	@field:SerializedName("thetvdb")
	val thetvdb: Int? = null,

	@field:SerializedName("imdb")
	val imdb: String? = null,

	@field:SerializedName("tvrage")
	val tvrage: Int? = null
)