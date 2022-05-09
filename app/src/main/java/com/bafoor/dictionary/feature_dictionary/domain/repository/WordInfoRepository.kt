package com.bafoor.dictionary.feature_dictionary.domain.repository

import com.bafoor.dictionary.core.utils.Resource
import com.bafoor.dictionary.feature_dictionary.domain.model.WordInfo
import dagger.Provides
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word : String) : Flow<Resource<List<WordInfo>>>
}