package com.example.cleanarchitectureclone.domain.repository

import com.example.cleanarchitectureclone.domain.model.GithubRepoData


//UseCase에서 주입 받는 Repository 인터페이스
interface GithubRepository {
    //UseCase에서 실행되는 추상 메서드
    //구현체는 Data 계층의 RepositoryImpl클래스에 있음
    suspend fun getRepos(owner: String): List<GithubRepoData>
}