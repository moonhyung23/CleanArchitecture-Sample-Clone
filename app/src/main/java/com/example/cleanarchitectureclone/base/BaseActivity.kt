package com.example.cleanarchitectureclone.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel>
//Databinding 객체를  Singleton으로 사용
    (@LayoutRes private val layoutResId: Int) : AppCompatActivity(layoutResId) {
    protected lateinit var binding: T

    protected abstract val viewModel: V


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)

    }

    private fun performDataBinding() {
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    protected fun binding(action: T.() -> Unit) {
        binding.run(action)
    }

}