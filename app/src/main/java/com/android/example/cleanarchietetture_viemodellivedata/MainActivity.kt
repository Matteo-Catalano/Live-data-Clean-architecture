package com.android.example.cleanarchietetture_viemodellivedata

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var punkProvider : PunkProvider


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = (application as MyApplication).mainViewModelFactory.create(MainViewModel::class.java)

        observerRepos()
        viewModel.retrieveRepos("beers")

    }


    private fun observerRepos(){

        viewModel.repos.observe(this) {
            showRepos(it)
        }

        viewModel.error.observe(this) {
            Snackbar.make(
                findViewById(R.id.main_view),
                "Error:$it",
                Snackbar.LENGTH_INDEFINITE
            ).setAction("Retry") {
                viewModel.retrieveRepos("beers")
            }.show()
        }
    }

    fun showRepos(repoResults: BeersResult){
        Log.d("MainActivity", "list of repos received, size: ${repoResults.size}")
        val list = findViewById<RecyclerView>(R.id.recycle_main)
        list.visibility = View.VISIBLE
        val adapter = RepoAdapter(repoResults)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
        }

    }
