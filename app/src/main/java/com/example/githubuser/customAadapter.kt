package com.example.githubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class customAadapter internal constructor() : BaseAdapter(){
    internal var rep = arrayListOf<trending_dev>()
    /*rep now carry data from dev*/
    override fun getCount(): Int =  rep.size

    override fun getItem(position: Int): Any = rep[position]

    override fun getItemId(position: Int): Long = position.toLong()
    /*i dont understand what the use of this getItemMId*/

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null){
                itemView = LayoutInflater.from(parent?.context).inflate(R.layout.list_trending_dev,parent,false)
        }
        val viewholder = viewH(itemView as View)
        /*the class viewH has View const so the itemView act like View from converted view which is a View
        * confused? me too.*/
        val i = getItem(position) as trending_dev
        viewholder.bind(i)
        /*binding the data using bind funct from viewH class into the list_trending_dev layout*/
        return itemView
    }

    private inner class viewH(view : View){
        /*initializing data from the card element that we will show in listView
        * i only get this 3 data*/
        private val name : TextView  = view.findViewById(R.id.dev_name)
        private val username : TextView = view.findViewById(R.id.dev_username)
        private val img : ImageView = view.findViewById(R.id.dev_pic)
        fun bind(repo : trending_dev){
            /*setting the data from each element
            the data was coming from trending class
           */
            name.text = repo.dev_name
            username.text = repo.dev_username
            img.setImageResource(repo.dev_img)
        }
    }

}

