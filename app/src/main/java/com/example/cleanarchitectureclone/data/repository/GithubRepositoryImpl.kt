package com.example.cleanarchitectureclone.data.repository

import com.example.cleanarchitectureclone.data.source.GithubRemoteSource
import com.example.cleanarchitectureclone.domain.model.GithubRepoData
import com.example.cleanarchitectureclone.domain.repository.GithubRepository
import javax.inject.Inject


//Domain 계층의 GithubRepository를 구현
//GithubRemoteSource 생성자를 주입받아 객체를 가져온다.

//만약 API를 데이터 베이스에서 저장한 뒤 로드하는
//기능을 넣고 싶다면 생성자로 GithubLocalSource를 주입받아
//유사하게 구현하면 된다.
class GithubRepositoryImpl @Inject constructor(
    //GithubRemoteSource의 getRepos함수는 List<GithubRepoData>를
    // 반환하지만 GithubRepoData는 Domain 계층의 GithubRepo를 구현하고 있기
    //때문에 별도의 변환과정없이(GithubRepoData를 구현 X) 변환이 가능하다.
    private val githubRemoteSource: GithubRemoteSource,
) : GithubRepository {
    override suspend fun getRepos(owner: String): List<GithubRepoData> {
        return githubRemoteSource.getRepos(owner)
    }
}