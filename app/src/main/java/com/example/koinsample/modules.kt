package com.example.koinsample

import com.example.koinsample.data.DataRepository
import com.example.koinsample.data.DataRepositoryFactory
import com.example.koinsample.data.LocalDataRepository
import com.example.koinsample.data.RemoteDataRepository
import com.example.koinsample.presentation.CurrenciesViewModel
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }
    single { UriHelper(getProperty("currency_base_url")) }

    factory<DataRepository>("local") { LocalDataRepository(get()) }
    factory<DataRepository>("remote") { RemoteDataRepository() }

    factory { DataRepositoryFactory(get("local"),get("remote")) }
}

val browseModule = module("browse") {
    factory { CurrenciesAdapter() }
    viewModel { (jsonString: String) -> CurrenciesViewModel(get(), jsonString) }
}