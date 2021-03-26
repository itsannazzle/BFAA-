package com.example.githubuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubuser.databinding.FragmentDummyBinding


class Dummy : Fragment() {
    private lateinit var binding : FragmentDummyBinding
    private val bottomNavSelectedItemIdKey = "BOTTOM_NAV_SELECTED_ITEM_ID_KEY"
    private var bottomNavSelectedItemId = R.id.dummy_dashboard

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentDummyBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.let {
            bottomNavSelectedItemId = savedInstanceState.getInt(bottomNavSelectedItemIdKey,bottomNavSelectedItemId)
        }
    }

}