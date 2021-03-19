package com.example.githubuser

import android.content.res.TypedArray
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
    private lateinit var dname : Array<String>
    private lateinit var dusername : Array<String>
    private lateinit var dimg : TypedArray
    private lateinit var dcomp : Array<String>
    private lateinit var dcountry : Array<String>
    private lateinit var dfollowers : Array<String>
    private lateinit var dfollowing : Array<String>
    private lateinit var drepo : Array<String>
    private lateinit var tren_dev : ListView
    private val dev = arrayListOf<trending_dev>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*initialize?*/
        tren_dev = view.findViewById(R.id.trending_dev)
        adap = customAadapter()
        tren_dev.adapter = adap
        prepare()
        addItem()
        tren_dev.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, _ ->
            val bund = Bundle()
            val dd = developer_detail()
            bund.putParcelable(developer_detail.ex,dev[position])
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

    private fun prepare(){
        /*basiclly, this is putting the data into the instaciate variable from the array string resource */
        dname= resources.getStringArray(R.array.name)
        dusername= resources.getStringArray(R.array.username)
        dimg = resources.obtainTypedArray(R.array.avatar)
        dcomp = resources.getStringArray(R.array.company)
        dcountry = resources.getStringArray(R.array.location)
        dfollowers = resources.getStringArray(R.array.followers)
        dfollowing = resources.getStringArray(R.array.following)
        drepo = resources.getStringArray(R.array.repository)

    }

    private fun addItem() : ArrayList<trending_dev> {
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
    }

}