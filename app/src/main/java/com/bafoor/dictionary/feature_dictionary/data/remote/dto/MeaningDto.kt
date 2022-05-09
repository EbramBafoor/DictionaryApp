package com.bafoor.dictionary.feature_dictionary.data.remote.dto


import com.bafoor.dictionary.feature_dictionary.domain.model.Meaning
import com.google.gson.annotations.Expose

data class MeaningDto(
    @Expose
    val definitions: List<DefinitionDto>,
    @Expose
    val partOfSpeech: String
) {
    fun toMeaning() : Meaning{
        return Meaning(
            definitions = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}