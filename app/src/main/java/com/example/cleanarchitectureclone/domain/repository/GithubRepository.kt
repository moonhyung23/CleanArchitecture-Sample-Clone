package com.example.cleanarchitectureclone.domain.repository

import com.example.cleanarchitectureclone.domain.model.GithubRepoData



interface GithubRepository {
    //GitHub의 Repo목록을 가져오기 위한 리스트 반환
    //Retofit으로 API 통신을 통해 List를 가져온다.
    suspend fun getRepos(owner: String): List<GithubRepoData>

}