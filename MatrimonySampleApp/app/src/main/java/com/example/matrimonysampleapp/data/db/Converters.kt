package com.example.matrimonysampleapp.data.db

import androidx.room.TypeConverter
import com.example.matrimonysampleapp.model.Profile
import com.example.matrimonysampleapp.model.Source
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }

    var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Profile> {
        if (data == null) {
            return emptyList<Profile>()
        }

        val listType = object : TypeToken<List<Profile?>?>() {}.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Profile?>?): String {
        return gson.toJson(someObjects)
    }
}