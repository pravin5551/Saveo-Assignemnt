package com.example.saveo.model_saveo

data class Show(
    val _links: Links?,
    val averageRuntime: Int?,
    val dvdCountry: Any?,
    val externals: Externals?,
    val genres: List<String>?,
    val id: Int?,
    val image: Image?,
    val language: String?,
    val name: String?,
    val network: Any?,
    val officialSite: String?,
    val premiered: String?,
    val rating: Rating?,
    val runtime: Int?,
    val schedule: Schedule?,
    val status: String?,
    val summary: String?,
    val type: String?,
    val updated: Int?,
    val url: String?,
    val webChannel: WebChannel?,
    val weight: Int?
)