package com.diegoveega.labovacil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.diegoveega.labovacil.Database.GithubRepo
import com.diegoveega.labovacil.ViewModels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*

        rv_1.apply{
            adapter = myadapter
            layoutManager = llmanager
        }

         */


        val viewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)
        bt_add.setOnClickListener {
            val name = et_name.text.toString()
            if(name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }
        viewModel.getAll().observe(this, Observer { repos ->

            /*
            adapetr.changeDataSet(repos)
             */

            Log.d("LISTA DE REPOS", "___________________________________________")
            for(repo in repos){
                Log.d("LISTA DE REPOS", repo.name)
            }
        })

    }
}
