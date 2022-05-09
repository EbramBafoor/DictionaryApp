package com.bafoor.dictionary.feature_dictionary.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class LicenseX(
    @Expose
    val name: String,
    @Expose
    val url: String
)