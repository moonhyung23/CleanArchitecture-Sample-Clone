package com.example.cleanarchitectureclone.data.repository

import com.example.cleanarchitectureclone.data.source.GithubRemoteSource
import com.example.cleanarchitectureclone.domain.model.GithubRepoData
import com.example.cleanarchitectureclone.domain.repository.GithubRepository
import javax.inject.Inject


// Domain 계층의 Repository 인터페이스를 구현한 구현체
// Data 계층의 수정이 생겨도 Domain 계층에는 수정이 생기지 않음
class GithubRepositoryImpl @Inject constructor(
    //외부 API 통신을 하기 위한 인터페이스
    private val githubRemoteSource: GithubRemoteSource,
    /* 내부 DB(Room, Realm)통신을 하고 싶으면 추가적으로 인터페이스를 정의해도됨 */

    ) : GithubRepository {
    //Domain 계층의 Repository 인터페이스의 추상메서드를 Override 했음.
    override suspend fun getRepos(owner: String): List<GithubRepoData> {
        //외부 API 통신을 실행하기 위한 인터페이스의 추상메서드
        return githubRemoteSource.getRepos(owner)
    }

}