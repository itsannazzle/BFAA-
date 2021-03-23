package com.example.githubuser

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RepoAdapter(private val user : ArrayList<Repo>) : RecyclerView.Adapter<RepoAdapter.rViewHolder>() {
    inner class rViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val nama : TextView = itemView.findViewById(R.id.repo1)
        val desc : TextView = itemView.findViewById(R.id.repodesc)
        val lang : TextView = itemView.findViewById(R.id.repo_lang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoAdapter.rViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_card,parent,false)
        return rViewHolder(view)
    }


    override fun onBindViewHolder(holder: RepoAdapter.rViewHolder, position: Int) {
        val u = user[position]
        holder.nama.text = u.user_repo
        holder.desc.text = u.user_repo_des
        holder.lang.text = u.user_repo_lang
        if (u.user_repo_lang == "Java"){
            holder.lang.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(holder.itemView.context, R.drawable.circle),null,null,null)
            /*I dont know what is this setCompound means in literally but functionally, it used
            * to change the drawable thing that i have insert in the TextView*/
        } else {
            holder.lang.setCompoundDrawablesWithIntrinsicBounds(holder.itemView.context.getDrawable(R.drawable.circle2),null,null,null)
        }
    }

    override fun getItemCount(): Int {
        return user.size
    }
}