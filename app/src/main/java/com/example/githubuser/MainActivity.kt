package com.example.githubuser

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuser.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding : ActivityMainBinding
    private val gitData: ArrayList<Repo> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gitData.addAll(ObjectData.user_repo)
        binding.rvOverview.adapter = RepoAdapter(gitData)
        binding.rvOverview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.bottomNav.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        /*to use fragment from activity we have to call supportmanager fragment*/
        val fragmentId = supportFragmentManager.findFragmentByTag(Explore::class.java.simpleName)
        when(item.itemId){
            R.id.ic_explore -> {
                if (fragmentId !is Explore){
                    supportFragmentManager
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
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
        return true
    }
}