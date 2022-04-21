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
class MainViewModel @Inject constructor(
    //ViewModel에 Domain 계층의 UseCase를 주입 받는다
    private val getGithubReposUseCase: GetGithubReposUseCase,
) : BaseViewModel() {
    //쓰기, 읽기, 수정 가능
    private val _githubRepositories = MutableLiveData<List<GithubRepoData>>()

    //읽기만 가능
    val githubRepositoriesData: LiveData<List<GithubRepoData>> = _githubRepositories

    fun getGithubRepositories(owner: String) {
        /*
        Api 통신을 하기 위해 필요한 Data 계층의 구현체에 직접적으로 접근하지 않고
        UseCase안에 있는 Repository 인터페이스에 접근해서 Data 계층의 구현체에 접근한다.
       */
        //UseCase안에 있는 invoke fun이 자동으로 실행됨.
        getGithubReposUseCase(owner, viewModelScope) {
            //UseCase를 통해 API 통신을 해서 List를 반환한다.
            _githubRepositories.value = it
        }
    }
}