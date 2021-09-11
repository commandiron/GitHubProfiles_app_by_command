package com.demirli.a43githubprofiles.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.demirli.a43githubprofiles.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainViewModel()

        search_btn.setOnClickListener {

            val userName = username_et.text.toString()

            viewModel.getUser(userName)?.observe(this, Observer {

                userName_tv.setText(it.login)

                Glide.with(this).load(it.avatar_url).into(avatar_iv)

            })

            viewModel.getFollowers(userName)?.observe(this, Observer {

                followersCount_tv.setText(it.size.toString() + "Followers")

            })

            viewModel.getRepos(userName)?.observe(this, Observer {

                repositoryCount_tv.setText(it.size.toString() + "Repositories")

                val top4Repo = ArrayList<String>()

                if(it.size < 4){
                    for(i in 0 until it.size){
                        top4Repo.add(it[i].name)
                    }
                }else{
                    top4Repo.add(it[0].name)
                    top4Repo.add(it[1].name)
                    top4Repo.add(it[2].name)
                    top4Repo.add(it[3].name)
                }

                topFourRepository_tv.setText("Top4 Repositories: " + top4Repo.toString())
            })
        }
    }
}
