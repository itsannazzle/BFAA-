package com.example.githubuser

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class developer_detail : Fragment() {
    private lateinit var d_img : ImageView
    private lateinit var name : TextView
    private lateinit var uname : TextView
    private lateinit var fers : TextView
    private lateinit var fing : TextView
    private lateinit var comp : TextView
    private lateinit var loc : TextView
    private lateinit var rep : TextView
    private lateinit var rv_repo : RecyclerView
    private val gitData: ArrayList<repo> = arrayListOf()
   companion object{
       /*i have to remember this, this is key, the value cant be the same,
       * cuz if it is, it will overrides it*/
       var ex = "ex"
   }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_developer_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        d_img = view.findViewById(R.id.pic)
        name = view.findViewById(R.id.dev_name)
        uname = view.findViewById(R.id.dev_username)
        fers = view.findViewById(R.id.dev_followers)
        fing = view.findViewById(R.id.dev_following)
        comp = view.findViewById(R.id.dev_company)
        loc = view.findViewById(R.id.dev_location)
        rep = view.findViewById(R.id.Repositories)
        rv_repo = view.findViewById(R.id.rv_repo)
        user_repo()
        gitData.addAll(object_data.user_repo)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val a = arguments?.getParcelable<trending_dev>(ex) as trending_dev
        if (arguments != null){
            d_img.setImageResource(a.dev_img)
            name.text = a.dev_name
            uname.text = a.dev_username
            fers.text = "${a.dev_followers} followers"
            fing.text = "${a.dev_following} following"
            comp.text = a.dev_comp
            loc.text = a.dev_country
            rep.text = "Repositories ${a.dev_repo}"
        }
    }
    private fun user_repo() {
        rv_repo.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rv_repo.adapter = repo_adapter(gitData)
    }

}