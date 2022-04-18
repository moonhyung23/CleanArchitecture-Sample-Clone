package com.example.cleanarchitectureclone.data.model

import com.example.cleanarchitectureclone.domain.model.GithubRepoData
import com.google.gson.annotations.SerializedName

data class GithubRepoDataImpl(
    @SerializedName("name") private val _name: String,
    @SerializedName("id") private val _id: String,
    @SerializedName("created_at") private val _date: String,
    @SerializedName("html_url") private val _url: String,
) : GithubRepoData {
    //get()을 통해 name, url을 매핑한다.
    override val name: String
        get() = _name
    override val url: String
        get() = _url
}