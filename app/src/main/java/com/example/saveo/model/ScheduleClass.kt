package com.example.saveo.model

import com.google.gson.annotations.SerializedName


data class ScheduleClass(

	@field:SerializedName("days")
	val days: List<String?>? = null,

	@field:SerializedName("time")
	val time: String? = null
)