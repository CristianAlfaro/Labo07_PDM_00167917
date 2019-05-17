package com.diegoveega.labovacil.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.diegoveega.labovacil.Database.GithubRepo
import com.diegoveega.labovacil.Database.RoomDB
import com.diegoveega.labovacil.Repository.GitHubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubRepoViewModel(app: Application): AndroidViewModel(app){
    private val repository : GitHubRepoRepository

    init{
        val repoDao = RoomDB.getIntance(app).repoDao()
        repository = GitHubRepoRepository(repoDao)
    }

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repository.getAll()

    fun nukeAll() = repository.nuke()
}