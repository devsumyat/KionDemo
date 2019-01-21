package com.example.koinsample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koinsample.data.DataRepositoryFactory
import com.example.koinsample.model.Currency


class CurrenciesViewModel constructor(private val dataRepositoryFactory: DataRepositoryFactory,
                                      private val jsonString: String) : ViewModel(){

    private val currencyLiveData = MutableLiveData<List<Currency>>()

    fun observeCurrencies(): LiveData<List<Currency>> {
        return currencyLiveData
    }

    fun retrieveCurrencies(){
        val data = dataRepositoryFactory.retrieveLocalSource().getCurrencies(jsonString)
        currencyLiveData.postValue(data)
    }
}