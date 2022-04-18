package com.example.cleanarchitectureclone.di

import com.example.cleanarchitectureclone.domain.repository.GithubRepository
import com.example.cleanarchitectureclone.domain.usecase.GetGithubReposUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    //ViewModel에 UseCase를 전달
    @Provides
    fun providesGetGithubReposUseCase(repository: GithubRepository):
            GetGithubReposUseCase {
        return GetGithubReposUseCase(repository)
    }

}