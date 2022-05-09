package com.bafoor.dictionary.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bafoor.dictionary.feature_dictionary.domain.model.Meaning
import com.bafoor.dictionary.feature_dictionary.domain.model.WordInfo

@Entity(tableName = "word_info")
data class WordInfoEntity(
    val word : String?,
    val meaning: List<Meaning>?,
    val phonetic : String?,
    @PrimaryKey val id : Int? = null
) {
    fun toWordInfo() : WordInfo {
        return WordInfo(
            meanings = meaning,
            phonetic = phonetic,
            word = word

        )
    }
}