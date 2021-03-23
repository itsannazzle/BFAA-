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
import com.example.githubuser.databinding.FragmentDeveloperDetailBinding


class developer_detail : Fragment() {
    private lateinit var binding: FragmentDeveloperDetailBinding
    private val gitData: ArrayList<repo> = arrayListOf()
   companion object{
       /*i have to remember this, this is key, the value cant be the same,
       * cuz if it is, it will overrides it*/
       var ex = "ex"
   }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeveloperDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.rvRepo.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvRepo.adapter = repo_adapter(gitData)
        gitData.addAll(object_data.user_repo)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val a = arguments?.getParcelable<trending_dev>(ex) as trending_dev
        if (arguments != null){
            binding.pic.setImageResource(a.dev_img)
            binding.devName.text = a.dev_name
            binding.devUsername.text = a.dev_username
            binding.devFollowers.text = "${a.dev_followers} followers"
            binding.devFollowing.text = "${a.dev_following} following"
            binding.devCompany.text = a.dev_comp
            binding.devLocation.text = a.dev_country
            binding.Repositories.text = "Repositories ${a.dev_repo}"
        }
    }


}