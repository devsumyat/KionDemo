package com.example.koinsample.data

import com.example.koinsample.model.Currency

interface DataRepository {

    fun getCurrencies(jsonString: String) : List<Currency>
}