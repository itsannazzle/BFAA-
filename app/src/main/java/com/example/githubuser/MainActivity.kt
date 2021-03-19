package com.example.githubuser

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val gitData: ArrayList<repo> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv_repo : RecyclerView = findViewById(R.id.rv_overview)
        rv_repo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_repo.adapter = repo_adapter(gitData)

        gitData.addAll(object_data.user_repo)
        val bottomNav : BottomNavigationView = findViewById(R.id.bn)
        bottomNav.setOnNavigationItemSelectedListener(this)

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