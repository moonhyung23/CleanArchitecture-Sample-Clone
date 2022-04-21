package com.example.cleanarchitectureclone.data.model

import com.example.cleanarchitectureclone.domain.model.GithubRepoData
import com.google.gson.annotations.SerializedName


//기획자나 사용자의 요구에 따라서 데이터가 변경될 수 있을 때 DataModel이 수정되어도
//Domain 모델에 해당하는 데이터는 영향을 주지 않는다.
data class GithubRepoDataImpl(
    @SerializedName("name") private val _name: String,
    @SerializedName("html_url") private val _url: String,
    @SerializedName("id") private val _id: String,
    @SerializedName("created_at") private val _date: String,
) : GithubRepoData {
    //Domain에서 갖고온 데이터
    override val name: String
        get() = _name
    override val url: String
        get() = _url
}