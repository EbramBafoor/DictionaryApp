package com.bafoor.dictionary.feature_dictionary.data.remote.dto
import com.bafoor.dictionary.feature_dictionary.data.local.entity.WordInfoEntity
import com.bafoor.dictionary.feature_dictionary.domain.model.WordInfo
import com.google.gson.annotations.Expose

data class WordInfoDto(
    @Expose
    val license: License,
    @Expose
    val meanings: List<MeaningDto>,
    @Expose
    val phonetic: String,
    @Expose
    val phonetics: List<PhoneticDto>,
    @Expose
    val sourceUrls: List<String>,
    @Expose
    val word: String
){
    fun toWordInfoEntity() : WordInfoEntity {
        return WordInfoEntity(
            word = word,
            meaning = meanings.map { it.toMeaning() },
            phonetic = phonetic
        )
    }
}