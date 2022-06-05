package com.android.example.cleanarchietetture_viemodellivedata.punkApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.example.cleanarchietetture_viemodellivedata.R
import com.android.example.cleanarchietetture_viemodellivedata.punkApi.usacase.model.PunkRepository

class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val repoName: TextView
    init {
        repoName = view.findViewById(R.id.repo_name)
    }
}

class RepoAdapter(val repoResults: List<PunkRepository>) : RecyclerView.Adapter<RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val repoView =
            LayoutInflater.from(parent.context).inflate(R.layout.repolistitem, parent, false)
        return RepoViewHolder(repoView)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.repoName.text = repoResults[position].name
    }

    override fun getItemCount(): Int {
        return repoResults.size
    }
}