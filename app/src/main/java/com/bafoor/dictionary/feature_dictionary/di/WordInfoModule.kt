package com.bafoor.dictionary.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.bafoor.dictionary.feature_dictionary.data.local.Convertors
import com.bafoor.dictionary.feature_dictionary.data.local.WordInfoDataBase
import com.bafoor.dictionary.feature_dictionary.data.remote.DictionaryApi
import com.bafoor.dictionary.feature_dictionary.data.remote.DictionaryApi.Companion.BASE_URL
import com.bafoor.dictionary.feature_dictionary.data.repository.WordInfoRepositoryTemp
import com.bafoor.dictionary.feature_dictionary.data.util.GsonParser
import com.bafoor.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import com.bafoor.dictionary.feature_dictionary.domain.use_case.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {


    @Provides
    @Singleton
    fun provideWordInfoUseCase(repository : WordInfoRepository) : GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
         api : DictionaryApi,
         db : WordInfoDataBase
    ) : WordInfoRepository {
        return WordInfoRepositoryTemp(api,db.wordDao)
    }


    @Provides
    @Singleton
    fun provideWordInfoDatabase(app : Application) : WordInfoDataBase {
        return Room.databaseBuilder(
            app, WordInfoDataBase::class.java, "word_db"
        ).addTypeConverter(Convertors(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi() : DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)

    }
}