package com.example.koinsample.data

import com.example.koinsample.model.Currency
import com.google.gson.Gson

open class LocalDataRepository(private val gson: Gson): DataRepository {
    override fun getCurrencies(jsonString: String): List<Currency> {
        return gson.fromJson(jsonString,Array<Currency>::class.java).toList()
    }
}