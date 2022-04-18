package com.example.cleanarchitectureclone.data.source

import com.example.cleanarchitectureclone.data.service.GithubService
import com.example.cleanarchitectureclone.domain.model.GithubRepoData
import javax.inject.Inject

interface GithubRemoteSource {
    suspend fun getRepos(owner: String): List<GithubRepoData>
}


class GithubRemoteSourceImpl @Inject constructor(
    private val githubService: GithubService,
) : GithubRemoteSource {

    override suspend fun getRepos(owner: String): List<GithubRepoData> {
        return githubService.getRepos(owner)
    }
}