package com.bafoor.dictionary.feature_dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bafoor.dictionary.feature_dictionary.data.local.entity.WordInfoEntity


@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
@TypeConverters(Convertors::class)
abstract class WordInfoDataBase : RoomDatabase() {
    abstract val wordDao : WordInfoDao
}