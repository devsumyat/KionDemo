package com.example.koinsample.data

open class DataRepositoryFactory constructor(private val localDataSource: DataRepository,
                                             private val remoteDataSource : DataRepository){

    fun retrieveLocalSource() : DataRepository{
        return localDataSource
    }

    fun retrieveRemoteSource() : DataRepository{
        return remoteDataSource
    }
}