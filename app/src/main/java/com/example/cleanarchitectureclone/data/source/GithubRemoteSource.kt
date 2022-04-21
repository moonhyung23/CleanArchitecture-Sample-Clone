package com.example.cleanarchitectureclone.data.source

import com.example.cleanarchitectureclone.data.service.GithubService
import com.example.cleanarchitectureclone.domain.model.GithubRepoData
import javax.inject.Inject

//외부 API 통신을 당담하는 인터페이스
interface GithubRemoteSource {
    suspend fun getRepos(owner: String): List<GithubRepoData>
}


//외부 API 통신 인터페이스 구현체
class GithubRemoteSourceImpl @Inject constructor(
    private val githubService: GithubService,
) : GithubRemoteSource {

    //외부 API 통신 인터페이스의 추상메서드를 Override
    override suspend fun getRepos(owner: String): List<GithubRepoData> {
        //Retrofit 외부 API 통신을 수행
        return githubService.getReposService(owner)
    }
}