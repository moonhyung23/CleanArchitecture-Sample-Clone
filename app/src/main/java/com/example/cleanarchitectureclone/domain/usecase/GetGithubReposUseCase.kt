package com.example.cleanarchitectureclone.domain.usecase

import com.example.cleanarchitectureclone.domain.model.GithubRepoData
import com.example.cleanarchitectureclone.domain.repository.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


//UseCase로 담아서 사용하기 위해 inVoke fun으로 정의함.
class GetGithubReposUseCase(private val githubRepository: GithubRepository) {
    //invoke fun -> 클래스 객체 생성시 바로 실행? (확실X)
    operator fun invoke(
        owner: String,
        scope: CoroutineScope,
        onResult: (List<GithubRepoData>) -> Unit = {},
    ) {
        //코루틴을 사용해 Retrofit API 통신을 진행
        scope.launch(Dispatchers.Main) {
            //결과값을 반환하기 위해 Deffered 사용
            val deferred = async(Dispatchers.IO) {
                //Data 계층에 접근하기 위해서 Domain모델의 인터페이스 추상함수를 사용
                //getRepos()실행시 Domain모델에 getRepos()추상함수를 구현한 override 함수가 실행된다.
                githubRepository.getRepos(owner)
            }
            //결과값 전송
            onResult(deferred.await())
        }
    }

}