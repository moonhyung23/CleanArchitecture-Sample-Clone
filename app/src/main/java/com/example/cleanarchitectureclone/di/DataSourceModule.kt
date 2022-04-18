package com.example.cleanarchitectureclone.di

import com.example.cleanarchitectureclone.data.source.GithubRemoteSource
import com.example.cleanarchitectureclone.data.source.GithubRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindsGithubRemoteSource(source: GithubRemoteSourceImpl):
            GithubRemoteSource
}