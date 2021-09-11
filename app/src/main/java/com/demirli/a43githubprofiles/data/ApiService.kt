package com.demirli.a43githubprofiles.data

import com.demirli.a43githubprofiles.model.Followers
import com.demirli.a43githubprofiles.model.Repos
import com.demirli.a43githubprofiles.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Call<User>

    @GET("users/{username}/followers")
    fun getFollowers(@Path("username") username: String): Call<List<Followers>>

    @GET("users/{username}/repos")
    fun getRepos(@Path("username") username: String): Call<List<Repos>>

}