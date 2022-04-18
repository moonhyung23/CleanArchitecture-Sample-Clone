package com.example.cleanarchitectureclone.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitectureclone.base.BaseViewModel
import com.example.cleanarchitectureclone.domain.model.GithubRepoData
import com.example.cleanarchitectureclone.domain.usecase.GetGithubReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
//ViewModel에서 Domain 계층의 유스케이스를 주입받아 데이터를 가져오게 된다.
//Presentation 계층에선 Data 계층의 의존성이 없기 때문에
//Api 통신을 하기 위해 필요한 Github API를 가져오는 구현체에 직접적으로 접근하지 못한다.

class MainViewModel @Inject constructor(
    //ViewModel에 UseCase를 넣는다.
    //invoke fun이 정의됨
    private val getGithubReposUseCase: GetGithubReposUseCase,
) : BaseViewModel() {
    //리파지토리의 상태를 관찰
    private val _githubRepositories = MutableLiveData<List<GithubRepoData>>()

    val githubRepositoriesData: LiveData<List<GithubRepoData>> = _githubRepositories

    fun getGithubRepositories(owner: String) {
        //UseCase를 통해 API 통신을 해서 List를 반환한다.
        //UseCase를 사용하기위해 invoke fun을 사용함.
        getGithubReposUseCase(owner, viewModelScope) {
            _githubRepositories.value = it
        }
    }
}