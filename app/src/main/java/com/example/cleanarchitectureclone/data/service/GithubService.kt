package com.example.cleanarchitectureclone.data.service

import com.example.cleanarchitectureclone.domain.model.GithubRepoData
import retrofit2.http.GET
import retrofit2.http.Path

//Retrofit으로 API 통신을 할 데이터 타입과 조건을 정의한
//클래스
interface GithubService {
    @GET("users/{owner}repos")
    //Path(파마미터 이름)
    suspend fun getReposService(@Path("owner") owner: String)
            : List<GithubRepoData>
}