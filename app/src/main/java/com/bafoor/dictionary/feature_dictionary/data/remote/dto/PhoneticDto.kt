package com.bafoor.dictionary.feature_dictionary.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class PhoneticDto(
    @Expose
    val audio: String,
    @Expose
    val license: LicenseX,
    @Expose
    val sourceUrl: String,
    @Expose
    val text: String
)