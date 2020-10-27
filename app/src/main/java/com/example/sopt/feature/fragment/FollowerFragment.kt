package com.example.sopt.feature.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sopt.R
import com.example.sopt.api.ServiceImpl
import com.example.sopt.data.GitFollowerData
import com.example.sopt.feature.GitActivity
import com.example.sopt.feature.gitfollower.GitFollowerAdapter
import com.example.sopt.feature.gitfollower.GitFollowerViewHolder
import kotlinx.android.synthetic.main.fragment_follower.*
import kotlinx.android.synthetic.main.fragment_follower.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_follower, container, false)

        followerFunction(view)
        return view
    }

    private fun followerFunction(view : View) {
        // 1. RecyclerView
        val rvAdapter = GitFollowerAdapter(requireContext())
        view.rvGitFollower.adapter = rvAdapter
        view.rvGitFollower.layoutManager = LinearLayoutManager(requireContext())

        // 2. data
        val call : Call<List<GitFollowerData>> = ServiceImpl.service.getFollower((activity as GitActivity).gitId)

        call.enqueue(
            object : Callback<List<GitFollowerData>> {
                override fun onFailure(call: Call<List<GitFollowerData>>, t: Throwable) {
                    Log.e("TAG", "GitFollowerActivity 서버 통신 불가")
                }

                override fun onResponse(
                    call: Call<List<GitFollowerData>>,
                    response: Response<List<GitFollowerData>>
                ) {
                    if (response.isSuccessful) {
                        //adapter에 데이터 전달
                        rvAdapter.data = response.body()!!
                        rvAdapter.notifyDataSetChanged()
                    }
                }
            }
        )

    }

}