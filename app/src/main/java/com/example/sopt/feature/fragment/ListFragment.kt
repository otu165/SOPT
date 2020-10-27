package com.example.sopt.feature.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sopt.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        listFunction(view)
        return view
    }

    private fun listFunction(view : View) {
        // 1. attach repository fragment
        requireActivity().supportFragmentManager.beginTransaction().add(R.id.frameFragList, RepoFragment()).commit()

        // 2. TabLayout + Fragment
        view.tabFragList.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if(tab != null) {
                        when(tab.position) {
                            0 -> {
                                requireActivity().supportFragmentManager.beginTransaction()
                                    .replace(R.id.frameFragList, RepoFragment()).commit()
                            }

                            else -> {
                                requireActivity().supportFragmentManager.beginTransaction()
                                    .replace(R.id.frameFragList, FollowerFragment().apply {
                                        arguments = Bundle().apply {
                                            putString("id", arguments?.getString("id"))
                                        }
                                    }).commit()
                            }
                        }
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            }
        )
    }
}