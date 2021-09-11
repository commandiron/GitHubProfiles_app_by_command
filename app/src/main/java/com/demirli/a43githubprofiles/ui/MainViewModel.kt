package com.demirli.a43githubprofiles.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.demirli.a43githubprofiles.model.Followers
import com.demirli.a43githubprofiles.model.Repos
import com.demirli.a43githubprofiles.model.User

class MainViewModel(): ViewModel() {

    private val repository: MainRepository by lazy { MainRepository() }

    fun getUser(username: String): LiveData<User>? = repository.getUser(username)

    fun getFollowers(username: String): LiveData<List<Followers>>? = repository.getFollowers(username)

    fun getRepos(username: String): LiveData<List<Repos>>? = repository.getRepos(username)

}