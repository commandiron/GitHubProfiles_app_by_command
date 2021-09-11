package com.demirli.a43githubprofiles.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName


data class User(

    @SerializedName("login")
    var login: String,
    @SerializedName("avatar_url")
    var avatar_url: String

) {
}