package com.example.koinsample

import com.example.koinsample.data.DataRepository
import com.example.koinsample.data.DataRepositoryFactory
import com.example.koinsample.data.LocalDataRepository
import com.example.koinsample.data.RemoteDataRepository
import com.google.gson.Gson
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }
    single { UriHelper(getProperty("currency_base_url")) }

    factory<DataRepository>("local") { LocalDataRepository(get()) }
    factory<DataRepository>("remote") { RemoteDataRepository() }

    factory { DataRepositoryFactory(get("local"),get("remote")) }
}