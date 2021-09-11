package com.demirli.a43githubprofiles.ui

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.demirli.a43githubprofiles.data.ApiClient
import com.demirli.a43githubprofiles.data.ApiService
import com.demirli.a43githubprofiles.model.Followers
import com.demirli.a43githubprofiles.model.Repos
import com.demirli.a43githubprofiles.model.User
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {

    private val apiService: ApiService by lazy { ApiClient.getApiService() }

    fun getUser(username: String): LiveData<User>? {
        var userLiveData: MutableLiveData<User> = MutableLiveData()

        apiService.getUser(username).enqueue(object: Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("getUser", t.message)
            }
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                userLiveData.value =response.body()
            }
        })
        return userLiveData
    }

    fun getFollowers(username: String): LiveData<List<Followers>>? {
        var followersLiveData: MutableLiveData<List<Followers>> = MutableLiveData()

        apiService.getFollowers(username).enqueue(object: Callback<List<Followers>> {
            override fun onFailure(call: Call<List<Followers>>, t: Throwable) {
                Log.e("getFollowers", t.message)
            }
            override fun onResponse(
                call: Call<List<Followers>>,
                response: Response<List<Followers>>
            ) {
                followersLiveData.value =response.body()
            }
        })
        return followersLiveData
    }

    fun getRepos(username: String): LiveData<List<Repos>>? {
        var reposLiveData: MutableLiveData<List<Repos>> = MutableLiveData()

        apiService.getRepos(username).enqueue(object: Callback<List<Repos>> {
            override fun onFailure(call: Call<List<Repos>>, t: Throwable) {
                Log.e("getRepos", t.message)
            }
            override fun onResponse(
                call: Call<List<Repos>>,
                response: Response<List<Repos>>
            ) {
                reposLiveData.value =response.body()
            }
        })
        return reposLiveData
    }
}