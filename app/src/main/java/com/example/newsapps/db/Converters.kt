package com.example.newsapps.db

import androidx.room.TypeConverter
import com.example.newsapps.mvvmnewsapp.Source
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromSource(value:Source): String {
        val gson = Gson()
        val type = object : TypeToken<Source>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toSource(value: String): Source {
        val gson = Gson()
        val type = object : TypeToken<Source>() {}.type
        return gson.fromJson(value, type)
    }
}