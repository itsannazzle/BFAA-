package com.example.githubuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment

class Explore : Fragment() {
    /*instaciate?*/
    private lateinit var adap : customAadapter

    //private val dev = arrayListOf<trending_dev>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*initialize?*/
        val tren_dev : ListView = view.findViewById(R.id.trending_dev)
        val adap = customAadapter()
        tren_dev.adapter = adap
        addItem()
        tren_dev.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, _ ->
            val bund = Bundle()
            val dd = developer_detail()
            bund.putParcelable(developer_detail.ex, arrayListOf<trending_dev>()[position])
            dd.arguments = bund
            val fragMan = fragmentManager
            /*to replace one fragment into the other one*/
            fragMan?.beginTransaction()?.apply {
                replace(R.id.layout_cpntainer,dd,developer_detail::class.java.simpleName)
                addToBackStack(null)
                commit()
            }

        }
    }


    private fun addItem() : ArrayList<trending_dev> {
        val dname= resources.getStringArray(R.array.name)
        val dusername= resources.getStringArray(R.array.username)
        val dimg = resources.obtainTypedArray(R.array.avatar)
        val dcomp = resources.getStringArray(R.array.company)
        val dcountry = resources.getStringArray(R.array.location)
        val dfollowers = resources.getStringArray(R.array.followers)
        val dfollowing = resources.getStringArray(R.array.following)
        val drepo = resources.getStringArray(R.array.repository)

        val dev = arrayListOf<trending_dev>()
        /*basically, this addItem is used for adding the data for the trending_dev data class*/
        for (pos in dname.indices){
            val devop = trending_dev(
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
            dev.add(devop)
        }
        adap.rep = dev
        /*this is sending the data from trending_dev data class that has been added from
        function addItem using dev object into internal variable rep in custom adapter class
        */
        return dev
    }
}