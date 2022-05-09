package com.bafoor.dictionary.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.bafoor.dictionary.feature_dictionary.data.util.JsonParser
import com.bafoor.dictionary.feature_dictionary.domain.model.Meaning
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Convertors(
    private val jsonParser: JsonParser
    ) {
    @TypeConverter
    fun fromMeaningsJson(json : String) : List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meaning: List<Meaning>) : String{
        return jsonParser.toJson(
            meaning,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: "[]"
    }
}