package com.example.githubuser

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuser.data.ObjectData
import com.example.githubuser.databinding.FragmentDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class Dashboard : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: FragmentDashboardBinding
    private val gitData: ArrayList<Repo> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        gitData.addAll(ObjectData.user_repo)
        binding.rvOverview.adapter = RepoAdapter(gitData)
        binding.rvOverview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.bottomNav.setOnNavigationItemSelectedListener(this)


        return binding.root
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        /*to use fragment from activity we have to call supportmanager fragment*/
        val fragmentId = childFragmentManager.findFragmentByTag(Explore::class.java.simpleName)

        when(item.itemId){
            R.id.ic_explore -> {
                if (fragmentId !is Explore){
                    childFragmentManager
                        .beginTransaction()
                        /*to begin the fragment*/
                        .add(R.id.layout_cpntainer,Explore(),Explore::class.java.simpleName)
                        /*the spesific layout that will be changed by the fragment*/
                        .addToBackStack(null)
                        /*this add back stack is for adding this fragment into back stack
                        * so when we touch the back button it will be back to the activity
                        * and not closing the app*/
                        .commit()
                    /*to commit.... its like to execute*/
                }
            }
            R.id.ic_dash -> {

            }
        }
        return true
    }
}