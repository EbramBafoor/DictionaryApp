package com.bafoor.dictionary.feature_dictionary.data.remote.dto


import com.bafoor.dictionary.feature_dictionary.domain.model.Definition
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class DefinitionDto(
    @Expose
    val antonyms: List<String>,
    @Expose
    val definition: String,
    @Expose
    val synonyms: List<Any>
) {
    fun toDefinition() : Definition{
        return Definition(
            antonyms = antonyms,
            definition = definition,
            synonyms = synonyms
        )
    }
}