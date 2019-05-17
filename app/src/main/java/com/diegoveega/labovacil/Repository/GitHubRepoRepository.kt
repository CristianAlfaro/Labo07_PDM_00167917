package com.diegoveega.labovacil.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.diegoveega.labovacil.Database.GithubDAO
import com.diegoveega.labovacil.Database.GithubRepo

class  GitHubRepoRepository (private  val repoDao: GithubDAO){

    @WorkerThread
    suspend  fun insert(repo: GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()
}