package com.example.githubuser

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class repo_adapter(private val user : ArrayList<repo>) : RecyclerView.Adapter<repo_adapter.rViewHolder>() {
    inner class rViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val nama : TextView = itemView.findViewById(R.id.repo1)
        val desc : TextView = itemView.findViewById(R.id.repodesc)
        val lang : TextView = itemView.findViewById(R.id.repo_lang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): repo_adapter.rViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_card,parent,false)
        return rViewHolder(view)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: repo_adapter.rViewHolder, position: Int) {
        val u = user[position]
        holder.nama.text = u.user_repo
        holder.desc.text = u.user_repo_des
        holder.lang.text = u.user_repo_lang
        if (u.user_repo_lang == "Java"){
            holder.lang.setCompoundDrawablesWithIntrinsicBounds(holder.itemView.context.getDrawable(R.drawable.circle),null,null,null)
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