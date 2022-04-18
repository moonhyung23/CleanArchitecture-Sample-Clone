package com.example.cleanarchitectureclone.data.source

import com.example.cleanarchitectureclone.data.service.GithubService
import com.example.cleanarchitectureclone.domain.model.GithubRepoData
import javax.inject.Inject

//서버 API 통신을 전담하는 DataRemote Source
interface GithubRemoteSource {
    suspend fun getRepos(owner: String): List<GithubRepoData>
}


//구현체
class GithubRemoteSourceImpl @Inject constructor(
    private val githubService: GithubService,
) : GithubRemoteSource {

    override suspend fun getRepos(owner: String): List<GithubRepoData> {
        //Retrofit API 통신을 수행
        return githubService.getReposService(owner)
    }
}