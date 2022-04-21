package com.example.cleanarchitectureclone.domain.model



//안드로이드의 의존성을 갖지않음.
//Data클래스로  선언시 Data 계층에서
//mapper로 변환해야 하는 별도의 연산이 필요하기 때문에
//Model을 인터페이스로 구현함.
interface GithubRepoData {
    val name: String
    val url: String
}