package com.bafoor.dictionary.feature_dictionary.presentation

import com.bafoor.dictionary.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val loading : Boolean = false
)