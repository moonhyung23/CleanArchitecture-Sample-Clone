package com.example.cleanarchitectureclone.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitectureclone.databinding.ItemGithubRepoBinding
import com.example.cleanarchitectureclone.domain.model.GithubRepoData

class GithubAdapter : RecyclerView.Adapter<GithubViewHolder>() {

    private val items = mutableListOf<GithubRepoData>()

    fun setItems(items: List<GithubRepoData>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GithubViewHolder(
            ItemGithubRepoBinding.inflate(layoutInflater)
        )
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class GithubViewHolder(
    private val binding: ItemGithubRepoBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(repoData: GithubRepoData) {
        binding.repoName.text = repoData.name
        binding.repoUrl.text = repoData.url
    }
}