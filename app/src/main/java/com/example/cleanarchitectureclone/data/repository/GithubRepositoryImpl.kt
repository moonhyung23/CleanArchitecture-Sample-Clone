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
    /* 의존성 주입 추상객체 */
    private val githubRemoteSource: GithubRemoteSource,
) : GithubRepository {
    //ViewModel에서 Domain계층의 getRepos 추상함수를 실행시 구현체인 override 함수를 Data 계층에서 실행
    //핵심: 인터페이스를 통해 Data 계층과 Presentation 계층간의 접근이 가능함.
    override suspend fun getRepos(owner: String): List<GithubRepoData> {
        //Data 계층의 DataSource로 서버 API 통신관련 로직을 수행
        //-DataSource의 추상함수인 getRepos를 실행하면 Data 계층에 있는 구현체를 실행함으로써
        //-서버 API 통신 수행
        /*API 통신을 할지, Local 통신을 할지 선택 */
        return githubRemoteSource.getRepos(owner)
    }
}