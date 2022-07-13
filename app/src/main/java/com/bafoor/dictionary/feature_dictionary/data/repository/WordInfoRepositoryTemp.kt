package com.bafoor.dictionary.feature_dictionary.data.repository

import com.bafoor.dictionary.core.utils.Resource
import com.bafoor.dictionary.feature_dictionary.data.local.WordInfoDao
import com.bafoor.dictionary.feature_dictionary.data.remote.DictionaryApi
import com.bafoor.dictionary.feature_dictionary.domain.model.WordInfo
import com.bafoor.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WordInfoRepositoryTemp(
    private val api: DictionaryApi,
    private val db: WordInfoDataBase
) : WordInfoRepository {
    
    private val dao = db.wordDao

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {

        emit(Resource.Loading())
        val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",
                    data = wordInfos
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, please check your internet connection.",
                    data = wordInfos
                )
            )
        }
        val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(
            Resource.Success(
                newWordInfos
            )
        )
    }
}

/*

this because i dealing with cashing
<-----i get the data from api and put it into database and show it in ui----->

<----Repository main job is to take all data in my application and decide what will
     go to viewModel and show in my ui----->
 */
