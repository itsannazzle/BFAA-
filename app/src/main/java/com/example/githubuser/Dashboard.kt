package com.example.githubuser

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuser.data.ObjectData
import com.example.githubuser.databinding.FragmentDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class Dashboard : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private val gitData: ArrayList<Repo> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        gitData.addAll(ObjectData.user_repo)
        binding.rvOverview.adapter = RepoAdapter(gitData)
        binding.rvOverview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        navController = findNavController()
        binding.navView.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(navController.graph,binding.navDrawer)

        return binding.root
    }

}