package com.example.cleanarchitectureclone.di

import com.example.cleanarchitectureclone.data.repository.GithubRepositoryImpl
import com.example.cleanarchitectureclone.domain.repository.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindsGithubRepository(repository: GithubRepositoryImpl): GithubRepository


}