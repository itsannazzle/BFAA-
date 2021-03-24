package com.example.githubuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuser.data.ObjectData
import com.example.githubuser.databinding.FragmentDeveloperDetailBinding


class DeveloperDetailActivity : Fragment() {
    private lateinit var binding: FragmentDeveloperDetailBinding
    private val gitData: ArrayList<Repo> = arrayListOf()
   companion object{
       /*i have to remember this, this is key, the value cant be the same,
       * cuz if it is, it will overrides it*/
       var EXTRA_TRENDING = "TRENDING"
   }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentDeveloperDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvRepo.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvRepo.adapter = RepoAdapter(gitData)
        gitData.addAll(ObjectData.user_repo)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val a = arguments?.getParcelable<TrendingDev>(EXTRA_TRENDING) as TrendingDev
        if (arguments != null){
            binding.pic.setImageResource(a.dev_img)
            binding.devName.text = a.dev_name
            binding.devUsername.text = a.dev_username
            binding.devFollowers.text = StringBuilder("${a.dev_followers} followers")
            binding.devFollowing.text = StringBuilder( "${a.dev_following} following")
            binding.devCompany.text = a.dev_comp
            binding.devLocation.text = a.dev_country
            binding.Repositories.text = StringBuilder("Repositories ${a.dev_repo}")
        }
    }


}