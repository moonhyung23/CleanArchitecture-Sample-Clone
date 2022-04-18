package com.example.cleanarchitectureclone.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.example.cleanarchitectureclone.R
import com.example.cleanarchitectureclone.base.BaseActivity
import com.example.cleanarchitectureclone.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
//BaseActivity를 구현해서 사용하는 Binding과 ViewModel을 정의
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
    //viewModel 객체를 생성
    //Hilt에서 알맞은 ViewModel을 제공함.
    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.recyclerView.adapter = GithubAdapter()


        //버튼클릭
        binding.submitBtn.setOnClickListener {
            val inputText = binding.ownerEditText.text.toString()
            viewModel.getGithubRepositories(inputText)
        }

        subscribeToLiveData()
    }


    private fun subscribeToLiveData() {
        viewModel.githubRepositoriesData.observe(this) {
            (binding.recyclerView.adapter as GithubAdapter).setItems(it)
        }
    }
}