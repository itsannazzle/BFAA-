package com.example.githubuser

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.githubuser.databinding.FragmentExploreBinding

class Explore : Fragment() {
    /*instaciate?*/
    private lateinit var customAdapter: CustomAdapter
    private lateinit var binding : FragmentExploreBinding
    private val trendingDev = arrayListOf<TrendingDev>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Binding
        binding = FragmentExploreBinding.inflate(inflater,container,false)
        customAdapter = CustomAdapter()
        binding.listTrending.adapter = customAdapter
        addItem()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*initialize?*/

        binding.listTrending.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val bund = Bundle()
            val dd = DeveloperDetailActivity()
            bund.putParcelable(DeveloperDetailActivity.EXTRA_TRENDING,trendingDev[position])
            dd.arguments = bund
            //val fragMan = fragmentManager
            /*to replace one fragment into the other one*/
            childFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,dd,DeveloperDetailActivity::class.java.simpleName)
                addToBackStack(null)
                commit()
            }

        }
    }



    @SuppressLint("Recycle")
    private fun addItem()  {
        val dname= resources.getStringArray(R.array.name)
        val dusername= resources.getStringArray(R.array.username)
        val dimg = resources.obtainTypedArray(R.array.avatar)
        val dcomp = resources.getStringArray(R.array.company)
        val dcountry = resources.getStringArray(R.array.location)
        val dfollowers = resources.getStringArray(R.array.followers)
        val dfollowing = resources.getStringArray(R.array.following)
        val drepo = resources.getStringArray(R.array.repository)

        /*basically, this addItem is used for adding the data for the trending_dev data class*/
        for (pos in dname.indices){
            val devop = TrendingDev(
                dname[pos],
                dusername[pos],
                dimg.getResourceId(pos,-1),
                    /*i dont understand, what is the use of -1 here?*/
                    dcomp[pos],
                    dcountry[pos],
                    dfollowers[pos],
                    dfollowing[pos],
                    drepo[pos]

            )
            trendingDev.add(devop)
        }
        customAdapter.trendingDev = trendingDev
        /*this is sending the data from trending_dev data class that has been added from
        function addItem using dev object into internal variable rep in custom adapter class
        */
    }
}