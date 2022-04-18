package com.example.cleanarchitectureclone.domain.usecase

import com.example.cleanarchitectureclone.domain.model.GithubRepoData
import com.example.cleanarchitectureclone.domain.repository.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


//UseCase로 담아서 사용하기 위해 inVoke fun으로 정의함.
class GetGithubReposUseCase(private val githubRepository: GithubRepository) {
    //연산자를 오버로딩 하기위해 정의
    //연산자는 이름없이 호출될 수 있다.
    operator fun invoke(
        owner: String,
        scope: CoroutineScope,
        onResult: (List<GithubRepoData>) -> Unit = {},
    ) {
        //코루틴을 사용해 API 통신을 진행
        scope.launch(Dispatchers.Main) {
            //결과값을 반환하기 위해 Deffered 사용
            val deferred = async(Dispatchers.IO) {
                githubRepository.getRepos(owner)
            }
            //결과값 전송
            onResult(deferred.await())
        }
    }

}